package com.nimro.N1ERP.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.nimro.N1ERP.dto.HotelDTO;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="hotel")
	private List<HotelRoom> hotelRooms = new ArrayList<HotelRoom>();
	
	public Hotel() {
		
	}
	
	public Hotel(HotelDTO hotelDTO) {
		this.name = hotelDTO.getName();
		this.address = hotelDTO.getAddress();
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

	public List<HotelRoom> getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(List<HotelRoom> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}
	
	

}
