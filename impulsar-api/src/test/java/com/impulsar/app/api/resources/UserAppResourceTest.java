package com.impulsar.app.api.resources;

import com.impulsar.app.api.annotation.CsvToUser;
import com.impulsar.app.api.domain.UserApp;
import com.impulsar.app.api.repository.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserAppResourceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc restUserMockMvc;

    @ParameterizedTest
    @CsvSource({
            "1, johndoe, johndoe@localhost, john, doe, http://placehold.it/50x50, en"
    })
    void getAllUsers(@CsvToUser UserApp userApp) throws Exception {
        userRepository.saveAndFlush(userApp);

        restUserMockMvc.perform(get("/api/users?sort=id,desc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].login").value(hasItem(userApp.getLogin())))
                .andExpect(jsonPath("$.[*].firstName").value(hasItem(userApp.getFirstName())))
                .andExpect(jsonPath("$.[*].lastName").value(hasItem(userApp.getLastName())))
                .andExpect(jsonPath("$.[*].email").value(hasItem(userApp.getEmail())))
                .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(userApp.getImageUrl())))
                .andExpect(jsonPath("$.[*].langKey").value(hasItem(userApp.getLangKey())));
    }
}
