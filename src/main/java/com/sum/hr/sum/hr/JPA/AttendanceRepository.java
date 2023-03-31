package com.sum.hr.sum.hr.JPA;

import com.sum.hr.sum.hr.MODEL.Attendance;
import com.sum.hr.sum.hr.MODEL.AttendanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer>
{
    Attendance findByUsers_UserIdAndDate(int userId,LocalDate date);
    List<Attendance> findByUsers_UserId(int userId);
    List<Attendance> findAttendanceIdByUsers_UserIdAndDate(int userId,LocalDate date);

}
