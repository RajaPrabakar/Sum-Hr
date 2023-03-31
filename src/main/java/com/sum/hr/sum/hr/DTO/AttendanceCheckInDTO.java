package com.sum.hr.sum.hr.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class AttendanceCheckInDTO
{
    private LocalDate date;

    @JsonFormat(pattern = "yyyy-MMMM-dd hh:mm:ss")
    private LocalDateTime checkIn;
}
