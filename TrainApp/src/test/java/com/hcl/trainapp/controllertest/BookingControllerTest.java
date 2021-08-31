package com.hcl.trainapp.controllertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


import com.hcl.trainapp.controller.BookingController;
import com.hcl.trainapp.dto.BookingRequestDto;
import com.hcl.trainapp.exception.NotBookedException;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Booking;
import com.hcl.trainapp.model.Passengers;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.service.BookingService;
import com.hcl.trainapp.serviceimpl.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)

public class BookingControllerTest {

	@Mock
	BookingService iBookingService;
	
	@InjectMocks
	BookingController bookingController;
	
	static Train train;
	static User user;
	static Booking booking;
	static List<Booking> bookingList;
	static List<BookingRequestDto> bookingDtoList;
	static BookingRequestDto bookingRequestDto;
	@BeforeAll
	public static void setUp() {
			
		    user=new User();
		    user.setUserName("abha");
		    user.setPassword("abha@123");
		    user.setMailId("abha@gmail.com");
		    user.setMobileNo("87887779988");
		   	        
			train=new Train();
	        train.setTrainId(1);
	        train.setTrainName("shatabdi");
	        train.setTrainNumber(452668);
	        train.setFromsource("faridabad");
	        train.setTodestination("bangalore");
	        train.setCost_single_seats(300);
	        train.setSeats(500);
	        
	        List<Passengers> passengerList=new ArrayList<Passengers>();
	        passengerList.add(new Passengers());
	   	               
	        booking=new Booking();
	        booking.setBookingId(1);
	        booking.setDate(LocalDate.now());
	        booking.setPrice_total(1200);
	        booking.setTrain(train);
	        booking.setUser(user);
	        booking.setPassengerList(passengerList);   

	}
	
	@Test
	@DisplayName("AddBookingTrain :Positive Scenario")
	public void testAddBooking3() throws UserDefinedException, TrainNotFoundException  {
		when(iBookingService.bookTicket(bookingRequestDto)).thenReturn("booking done successfully");
		ResponseEntity<String> result= bookingController.bookTicket(bookingRequestDto);
		assertEquals("booking done successfully",result.getBody());

	}
	
	
	@Test
	@DisplayName("AddBooking :Negative Scenario")
	public void testAddBooking4() throws Exception {
		when(iBookingService.bookTicket(bookingRequestDto)).thenThrow(UserDefinedException.class);
		assertThrows(UserDefinedException.class, ()->bookingController.bookTicket(bookingRequestDto));

	}
	
	@Test
	@DisplayName("get history: positive case")
	public void history() throws UserDefinedException, NotBookedException  {
		
		when(iBookingService.getTicketsbyId(1L)).thenReturn(bookingList);
		
		assertEquals(bookingDtoList,bookingController.getTicketsbyId(1L));
	}
	
	@Test
	@DisplayName("get history: negative case")
	public void history1() throws UserDefinedException, NotBookedException {
		
		when(iBookingService.getTicketsbyId(1L)).thenThrow(UserDefinedException.class);
		
		assertThrows(UserDefinedException.class,()->bookingController.getTicketsbyId(1L));
	}
}
