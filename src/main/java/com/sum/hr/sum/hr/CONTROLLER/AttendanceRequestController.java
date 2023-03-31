package com.sum.hr.sum.hr.CONTROLLER;

import com.sum.hr.sum.hr.DTO.AttendanceReqRequestDTO;
import com.sum.hr.sum.hr.JWTUtil;
import com.sum.hr.sum.hr.SERVICE.AttendanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendanceRequestController
{
    @Autowired
    private AttendanceRequestService attendanceRequestService;
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping(value = "/create-attendance-request")
    public ResponseEntity<Object> postAttendanceRequest(@RequestHeader(value = "authentication",defaultValue ="")String auth, @RequestBody AttendanceReqRequestDTO attendanceReqRequestDTO) throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = attendanceRequestService.createAttendanceRequest(attendanceReqRequestDTO,auth);
        return ResponseEntity.ok(object);
    }

    @PutMapping(value = "/update-attendance-request")
    public ResponseEntity<Object> putApproved(@RequestHeader(value = "authentication",defaultValue ="")String auth, @RequestBody AttendanceReqRequestDTO attendanceReqRequestDTO) throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = attendanceRequestService.approveRequest(attendanceReqRequestDTO,auth);
        return ResponseEntity.ok(object);
    }
}
