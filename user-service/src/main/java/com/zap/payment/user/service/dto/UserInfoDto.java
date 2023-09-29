package com.zap.payment.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class UserInfoDto implements Serializable {

    @NotEmpty(message = "First Name is required.")
    private String firstName;
    @NotEmpty(message = "Middle Name is required.")
    private String middleName;
    @NotEmpty(message = "Last Name is required.")
    private String lastName;
    @Email
    private String email;
    @NotEmpty(message = "Image URL is required.")
    private String imageUrl;
    @NotEmpty(message = "DOB is required.")
    private String dob;

}
