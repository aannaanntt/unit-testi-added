package com.hotel.booking.entity.service;

import java.util.List;
import java.util.Optional;

import com.hotel.booking.entity.Bill;


public interface BillService {

	Bill save(Bill bill);

	List<Bill> findAllBill();

	Optional<Bill> getBillById(long id);

	String deleteBillById(long id);

	Bill updateBill(long id, Bill bill);

}
