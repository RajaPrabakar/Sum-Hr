package com.sum.hr.sum.hr.JPA;

import com.sum.hr.sum.hr.MODEL.AttendanceRequest;
import com.sum.hr.sum.hr.MODEL.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRequestRepository extends JpaRepository<AttendanceRequest,Integer>
{

    List<AttendanceRequest> findByUsers_UserId(int userId);
}
