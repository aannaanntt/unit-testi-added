package com.hotel.booking.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationId")
	private long reservationId;
	
	@NotNull
	private int numberOfRooms;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date startDate;
	
	@NotNull
	private Date endDate;

	
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(long reservationId, int numberOfRooms, Date startDate, Date endDate) {
		super();
		this.reservationId = reservationId;
		this.numberOfRooms = numberOfRooms;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", numberOfRooms=" + numberOfRooms + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}
