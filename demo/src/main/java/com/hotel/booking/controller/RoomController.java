package com.hotel.booking.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.entity.service.RoomService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.booking.dto.CustomerDTO;
import com.hotel.booking.dto.RoomDTO;
import com.hotel.booking.entity.Room;
import com.hotel.booking.entity.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	public static final Logger logger = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	RoomService roomService;
	@Autowired
	ModelMapper modelmapper;

	@GetMapping("/get")
	public List<RoomDTO> getAllCustomer() {
		return roomService.findAllRooms().stream().map(room -> modelmapper.map(room, RoomDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<RoomDTO> getById(@PathVariable long id) {
		Optional<Room> room = roomService.getRoomById(id);
	
			RoomDTO roomdto = modelmapper.map(room.get(), RoomDTO.class);

			return new ResponseEntity<RoomDTO>(roomdto, HttpStatus.OK);
	

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id") long id) {
		String str = roomService.deleteRoomById(id);

		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<RoomDTO> updateRoom(@PathVariable(name="id") long id, @RequestBody RoomDTO custdto) {
		Room room = modelmapper.map(custdto, Room.class);
		Room updatedRoom = roomService.updateRoom(id, room);

		RoomDTO roomDto = modelmapper.map(updatedRoom, RoomDTO.class);
		return new ResponseEntity<RoomDTO>(roomDto, HttpStatus.OK);
	}

	@PostMapping("/add")
	private ResponseEntity<RoomDTO> add(@Valid @RequestBody RoomDTO roomDto) {
		Room r = modelmapper.map(roomDto, Room.class);

		Room room = roomService.save(r);

		RoomDTO response = modelmapper.map(room, RoomDTO.class);

		return new ResponseEntity<RoomDTO>(response, HttpStatus.CREATED);
	}

}