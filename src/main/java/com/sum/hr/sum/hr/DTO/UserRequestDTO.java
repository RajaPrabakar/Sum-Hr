package com.sum.hr.sum.hr.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO
{

    private int userId;

    @NotBlank(message = "Enter the UserName !!")
    private String userName;

    @NotBlank(message = "Enter the Password !!")
    private String password;

    @Email(message = "Enter the email id !!")
    private String emailId;

    @NotBlank(message = "Enter the Designation !!")
    private String designation;

    @NotBlank(message = "Enter the Department !!")
    private String department;

    private Boolean isAdmin;
}

