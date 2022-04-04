package com.hotel.booking.entity;

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

import org.hibernate.type.TrueFalseType;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billId;
	
	@Max(value = 10)
	@Min(value=2)
	private int totalDays;

	private int totalCost;

	
	

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int totalDays, int totalCost) {
		super();
		this.totalDays = totalDays;
		this.totalCost = totalCost;

	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}



	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", totalDays=" + totalDays + ", totalCost=" + totalCost + "]";
	}

}
