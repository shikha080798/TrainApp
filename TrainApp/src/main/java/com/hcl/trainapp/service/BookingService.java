package com.hcl.trainapp.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.hcl.trainapp.dto.BookingRequestDto;
import com.hcl.trainapp.exception.NotBookedException;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Booking;
import com.hcl.trainapp.model.Passengers;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.model.User;

public interface BookingService {
	public String bookTicket(BookingRequestDto bookingRequestDto) throws UserDefinedException, TrainNotFoundException ;

	public List<Booking> getTicketsbyId(long userId) throws UserDefinedException, NotBookedException;

}
