package com.sum.hr.sum.hr.CONTROLLER;

import com.sum.hr.sum.hr.DTO.AttendanceCheckInDTO;
import com.sum.hr.sum.hr.DTO.AttendanceCheckOutDTO;
import com.sum.hr.sum.hr.DTO.AttendanceRequestDTO;
import com.sum.hr.sum.hr.JWTUtil;
import com.sum.hr.sum.hr.SERVICE.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
public class AttendanceController
{
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "/create-check-in")
    public ResponseEntity<Object> postAttendanceCheckIn(@RequestHeader(value = "authentication",defaultValue ="")String auth, @Valid @RequestBody AttendanceCheckInDTO attendanceCheckInDTO) throws Exception {
        jwtUtil.verifyJWT(auth);
        Object object = attendanceService.createCheckIn(attendanceCheckInDTO,auth);
        return ResponseEntity.ok(object);
    }
    @PostMapping(value = "/create-check-out")
    public ResponseEntity<Object> postAttendanceCheckOut(@RequestHeader(value = "authentication",defaultValue ="")String auth, @Valid @RequestBody AttendanceCheckOutDTO attendanceCheckOutDTO) throws Exception {
        jwtUtil.verifyJWT(auth);
        Object object = attendanceService.createCheckOut(attendanceCheckOutDTO,auth);
        return ResponseEntity.ok(object);
    }

    @GetMapping(value = "/get-attendance-details")
    public ResponseEntity<Object> getAttendance(@RequestHeader(value = "authentication",defaultValue ="")String auth,@Valid @RequestBody AttendanceRequestDTO attendanceRequestDTO) throws Exception {
        jwtUtil.verifyJWT(auth);
        Object object = attendanceService.getUserAttendanceDetails(attendanceRequestDTO);
        return ResponseEntity.ok(object);
    }
}
