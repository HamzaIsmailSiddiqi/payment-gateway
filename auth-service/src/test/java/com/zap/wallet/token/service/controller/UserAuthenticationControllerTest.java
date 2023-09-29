package com.zap.wallet.token.service.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class UserAuthenticationControllerTest {
    /*private final UserAuthenticationController controller;

    @Autowired
    public UserAuthenticationControllerTest(JwtTokenUtil tokenUtil) {
        this.controller = new UserAuthenticationController(tokenUtil);
    }

    @Test
    @DisplayName("Create authentication controller unauthorized test.")
    void createAuthenticationTokenTest_Unauthorized() throws Exception {
        JwtRequest request = new JwtRequest("BLAH", "BLAH");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.UNAUTHORIZED, actual.getStatusCode());
    }

    @Test
    @DisplayName("Create authentication controller authorized test.")
    void createAuthenticationTokenTest_Authorized() throws Exception {
        JwtRequest request = new JwtRequest("foo", "foo");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }*/
}