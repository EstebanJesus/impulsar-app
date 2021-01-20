package com.impulsar.app.api.service;

import com.impulsar.app.api.domain.UserApp;
import com.impulsar.app.api.repository.AuthorityRepository;
import com.impulsar.app.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public UserApp createUser(UserApp userAppDTO) {
        UserApp userApp = new UserApp();
        userApp.setLogin(userAppDTO.getLogin().toLowerCase());
        userApp.setFirstName(userAppDTO.getFirstName());
        userApp.setLastName(userAppDTO.getLastName());
        if (userAppDTO.getEmail() != null) {
            userApp.setEmail(userAppDTO.getEmail().toLowerCase());
        }
        userApp.setImageUrl(userAppDTO.getImageUrl());
        if (userAppDTO.getLangKey() == null) {
            userApp.setLangKey("es"); // default language
        } else {
            userApp.setLangKey(userAppDTO.getLangKey());
        }
        userRepository.save(userApp);
        return userApp;
    }

    @Transactional(readOnly = true)
    public Page<UserApp> getAllManagedUsers(Pageable pageable) {
        return userRepository.findAllByLoginNot(pageable, "anonymoususer");
    }
}
