package com.sum.hr.sum.hr.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
public class LeaveRequestDTO
{
    private int leaveId;

    private int userId;

    @NotBlank(message = "Enter the Date")
    private LocalDate date;

    @NotBlank(message = "Enter the Reason to update")
    private String requestReason;

    @NotBlank(message = "Enter the Status to update")
    private String status;
}
