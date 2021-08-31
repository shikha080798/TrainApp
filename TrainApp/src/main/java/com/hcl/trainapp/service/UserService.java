package com.hcl.trainapp.service;

import org.springframework.http.ResponseEntity;

import com.hcl.trainapp.dto.UserDto;
import com.hcl.trainapp.model.User;

public interface UserService {

	// String userRegister(User user);

	public ResponseEntity<?> userLogin(String userName);

	// boolean saveUserDetails(UserDto userDto);
	// public String sendEmail(Long userId,String password);
	public ResponseEntity<String> otp(Long userId, long otp);

}
