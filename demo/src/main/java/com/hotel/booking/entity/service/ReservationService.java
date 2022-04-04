package com.hotel.booking.entity.service;

import java.util.List;
import java.util.Optional;

import com.hotel.booking.entity.Reservation;

public interface ReservationService {

	Reservation save(Reservation reservation);

	List<Reservation> findAllReservation();

	Optional<Reservation> getReservationById(long id);

	String deleteReservationById(long id);

	Reservation updateReservation(long id, Reservation reservation);
}