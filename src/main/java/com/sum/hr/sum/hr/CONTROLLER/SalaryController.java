package com.sum.hr.sum.hr.CONTROLLER;

import com.sum.hr.sum.hr.DTO.SalaryRequestDTO;
import com.sum.hr.sum.hr.JWTUtil;
import com.sum.hr.sum.hr.SERVICE.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SalaryController
{
    @Autowired
    private SalaryService salaryService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "/create-salary")
    public ResponseEntity<Object> postSalary(@RequestHeader(value = "authentication",defaultValue ="")String auth, @RequestBody SalaryRequestDTO salaryRequestDTO) throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = salaryService.createSalary(salaryRequestDTO,auth);
        return ResponseEntity.ok(object);
    }
    @GetMapping(value = "/get-paySlip")
    public ResponseEntity<Object> getPaySlip(@RequestHeader(value = "authentication",defaultValue ="")String auth,@Valid @RequestBody SalaryRequestDTO salaryRequestDTO) throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = salaryService.createPaySlip(salaryRequestDTO,auth);
        return ResponseEntity.ok(object);
    }
}
