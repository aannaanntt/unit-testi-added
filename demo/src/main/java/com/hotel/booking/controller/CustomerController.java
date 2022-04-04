package com.hotel.booking.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.customexception.BusinessException;
import com.hotel.booking.customexception.ControllerException;
import com.hotel.booking.dto.CustomerDTO;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerService customerService;
	@Autowired
	ModelMapper modelmapper;

	@PostMapping("/addcustomer")
	private ResponseEntity<?> addcustomer(@RequestBody CustomerDTO custDto) {
		try {

			Customer c = modelmapper.map(custDto, Customer.class);

			Customer customer = customerService.save(c);

			CustomerDTO response = modelmapper.map(customer, CustomerDTO.class);
			return new ResponseEntity<CustomerDTO>(response, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getDesc());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			System.out.println(e.getCause());
			ControllerException ce = new ControllerException("611", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getcustomers")
	public List<CustomerDTO> getAllCustomer() {
		return customerService.findAllCustomers().stream().map(customer -> modelmapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/getonecustomer/{id}")
	public ResponseEntity<CustomerDTO> getById(@PathVariable long id) {
		Optional<Customer> cust = customerService.getCustomerById(id);

		CustomerDTO custdto = modelmapper.map(cust.get(), CustomerDTO.class);

		return new ResponseEntity<CustomerDTO>(custdto, HttpStatus.OK);

	}

	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id") long id) {
		String str = customerService.deleteCustomerById(id);

		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable long id, @RequestBody CustomerDTO custdto) {

		try {
			Customer cust = modelmapper.map(custdto, Customer.class);
			Customer updatedCustomer = customerService.updateCustomer(id, cust);

			CustomerDTO customerdto = modelmapper.map(updatedCustomer, CustomerDTO.class);
			return new ResponseEntity<CustomerDTO>(customerdto, HttpStatus.OK);

		} catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getDesc());

			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

			// TODO: handle exception
		} catch (Exception e) {
			ControllerException ce = new ControllerException("611", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

}
