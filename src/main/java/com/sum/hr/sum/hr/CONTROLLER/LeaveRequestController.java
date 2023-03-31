package com.sum.hr.sum.hr.CONTROLLER;

import com.sum.hr.sum.hr.DTO.LeaveRequestDTO;
import com.sum.hr.sum.hr.JWTUtil;
import com.sum.hr.sum.hr.SERVICE.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeaveRequestController
{
    @Autowired
    private LeaveRequestService leaveRequestService;
    @Autowired
    private JWTUtil jwtUtil;
    @PostMapping(value = "/create-leave-request")
    public ResponseEntity<Object> postLeaveRequest(@RequestHeader(value = "authentication",defaultValue ="")String auth, @RequestBody LeaveRequestDTO leaveRequestDTO) throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = leaveRequestService.CreateLeaveRequest(leaveRequestDTO,auth);
        return ResponseEntity.ok(object);
    }

    @PutMapping(value = "/update-leave-request")
    public ResponseEntity<Object> updateLeave(@RequestHeader(value = "authentication",defaultValue ="")String auth, @RequestBody LeaveRequestDTO leaveRequestDTO)throws Exception
    {
        jwtUtil.verifyJWT(auth);
        Object object = leaveRequestService.approveRequest(leaveRequestDTO,auth);
        return ResponseEntity.ok(object);
    }

}
