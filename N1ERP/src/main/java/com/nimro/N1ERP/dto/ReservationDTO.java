package com.nimro.N1ERP.dto;

import java.time.LocalDateTime;

import com.nimro.N1ERP.model.Reservation;

public class ReservationDTO {
	
	private Long id;
	private LocalDateTime reservationDate;
	private Long userId;
	
	public ReservationDTO() {
		
	}
	
	public ReservationDTO(Reservation r) {
		this.id = r.getId();
		this.reservationDate = r.getReservationDate();
		this.userId = r.getReservationUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}