package com.impulsar.app.api.resources;

import com.impulsar.app.api.domain.UserApp;
import com.impulsar.app.api.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserApp> createUser(@RequestBody UserApp userAppDTO) throws URISyntaxException {
        UserApp newUserApp = userService.createUser(userAppDTO);
        return ResponseEntity.created(new URI("/api/users/" + newUserApp.getLogin())).body(newUserApp);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserApp>> getAllUsers(Pageable pageable) {
        final Page<UserApp> page = userService.getAllManagedUsers(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
}
