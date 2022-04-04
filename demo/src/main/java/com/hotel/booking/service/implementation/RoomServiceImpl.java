package com.hotel.booking.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.booking.controller.BillController;
import com.hotel.booking.controller.RoomController;
import com.hotel.booking.entity.Room;
import com.hotel.booking.entity.repository.RoomRepository;
import com.hotel.booking.entity.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room save(Room room) {
		RoomController.logger.trace("saving   Rooms");
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findAllRooms() {
		RoomController.logger.trace("getting all  Rooms");
		return roomRepository.findAll();
	}

	@Override
	public Optional<Room> getRoomById(long id) {
		RoomController.logger.trace("getting  Room");
		return roomRepository.findById(id);
	}

	@Override
	public String deleteRoomById(long id) {
		RoomController.logger.trace("deleting  Room");
		roomRepository.deleteById(id);
		return "Room Deleted";
	}

	@Override
	public Room updateRoom(long id, Room room) {
		
		RoomController.logger.trace("Updating  Room");
		Room r = roomRepository.findById(id).get();
	
		r.setCustomer(room.getCustomer());
		r.setTotalPersons(room.getTotalPersons());
		r.setCategory(room.getCategory());
		r.setBill(room.getBill());
		r.setRating(room.getRating());
	

		return roomRepository.save(r);
	}

}
