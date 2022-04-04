package com.hotel.booking.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.booking.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
