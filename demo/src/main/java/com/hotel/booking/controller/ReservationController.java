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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.dto.ReservationDTO;
import com.hotel.booking.entity.Reservation;
import com.hotel.booking.entity.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	public static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	ReservationService reservationservice;
	@Autowired
	ModelMapper modelmapper;

	@PostMapping("/addreservation")
	private ResponseEntity<ReservationDTO> addreservation( @Valid @RequestBody ReservationDTO reservationDto) {
		
		Reservation res = modelmapper.map(reservationDto, Reservation.class);
		Reservation reservation = reservationservice.save(res);
		ReservationDTO response = modelmapper.map(reservation, ReservationDTO.class);
		return new ResponseEntity<ReservationDTO>(response, HttpStatus.CREATED);
	}

	@GetMapping("/getreservations")
	public List<ReservationDTO> getAllReservation() {
		return reservationservice.findAllReservation().stream()
				.map(reservation -> modelmapper.map(reservation, ReservationDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/getonereservation/{id}")
	public ResponseEntity<ReservationDTO> getById(@PathVariable long id) {
		Optional<Reservation> reservation = reservationservice.getReservationById(id);
	
			ReservationDTO reservationdto = modelmapper.map(reservation.get(), ReservationDTO.class);
			return new ResponseEntity<ReservationDTO>(reservationdto, HttpStatus.OK);
		
	}

	@DeleteMapping("/deletereservation/{id}")
	public ResponseEntity<String> deleteReservationById(@PathVariable(name = "id") long id) {
		String str = reservationservice.deleteReservationById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@PutMapping("/updateresevation/{id}")
	public ResponseEntity<ReservationDTO> updateReservation(@PathVariable(name = "id") long id,
			@RequestBody ReservationDTO resdto) {
		Reservation res = modelmapper.map(resdto, Reservation.class);
		Reservation updatedReservation = reservationservice.updateReservation(id, res);
		ReservationDTO reservdto = modelmapper.map(updatedReservation, ReservationDTO.class);
		return new ResponseEntity<ReservationDTO>(reservdto, HttpStatus.OK);
	}
}
