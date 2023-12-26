package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class LoginController {

    @GetMapping("/getUser")
    public String getUser(){
        return "Hello World!";
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO userDTO){
        log.info(userDTO.toString());
        return userDTO;
    }
}
