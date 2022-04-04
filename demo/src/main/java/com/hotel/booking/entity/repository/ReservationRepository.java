package com.hotel.booking.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.hotel.booking.entity.Reservation;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {



}