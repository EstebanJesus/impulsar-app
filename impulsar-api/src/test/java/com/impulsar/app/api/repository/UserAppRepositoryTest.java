package com.impulsar.app.api.repository;

import com.impulsar.app.api.annotation.CsvToUser;
import com.impulsar.app.api.domain.UserApp;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserAppRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @ParameterizedTest
    @CsvSource({
            "4, anonymoususer, johndoe@localhost, john, doe, http://placehold.it/50x50, en"
    })
    void assertThatAnonymousUserIsNotGet(@CsvToUser UserApp userApp) {
        if (userRepository.findOneByLogin("anonymoususer").isEmpty()) {
            userRepository.saveAndFlush(userApp);
        }

        long count = userRepository.count();

        assertThat(count).isEqualTo(4L);
    }

}
