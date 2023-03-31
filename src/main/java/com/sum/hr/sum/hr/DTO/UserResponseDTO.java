package com.sum.hr.sum.hr.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO
{
    private int userId;

    private String password;

    private String userName;

    private String emailId;

    private String designation;

    private String department;

    private Boolean isAdmin;

}
