package com.zap.payment.user.service.controller;

import com.zap.payment.user.service.dto.CreateUserRequest;
import com.zap.payment.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "registration/create", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> createOrUpdateUser(@RequestBody @Validated CreateUserRequest request) {
        userService.createUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
