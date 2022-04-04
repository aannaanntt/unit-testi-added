package com.hotel.booking.entity.service;

import java.util.List;
import java.util.Optional;

import com.hotel.booking.entity.Customer;

public interface CustomerService {
	
	 Customer  save(Customer cust);
	 
	 List<Customer> findAllCustomers();
	 
	 Optional<Customer> getCustomerById(long id);
	 
	 String deleteCustomerById(long id);
	 
	 Customer updateCustomer(long id,Customer cust);
}
