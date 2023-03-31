package com.sum.hr.sum.hr.MODEL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance")
@Builder
public class Attendance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    private LocalDate date;

    private String status;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    @ManyToOne
    private Users users;


}
