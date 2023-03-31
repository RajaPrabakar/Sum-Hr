package com.sum.hr.sum.hr.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
@Data
public class AttendanceCheckOutDTO
{
    private LocalDate date;

    @JsonFormat(pattern = "yyyy-MMMM-dd hh:mm:ss")
    private LocalDateTime checkOut= LocalDateTime.now().plus(Duration.of(480, ChronoUnit.MINUTES));
}
