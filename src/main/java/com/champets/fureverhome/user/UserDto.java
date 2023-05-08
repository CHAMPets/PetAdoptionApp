package com.champets.fureverhome.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    private Long id;
    @NotEmpty(message = "User email address should not be empty.")
    private String emailAddress;
    @NotEmpty(message = "User password should not be empty.")
    private String password;
    @NotEmpty(message = "User phone number should not be empty.")
    private String phoneNumber;
    @NotEmpty(message = "User first name should not be empty.")
    private String firstName;
    @NotEmpty(message = "User last name should not be empty.")
    private String lastName;
    @NotEmpty(message = "User role id should not be empty.")
    private Long roleId;

    private LocalDate lastDateModified;

    private String createdBy;

    private String lastModifiedBy;

    private LocalDate createdDate;
}
