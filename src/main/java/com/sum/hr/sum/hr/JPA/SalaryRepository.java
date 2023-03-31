package com.sum.hr.sum.hr.JPA;

import com.sum.hr.sum.hr.MODEL.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer>
{
    List<Salary> findByUsers_UserId(int userId);
}
