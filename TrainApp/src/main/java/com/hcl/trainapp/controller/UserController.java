package com.hcl.trainapp.controller;
import javax.validation.Valid;
import javax.validation.constraints.Min;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.trainapp.dto.UserDto;
import com.hcl.trainapp.dto.UserOtpDto;
import com.hcl.trainapp.serviceimpl.UserServiceImpl;
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    static Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/users/otp")
    public ResponseEntity<String> otpvalidate(@Valid  @RequestBody UserOtpDto userOtpDto) {
        logger.info("Logged in by User into system");
        return userService.otp(userOtpDto.getUserId(),userOtpDto.getOtp());
    }
    @PostMapping("/users")
    public ResponseEntity<?> sendotp(@RequestBody  @Valid UserDto userDto){
        logger.info("Otp for Login purpose");
        return userService.userLogin(userDto.getUserName());
    
    }

 

    
    }



