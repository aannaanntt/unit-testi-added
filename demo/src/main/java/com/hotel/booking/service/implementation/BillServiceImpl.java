package com.hotel.booking.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.booking.controller.BillController;
import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.repository.BillRepository;
import com.hotel.booking.entity.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billrepository;

	@Override
	public Bill save(Bill bill) {

		BillController.logger.trace("Getting all bills and saving to database");

		return billrepository.save(bill);
	}

	@Override
	public List<Bill> findAllBill() {
		BillController.logger.trace("Getting all bills from database");
		return billrepository.findAll();
	}

	@Override
	public Optional<Bill> getBillById(long id) {
		BillController.logger.trace("Getting  bill by Id");
		return billrepository.findById(id);
	}

	@Override
	public String deleteBillById(long id) {
		BillController.logger.trace("Deleting bill");
		billrepository.deleteById(id);
		return "Bill deleted";
	}

	@Override
	public Bill updateBill(long id, Bill bill) {
		BillController.logger.trace("Updating  bill");
		Bill b = billrepository.findById(id).get();

	
		b.setTotalCost(bill.getTotalCost());
		b.setTotalDays(bill.getTotalDays());

		return billrepository.save(b);
	}

}
