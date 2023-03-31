package com.sum.hr.sum.hr.CONTROLLER;

import com.sum.hr.sum.hr.DTO.UserRequestDTO;
import com.sum.hr.sum.hr.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create-users")
    public ResponseEntity<Object> postAdmin(@RequestBody UserRequestDTO userRequestDTO)
    {
        Object user = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/create-user-login")
    public ResponseEntity<Object> postLogin(@RequestBody UserRequestDTO userRequestDTO)
    {
        Object object = userService.generateToken(userRequestDTO);
        return ResponseEntity.ok(object);
    }
    @GetMapping(value = "/get-users")
    public ResponseEntity<Object> getUsers(@RequestBody UserRequestDTO userRequestDTO)
    {
        Object object = userService.getUserDetail(userRequestDTO);
        return ResponseEntity.ok(object);
    }
    @GetMapping("/get-all-users")
    public ResponseEntity<Object> getAllUsers()
    {
        Object object =userService.getAll();
        return ResponseEntity.ok(object);
    }
}
