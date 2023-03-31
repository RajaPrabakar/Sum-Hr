package com.sum.hr.sum.hr.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
public class AttendanceRequestDTO
{
    private int attendanceId;

    private int userId;

    @NotBlank(message = "Enter the Month to Fetch Details")
    private String date;

    private String status;

    @JsonFormat (pattern = "yyyy-MMMM-dd hh:mm:ss")
    private LocalDateTime checkIn;

    @JsonFormat (pattern = "yyyy-MMMM-dd hh:mm:ss")
    private LocalDateTime checkOut= LocalDateTime.now().plus(Duration.of(480, ChronoUnit.MINUTES));


}
