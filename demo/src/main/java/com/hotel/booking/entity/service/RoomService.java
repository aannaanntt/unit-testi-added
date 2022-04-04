package com.hotel.booking.entity.service;

import java.util.List;
import java.util.Optional;

import com.hotel.booking.entity.Room;

import java.util.List;
import java.util.Optional;

import com.hotel.booking.entity.Room;

public interface RoomService {
	Room save(Room room);

	List<Room> findAllRooms();

	Optional<Room> getRoomById(long id);

	String deleteRoomById(long id);

	Room updateRoom(long id, Room room);

}
