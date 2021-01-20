package com.impulsar.app.api.resources;

import com.impulsar.app.api.resources.forms.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountResource {

    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<LoginForm> authorize(@RequestBody LoginForm loginForm) {
        return new ResponseEntity<>(loginForm, HttpStatus.OK);
    }
}
