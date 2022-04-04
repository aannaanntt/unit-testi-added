package com.hotel.booking.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hotel.booking.dto.BillDTO;
import com.hotel.booking.dto.CustomerDTO;
import com.hotel.booking.entity.Bill;

import com.hotel.booking.entity.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private BillService billservice;
	@Autowired
	private ModelMapper modelmapper;

	@PostMapping("/addbill")
	public ResponseEntity<BillDTO> addbill(@Valid @RequestBody BillDTO billdto) {

	

			Bill b = modelmapper.map(billdto, Bill.class);

			Bill bill = billservice.save(b);

			BillDTO response = modelmapper.map(bill, BillDTO.class);
			return new ResponseEntity<BillDTO>(response, HttpStatus.CREATED);

		
	}

	@GetMapping("/getallbills")
	public List<BillDTO> getallbills() {
		return billservice.findAllBill().stream().map(bill -> modelmapper.map(bill, BillDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("getabill/{id}")
	public ResponseEntity<BillDTO> getBillById(@PathVariable long id) {
		Optional<Bill> bill = billservice.getBillById(id);

		
			BillDTO billdto = modelmapper.map(bill.get(), BillDTO.class);

			return new ResponseEntity<BillDTO> (billdto, HttpStatus.OK);
		

	}
	
	@DeleteMapping("/deletebill/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable long id){
		String str=billservice.deleteBillById(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	@PutMapping("/updatebill/{id}")
	public ResponseEntity<BillDTO> updateBillById(@PathVariable (name="id")long id ,@RequestBody BillDTO billdto){
		Bill b = modelmapper.map(billdto,Bill.class);
		
		
		Bill updatedbill=billservice.updateBill(id, b);
		
		BillDTO bdt=modelmapper.map(updatedbill,BillDTO.class);
		return new ResponseEntity<BillDTO>(bdt,HttpStatus.OK);
	}

}
