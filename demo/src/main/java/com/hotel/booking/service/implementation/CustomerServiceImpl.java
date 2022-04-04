package com.hotel.booking.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.controller.CustomerController;
import com.hotel.booking.customexception.BusinessException;
import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.repository.CustomerRepository;
import com.hotel.booking.entity.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerrepository;

	public Customer save(Customer cust) {

		if (cust.getFirstName().isEmpty() || cust.getFirstName().length() == 0) {
			CustomerController.logger.trace("Error occured while inserting Customer to DB");
			throw new BusinessException("601", "Please send proper name its blank");
		}
		try {
			CustomerController.logger.trace("Inserting customers to DB");
			Customer savedCustomer = customerrepository.save(cust);
			return savedCustomer;
		} catch (IllegalArgumentException e) {

			throw new BusinessException("602", "given Cutomer is null" + e.getMessage());
		} catch (Exception e) {

			throw new BusinessException("603", "Something went wrong in service layer" + e.getMessage());
		}

	}

	public List<Customer> findAllCustomers() {

		List<Customer> lst = customerrepository.findAll();
		try {
			if (lst.isEmpty()) {
				throw new BusinessException("605", "List is completely Empty");

			}
			return lst;
		} catch (Exception e) {
			throw new BusinessException("606", "Something went wrong while fetching all employees" + e.getMessage());
		}
	}

	public Optional<Customer> getCustomerById(long id) {

		try {
			return customerrepository.findById(id);
		} catch (IllegalArgumentException e) {

			throw new BusinessException("607", "given employee id is null please send some id" + e.getMessage());
		} catch (NoSuchElementException e) {

			throw new BusinessException("608", "given employee id dosen't exist in DB" + e.getMessage());
		}

	}

	public String deleteCustomerById(long id) {
		try {
			customerrepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("607", "given employee id is null please send some id" + e.getMessage());
		}
		return "Customer Deleted";

	}

	@Override
	public Customer updateCustomer(long id, Customer cust) {
		Customer c = null;
		try {

			c = customerrepository.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("612", "given employee id is either null or not present " + e.getMessage());
		} catch (NoSuchElementException e) {

			throw new BusinessException("608", "given employee id dosen't exist in DB" + e.getMessage());
		}

		c.setBill(cust.getBill());
		c.setFirstName(cust.getFirstName());
		c.setLastName(cust.getLastName());
		c.setMobNo(cust.getMobNo());
		c.setReservation(cust.getReservation());

		return customerrepository.save(c);
	}

}
