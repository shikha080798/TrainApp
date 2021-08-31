package com.hcl.trainapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Booking {
//	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@NotNull
	private double price_total;
	private LocalDate date;
	
@Embedded
@ElementCollection
	private List<Passengers> passengerList ;

	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	@OneToOne(targetEntity = Train.class)
	@JoinColumn(name = "trainId", referencedColumnName = "trainId")
	private Train train;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getPrice_total() {
		return price_total;
	}

	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}

	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Passengers> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passengers> passengerList) {
		this.passengerList = passengerList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	
//	@OneToOne(targetEntity = Passengers.class)
//	@JoinColumn(name = "passengerId", referencedColumnName = "passengerId")
//	private Passengers passengers;

	
	

}
