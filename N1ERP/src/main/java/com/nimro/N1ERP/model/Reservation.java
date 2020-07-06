package com.nimro.N1ERP.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

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
	private LocalDateTime reservationDateFrom;
	private LocalDateTime reservationDateTo;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private HotelRoom hotelRoom;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private User user;
	 
	
	public Reservation() {
		
	}
	
	public Reservation(ReservationDTO rDTO) {
		this.reservationDateFrom = LocalDateTime.ofInstant(rDTO.getReservationDateFrom().toInstant(), ZoneId.systemDefault());
		this.reservationDateTo = LocalDateTime.ofInstant(rDTO.getReservationDateTo().toInstant(), ZoneId.systemDefault());
	}

	public LocalDateTime getReservationDateFrom() {
		return reservationDateFrom;
	}

	public void setReservationDateFrom(LocalDateTime reservationDate) {
		this.reservationDateFrom = reservationDate;
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
		return reservationDateFrom;
	}

	public void setDate(LocalDateTime date) {
		this.reservationDateFrom = date;
	}

	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom = hotelRoom;
	}

	public LocalDateTime getReservationDateTo() {
		return reservationDateTo;
	}

	public void setReservationDateTo(LocalDateTime reservationDateTo) {
		this.reservationDateTo = reservationDateTo;
	}

}
