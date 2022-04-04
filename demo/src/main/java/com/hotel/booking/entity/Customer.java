package com.hotel.booking.entity;

import java.util.ArrayList;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private long customerId;

	private String firstName;

	private String lastName;

	@NotNull
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
	private String mobNo;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = true)
	private List<Bill> bill;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private List<Reservation> reservation;

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNo="
				+ mobNo + ", bill=" + bill + ", reservation=" + reservation + "]";
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(List<Reservation> reservation) {
		super();
		this.reservation = reservation;
	}

	public Customer(long customerId,String firstName, String lastName, String mobNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.customerId=customerId;

	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

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

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

}
