package com.nimro.N1ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimro.N1ERP.model.HotelRoom;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

}
