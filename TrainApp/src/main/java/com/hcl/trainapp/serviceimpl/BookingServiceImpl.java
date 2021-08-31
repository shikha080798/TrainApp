package com.hcl.trainapp.serviceimpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trainapp.dto.BookingRequestDto;
import com.hcl.trainapp.exception.NotBookedException;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Booking;
import com.hcl.trainapp.model.Passengers;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.repository.BookingRepository;
import com.hcl.trainapp.repository.TrainRepository;
import com.hcl.trainapp.repository.UserRepository;
import com.hcl.trainapp.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TrainRepository trainRepository;

	@Override
	public String bookTicket(BookingRequestDto bookingRequestDto)
			throws UserDefinedException, TrainNotFoundException {
		User user = userRepository.findByUserId(bookingRequestDto.getUserId());
		Train train = trainRepository.findByTrainId(bookingRequestDto.getTrainId());
		List<Passengers> passengers = new ArrayList<Passengers>();
		if (user == null) {
			throw new UserDefinedException("User Doesn't Exists....");
		}
		if (train == null) {
			throw new TrainNotFoundException("Train Doesn't Exists....");
		}
//		if(passengers.isEmpty()) {
//			throw new UserNotExistedException("Passenger should be added..for booking");
//		}
		if (user != null && train != null) {
			Booking booking = new Booking();
			booking.setUser(user);
			booking.setTrain(train);
			booking.setDate(LocalDate.now());
			booking.setPassengerList(passengers);
		return " Ticket booked succesfully" ;
		} else {
			return "ticket not booked";
		}

	}

	@Override
	public List<Booking> getTicketsbyId(long userId) throws UserDefinedException, NotBookedException {

		User user = userRepository.findByUserId(userId);
		if (!userRepository.existsById(userId)) {
			throw new UserDefinedException("User doesn't existed");
		}
		List<Booking> booking = bookingRepository.getTicketsbyId(userId);
		if (!booking.isEmpty()) {
			return booking;
		} else {
			throw new NotBookedException("user is registered but not booked any tickets");
		}

	}

}
