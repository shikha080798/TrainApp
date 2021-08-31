package com.hcl.trainapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.hcl.trainapp.model.Passengers;

public class BookingRequestDto {

	@NotNull(message = "user Id should not be null")
	private long userId;
	@NotNull(message = "train Id should not be null")
	private int trainId;
	@NotNull(message = "Passenger Details should not be null")
	private List<Passengers> passengers;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
