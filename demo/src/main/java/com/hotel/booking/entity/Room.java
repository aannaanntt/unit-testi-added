package com.hotel.booking.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	
	@Max(value = 4)
	@Min(value = 1)
	private int totalPersons;

	private int rating;

	private String category;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomId", nullable = true)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billId", nullable = true)
	@NotNull
	private Bill bill;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int totalPersons, int rating, String category) {
		super();
		this.totalPersons = totalPersons;
		this.rating = rating;
		this.category = category;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

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

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", totalPersons=" + totalPersons + ", rating=" + rating + ", category="
				+ category + ", customer=" + customer + ", bill=" + bill + "]";
	}

}
