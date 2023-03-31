package com.sum.hr.sum.hr.JPA;

import com.sum.hr.sum.hr.MODEL.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Integer>
{
    List<LeaveRequest> findByUsers_UserId(int userId);
}
