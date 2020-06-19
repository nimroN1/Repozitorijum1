package com.nimro.N1ERP.dto;

import java.util.ArrayList;
import java.util.List;

import com.nimro.N1ERP.model.HotelRoom;

public class HotelRoomDTO {
	
	private Long id;
	private String roomNumber;
	private int numberOfBeds;
	private Long hotelId;
	private List<ReservationDTO> roomReservations = new ArrayList<ReservationDTO>();
	
	public HotelRoomDTO() {
		
	}
	
	public HotelRoomDTO(HotelRoom hotelRoom) {
		this.id = hotelRoom.getId();
		this.roomNumber = hotelRoom.getRoomNumber();
		this.numberOfBeds = hotelRoom.getNumberOfBeds();
		this.hotelId = hotelRoom.getHotel().getId();
		for(int i = 0; i<hotelRoom.getRoomReservations().size(); i++) {
			ReservationDTO reservationDTO = new ReservationDTO(hotelRoom.getRoomReservations().get(i));
			roomReservations.add(reservationDTO);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public List<ReservationDTO> getRoomReservations() {
		return roomReservations;
	}

	public void setRoomReservations(List<ReservationDTO> roomReservations) {
		this.roomReservations = roomReservations;
	}
	
	

}
