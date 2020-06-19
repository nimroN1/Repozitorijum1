package com.nimro.N1ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.ReservationDTO;
import com.nimro.N1ERP.model.Reservation;
import com.nimro.N1ERP.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public ReservationDTO createReservation(ReservationDTO reservationDTO){
		reservationRepository.save(new Reservation(reservationDTO));
		return reservationDTO;
	}
	
	
	  public List<ReservationDTO> findAllReservations(){
		 List<Reservation> reservations = reservationRepository.findAll();
		 List<ReservationDTO> reservationsDTO = new ArrayList<ReservationDTO>();
		 for(int i = 0; i< reservations.size(); i++) {
			 reservationsDTO.add(new ReservationDTO(reservations.get(i)));
		 }
		 return reservationsDTO;
	  }
	  
	  public ReservationDTO findReservation(Long id) {
		  ReservationDTO retVal = new ReservationDTO(reservationRepository.getOne(id));
		  return retVal;
	  }
	  
	  public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
		  Reservation reservation = reservationRepository.getOne(reservationDTO.getId());
		  reservation.setReservationDate(reservationDTO.getReservationDate());
		  reservationRepository.save(reservation);
		  
		  return reservationDTO;
	  }
	  
	  public void deleteReservation(Long id) {
		  reservationRepository.deleteById(id);
	  }

}
