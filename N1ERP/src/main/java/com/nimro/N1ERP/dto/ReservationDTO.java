package com.nimro.N1ERP.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.nimro.N1ERP.model.Reservation;

public class ReservationDTO {
	
	private Long id;
	private Date reservationDateFrom;
	private Date reservationDateTo;
	private Long userId;
	private Long hotelRoomId;
	
	public ReservationDTO() {
		
	}
	
	public ReservationDTO(Reservation r) {
		this.id = r.getId();
		this.reservationDateFrom = Date.from(r.getReservationDateFrom().atZone(ZoneId.systemDefault()).toInstant());
		this.reservationDateTo = Date.from(r.getReservationDateTo().atZone(ZoneId.systemDefault()).toInstant());
		this.userId = r.getReservationUser().getId();
		this.hotelRoomId = r.getHotelRoom().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReservationDateFrom() {
		return reservationDateFrom;
	}

	public void setReservationDateFrom(Date reservationDate) {
		this.reservationDateFrom = reservationDate;
	}

	public Date getReservationDateTo() {
		return reservationDateTo;
	}

	public void setReservationDateTo(Date reservationDateTo) {
		this.reservationDateTo = reservationDateTo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHotelRoomId() {
		return hotelRoomId;
	}

	public void setHotelRoomId(Long hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}

}
