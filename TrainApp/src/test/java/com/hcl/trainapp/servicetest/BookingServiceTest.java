package com.hcl.trainapp.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.trainapp.dto.BookingRequestDto;
import com.hcl.trainapp.exception.NotBookedException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Booking;
import com.hcl.trainapp.model.Passengers;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.repository.BookingRepository;
import com.hcl.trainapp.repository.TrainRepository;
import com.hcl.trainapp.repository.UserRepository;
import com.hcl.trainapp.service.BookingService;
import com.hcl.trainapp.service.TrainService;
import com.hcl.trainapp.serviceimpl.BookingServiceImpl;
import com.hcl.trainapp.serviceimpl.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
	@Mock
	BookingRepository bookingRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	TrainRepository trainRepository;

	@InjectMocks
	BookingServiceImpl bookingService;

	static User user;

	static Train train;
	static Booking booking;

	static BookingRequestDto bookingRequestDto;
	static Passengers passengers;
	
	static List<Passengers> passengers1;

	@BeforeAll
	public static void setup() {
		user = new User();
		user.setMailId("geeya@gmail.com");
		user.setMobileNo("8328497445");
		user.setOtp(1234L);
		user.setUserId(1L);
		user.setUserName("geeta");

		train = new Train();
		train.setCost_single_seats(500);
		train.setDate(LocalDate.now());
		train.setFromsource("delhi");
		train.setTodestination("hyderabad");
		train.setSeats(32);
		train.setTrainId(1);
		train.setTrainName("chennai express");
		train.setTrainNumber(123457);

		passengers = new Passengers();
		passengers.setAadharNo(876867L);
		passengers.setName("geeta");
		passengers.setAge(30);
		passengers.setPassengerId(2);

		List<Passengers> passenger = new ArrayList<Passengers>();
		passenger.add(passengers);

		booking = new Booking();
		booking.setBookingId(1);
		booking.setDate(LocalDate.now());
		booking.setPassengerList(passenger);
		booking.setPrice_total(passenger.size() * train.getCost_single_seats());
		booking.setTrain(train);
		booking.setUser(user);

	}

	@Test
	@DisplayName("History of Booking:Positive Booking")
	public void getTicketsbyId() throws UserDefinedException, NotBookedException {
		List<Booking> b = new ArrayList<Booking>();
		b.add(booking);
		when(userRepository.existsById(1L)).thenReturn(true);
		when(bookingRepository.getTicketsbyId(1L)).thenReturn(b);
		List<Booking> result = bookingService.getTicketsbyId(1L);
		assertEquals(b, result);
		
	}

	@Test
	@DisplayName("History of Booking:Negative Booking")
	public void getTicketsbyId1() throws UserDefinedException {

		when(userRepository.existsById(1L)).thenReturn(false);
		assertThrows(UserDefinedException.class, () -> bookingService.getTicketsbyId(1L));

	}

//	@Test
//	@DisplayName("AddBooking:Positive Booking")
//	public void addBooking1() throws UserNotExistedException, TrainNotExistedException {
//		when(userRepository.existsById(1l)).thenReturn(true);
//		when(trainRepository.existsById(1l)).thenReturn(true);
//		when(userRepository.findByUserId(bookingRequestDto.getUserId())).thenReturn(user);
//		when(userRepository.getById(1L)).thenReturn(user);
//		when(trainRepository.getById(1L)).thenReturn(train);	
//		when(bookingRepository.save(booking)).thenReturn(booking);
//		assertEquals("Booking done successfully",bookingService.bookTicket(bookingRequestDto));
//	}
	
//	@Test
//	@DisplayName("AddBooking:Negative Booking1")
//	public void addBooking2() throws IrctcException {
//		when(userRepository.existsById(1)).thenReturn(false);
//		assertThrows(IrctcException.class,()->bookingServiceImpl.addBooking(1, 1));
//	}
}
