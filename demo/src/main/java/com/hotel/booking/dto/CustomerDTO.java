package com.hotel.booking.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Reservation;
import com.hotel.booking.entity.Room;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private long customerId;
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	private String firstName;

	private String lastName;

	private String mobNo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = true)
	private List<Bill> bill;



	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = true)
	private List<Reservation> reservation;

	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}



	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

}
