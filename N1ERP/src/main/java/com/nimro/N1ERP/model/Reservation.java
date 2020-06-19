package com.nimro.N1ERP.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.nimro.N1ERP.dto.ReservationDTO;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime reservationDate;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private HotelRoom hotelRoom;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private User user;
	 
	
	public Reservation() {
		
	}
	
	public Reservation(ReservationDTO rDTO) {
		this.reservationDate = rDTO.getReservationDate();
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	
	
	
	  public User getReservationUser() { return user; }
	  
	  public void setReservationUser(User reservationUser) { this.user =
	  reservationUser; }
	 
	 
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return reservationDate;
	}

	public void setDate(LocalDateTime date) {
		this.reservationDate = date;
	}

	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

}
