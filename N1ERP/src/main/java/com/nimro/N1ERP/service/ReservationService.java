package com.nimro.N1ERP.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.model.Reservation;
import com.nimro.N1ERP.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public void createReservation(Reservation res){
		reservationRepository.save(res);
	}
	
	
	  public List<Reservation> findAllReservations(){
		 return reservationRepository.findAll();
	  }
	  
	  public Reservation findReservation(long id) {
		  Reservation retVal = reservationRepository.getOne(id);
		  return retVal;
	  }
	  
	  public void updateReservation(Reservation res) {
		  reservationRepository.save(res);
	  }
	  
	  public void deleteReservation(long id) {
		  reservationRepository.deleteById(id);
	  }

}
