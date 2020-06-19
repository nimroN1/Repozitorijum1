package com.nimro.N1ERP.dto;

import java.util.ArrayList;
import java.util.List;

import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.model.Hotel;

public class HotelDTO {
	
	private Long id;
	private String name;
	private Address address;
	private List<HotelRoomDTO> hotelRooms = new ArrayList<HotelRoomDTO>();
	
	public HotelDTO() {
		
	}
	
	public HotelDTO(Hotel hotel) {
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.address = hotel.getAddress();
		for(int i = 0; i<hotel.getHotelRooms().size(); i++) {
			HotelRoomDTO reservationDTO = new HotelRoomDTO(hotel.getHotelRooms().get(i));
			hotelRooms.add(reservationDTO);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<HotelRoomDTO> getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(List<HotelRoomDTO> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}
	
	

}
