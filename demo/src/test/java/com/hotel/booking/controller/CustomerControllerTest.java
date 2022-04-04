package com.hotel.booking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.Reservation;
import com.hotel.booking.entity.service.CustomerService;
import com.hotel.booking.service.implementation.CustomerServiceImpl;

@WebMvcTest(CustomerServiceImpl.class)
public class CustomerControllerTest {

	@MockBean
	private CustomerServiceImpl customerServiceImpl;

	@Test
	public void getAllCustomerTest() throws Exception {
		List<Customer> listCustomers = new ArrayList<>();
		listCustomers.add(new Customer(1, "Amit", "Singh", "988888888"));
		listCustomers.add(new Customer(2, "Ashish", "Arora", "988888858"));
		listCustomers.add(new Customer(3, "Fatima", "Qureshi", "988834888"));
		listCustomers.add(new Customer(4, "Kabir", "Singh", "988888128"));
		Mockito.when(customerServiceImpl.findAllCustomers()).thenReturn(listCustomers);

	}

	@Test
	public void addcustomerTest() throws JsonProcessingException, Exception {

		Customer newCustomer = new Customer();
		List<Bill> billList = new ArrayList<>();
		billList.add(new Bill(12, 34));
		billList.add(new Bill(15, 36));
		billList.add(new Bill(11, 37));

		List<Reservation> reservationList = new ArrayList<>();
		Date startDate = Date.valueOf(LocalDate.now());
		Date endDate = Date.valueOf(LocalDate.now());
		reservationList.add(new Reservation(12, 12, startDate, endDate));

		newCustomer.setCustomerId(1);
		newCustomer.setFirstName("Amit");
		newCustomer.setLastName("Kumar");
		newCustomer.setMobNo("234444444");
		newCustomer.setReservation(reservationList);
		newCustomer.setBill(billList);

		Customer savedCustomer = new Customer();

		List<Bill> billList2 = new ArrayList<>();
		billList2.add(new Bill(12, 34));
		billList2.add(new Bill(15, 36));
		billList2.add(new Bill(11, 37));

		List<Reservation> reservationLists = new ArrayList<>();
		Date startDates = Date.valueOf(LocalDate.now());
		Date endDates = Date.valueOf(LocalDate.now());
		reservationList.add(new Reservation(12, 12, startDates, endDates));

		savedCustomer.setCustomerId(1);
		savedCustomer.setFirstName("Amit");
		savedCustomer.setLastName("Kumar");
		savedCustomer.setMobNo("234444444");
		savedCustomer.setReservation(reservationLists);
		savedCustomer.setBill(billList2);

		Mockito.when(customerServiceImpl.save(newCustomer)).thenReturn(savedCustomer);
	}

	@Test
	public void updatecustomerTest() throws JsonProcessingException, Exception {

		Customer customer = new Customer();
		List<Bill> billList = new ArrayList<>();
		billList.add(new Bill(12, 34));
		billList.add(new Bill(15, 36));
		billList.add(new Bill(11, 37));

		List<Reservation> reservationList = new ArrayList<>();
		Date startDate = Date.valueOf(LocalDate.now());
		Date endDate = Date.valueOf(LocalDate.now());
		reservationList.add(new Reservation(12, 12, startDate, endDate));

		customer.setCustomerId(1);
		customer.setFirstName("Amit");
		customer.setLastName("Kumar");
		customer.setMobNo("234444444");
		customer.setReservation(reservationList);
		customer.setBill(billList);

		Customer updatedCustomer = customer;

		Mockito.when(customerServiceImpl.updateCustomer(1, customer)).thenReturn(updatedCustomer);

	}

	@Test
	public void deleteCustomerTest() throws Exception {
		Mockito.when(customerServiceImpl.deleteCustomerById(1)).thenReturn("Customer Deleted");
	}

}
