package com.hotel.booking.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.booking.controller.ReservationController;
import com.hotel.booking.controller.RoomController;
import com.hotel.booking.entity.Reservation;
import com.hotel.booking.entity.repository.ReservationRepository;
import com.hotel.booking.entity.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationrepository;

	@Override
	public Reservation save(Reservation reservation) {
		ReservationController.logger.trace("saving   Reservation");
		return reservationrepository.save(reservation);
	}

	@Override
	public List<Reservation> findAllReservation() {
		ReservationController.logger.trace("finding all   Reservation");
		return reservationrepository.findAll();
	}

	@Override
	public Optional<Reservation> getReservationById(long id) {

		ReservationController.logger.trace("finding a  Reservation");
		return reservationrepository.findById(id);
	}

	@Override
	public String deleteReservationById(long id) {
		ReservationController.logger.trace("deleting   Reservation");
		reservationrepository.deleteById(id);
		return "Reservation Deleted";
	}

	@Override
	public Reservation updateReservation(long id, Reservation reservation) {
		ReservationController.logger.trace("updating   Reservation");
		Reservation res = reservationrepository.findById(id).get();

		res.setNumberOfRooms(reservation.getNumberOfRooms());
		res.setStartDate(reservation.getStartDate());
		res.setEndDate(reservation.getEndDate());
		return reservationrepository.save(res);
	}

}