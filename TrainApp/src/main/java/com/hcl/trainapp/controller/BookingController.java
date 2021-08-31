package com.hcl.trainapp.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainapp.dto.BookingRequestDto;
import com.hcl.trainapp.exception.NotBookedException;
import com.hcl.trainapp.exception.TrainNotFoundException;
import com.hcl.trainapp.exception.UserDefinedException;
import com.hcl.trainapp.model.Booking;
import com.hcl.trainapp.model.Passengers;
import com.hcl.trainapp.model.Train;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.service.BookingService;

@RestController
@Validated
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/tickets")
	public ResponseEntity<String> bookTicket (  @RequestBody BookingRequestDto bookingRequestDto) throws UserDefinedException, TrainNotFoundException
	{
		 String response= bookingService.bookTicket( bookingRequestDto);
		 return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("/users/tickets/")
    public List<Booking> getTicketsbyId(@RequestParam long userId) throws UserDefinedException, NotBookedException
    {
        return bookingService.getTicketsbyId(userId);
    }

}
