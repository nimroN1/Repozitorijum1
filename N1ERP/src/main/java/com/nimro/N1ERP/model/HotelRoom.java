package com.nimro.N1ERP.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.nimro.N1ERP.dto.HotelRoomDTO;

@Entity
public class HotelRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String roomNumber;
	private int numberOfBeds;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private Hotel hotel;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="hotelRoom")
	private List<Reservation> roomReservations = new ArrayList<Reservation>();
	
	public HotelRoom() {
		
	}
	
	public HotelRoom(HotelRoomDTO hotelRoomDTO) {
		this.roomNumber = hotelRoomDTO.getRoomNumber();
		this.numberOfBeds = hotelRoomDTO.getNumberOfBeds();
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reservation> getRoomReservations() {
		return roomReservations;
	}

	public void setRoomReservations(List<Reservation> roomReservations) {
		this.roomReservations = roomReservations;
	}
	
	

}
