package com.zap.payment.user.service;

import com.zap.payment.user.service.controller.UserRestController;

import com.zap.payment.user.service.dto.CreateUserRequest;
import com.zap.payment.user.service.dto.UserInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserRestController.class)
public class UserRestApiTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRestController userRestController;

    @Test
    public void createOrUpdateUser() throws Exception {

        String requestJson = "{\n" +
                "  \"userId\": null,\n" +
                "  \"userName\": \"JawadT\",\n" +
                "  \"countryCode\": \"+92\",\n" +
                "  \"userInfo\": {\n" +
                "    \"firstName\": \"Jawad\",\n" +
                "    \"middleName\": null,\n" +
                "    \"lastName\": \"Tariq\",\n" +
                "    \"email\": \"abc@gmail.com\",\n" +
                "    \"imageUrl\": \"https://abc.com\",\n" +
                "    \"dob\": \"01-01-1997\"\n" +
                "  },\n" +
                "  \"phoneNumber\": \"30018847387\",\n" +
                "  \"password\": null,\n" +
                "  \"pin\": \"12455\",\n" +
                "  \"fingerPrint\": null,\n" +
                "  \"isOtpVerified\": false,\n" +
                "  \"activation\": true\n" +
                "}";

        UserInfoDto userInfoDto = new UserInfoDto();
        CreateUserRequest request = new CreateUserRequest();
        request.setUserInfo(userInfoDto);
        Mockito.when(userRestController.createOrUpdateUser(Mockito.any(CreateUserRequest.class)))
                .thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/registration/create")
                .accept(MediaType.APPLICATION_JSON).content(requestJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

}
