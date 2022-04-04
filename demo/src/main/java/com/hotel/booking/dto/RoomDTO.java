package com.hotel.booking.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.Room;

public class RoomDTO {
	private int totalPersons;

	private int rating;

	private String category;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomId", nullable = true)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billId", nullable = true)

	private Bill bill;

	public int getTotalPersons() {
		return totalPersons;
	}

	public void setTotalPersons(int totalPersons) {
		this.totalPersons = totalPersons;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
