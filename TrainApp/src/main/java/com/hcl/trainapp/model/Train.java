package com.hcl.trainapp.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int trainId;
	@NotNull
	private String trainName;
	@NotNull
	@Min(2)
	private int trainNumber;
	@NotNull
	@Min(5)
	@NotEmpty(message = "source cannot be empty")
	private String fromsource;
	@NotNull
	@NotEmpty(message = "destination cannot be empty")
	private String todestination;
	@NotNull
	private long seats;
	@NotNull
	private long cost_single_seats;
	@NotNull
	private LocalDate date;
//	@ManyToOne
//	
//	private List<Day> day;	

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getFromsource() {
		return fromsource;
	}

	public void setFromsource(String fromsource) {
		this.fromsource = fromsource;
	}

	public String getTodestination() {
		return todestination;
	}

	public void setTodestination(String todestination) {
		this.todestination = todestination;
	}

	public long getSeats() {
		return seats;
	}

	public void setSeats(long seats) {
		this.seats = seats;
	}

	public long getCost_single_seats() {
		return cost_single_seats;
	}

	public void setCost_single_seats(long cost_single_seats) {
		this.cost_single_seats = cost_single_seats;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", trainNumber=" + trainNumber
				+ ", fromsource=" + fromsource + ", todestination=" + todestination + ", seats=" + seats
				+ ", cost_single_seats=" + cost_single_seats + ", date=" + date + "]";
	}

}
