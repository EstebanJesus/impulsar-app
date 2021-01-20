package com.impulsar.app.api.repository;

import com.impulsar.app.api.domain.UserApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link UserApp} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserApp, String> {

    String USERS_BY_LOGIN_CACHE = "usersByLogin";
    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<UserApp> findOneByLogin(String login);

    Optional<UserApp> findOneWithAuthoritiesByLogin(String login);

    Page<UserApp> findAllByLoginNot(Pageable pageable, String login);
}
