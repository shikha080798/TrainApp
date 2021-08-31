package com.hcl.trainapp.controllertest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

import com.hcl.trainapp.controller.UserController;
import com.hcl.trainapp.dto.UserDto;
import com.hcl.trainapp.dto.UserOtpDto;
import com.hcl.trainapp.exception.InvalidCredentialsException;
import com.hcl.trainapp.exception.UserIdNotFoundException;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Mock
	UserServiceImpl userService;
	@InjectMocks
	UserController userController;
	static User user;
	static UserDto userDto;
	static SimpleMailMessage msg;
	static UserOtpDto userOtpDto;

	@BeforeAll
	public static void setUp() {
		user = new User();
		user.setUserId(1L);
		user.setUserName("virat");
		user.setMobileNo("9908176684");
		user.setMailId("mucharla.naveen98@gmail.com");
		user.setOtp(7893749L);
		List<UserOtpDto> userOtpData = new ArrayList<UserOtpDto>();
		userOtpData.getClass();

		msg = new SimpleMailMessage();
		msg.setFrom("mucharla.naveen98@gmail.com");
		msg.setTo("mvnnaveen1998@gmail.com");
		msg.setSubject("Check Otp");
		msg.setText("This is your logign otp" + user.getOtp());
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("LoginFunction:Positive Senario") public void loginTest() {
	 * when(userService.userLogin("virat")).thenReturn( new
	 * ResponseEntity<>("This is Your UserId"+user.getUserId(),HttpStatus.OK));
	 * ResponseEntity<String> result=userController.sendotp(userDto);
	 * verify(userService).userLogin("virat");
	 * assertEquals("this is userid"+user.getUserId(),result.getBody());
	 * assertEquals(HttpStatus.OK,result.getStatusCode()); }
	 */
	@Test
	@DisplayName("LoginFunctino Name:negative Scenario")
	public void loginTest1() {
		when(userService.userLogin("virat")).thenThrow(UserIdNotFoundException.class);
		assertThrows(UserIdNotFoundException.class, () -> userController.sendotp(userDto));
	}

	@Test
	@DisplayName("OTp Validation:Positive scenario")
	public void otpvalidtest() {
		when(userService.otp(1L, 7893749L)).thenReturn(new ResponseEntity<String>("Login Success", HttpStatus.OK));
		ResponseEntity<String> result = userController.otpvalidate(userOtpDto);
		verify(userService).otp(1L, 7893749L);
		assertEquals("Login Success", result.getBody());
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	@DisplayName("OTp Validation:Negative scenario")
	public void otpvalidTest1() {
		when(userService.otp(1L, 7893749L)).thenThrow(InvalidCredentialsException.class);
		assertThrows(InvalidCredentialsException.class, () -> userController.otpvalidate(userOtpDto));
	}

	@Test
	@DisplayName("otp validation Negative")
	public void otpvalidTest2() {
		when(userService.otp(1L, 7893749L)).thenThrow(InvalidCredentialsException.class);
		assertThrows(InvalidCredentialsException.class, () -> userController.otpvalidate(userOtpDto));
	}

}
