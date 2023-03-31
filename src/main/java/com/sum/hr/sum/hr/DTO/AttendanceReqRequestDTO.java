package com.sum.hr.sum.hr.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
public class AttendanceReqRequestDTO
{

    private int requestId;

    private int userId;

    @NotBlank(message = "Enter the Date")
    private LocalDate date;

    @NotBlank(message = "Enter the Status to update")
    private String requestStatus;
}

