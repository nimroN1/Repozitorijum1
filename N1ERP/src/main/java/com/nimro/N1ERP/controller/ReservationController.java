package com.nimro.N1ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimro.N1ERP.dto.ReservationDTO;
import com.nimro.N1ERP.service.ReservationService;

@RestController
@RequestMapping(value = "api/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<ReservationDTO>> getAllReservations() {
		List<ReservationDTO> retVal = reservationService.findAllReservations();
		return new ResponseEntity<List<ReservationDTO>>(retVal, HttpStatus.OK);
	}


	@GetMapping(value = "/{id}") 
	public ResponseEntity<ReservationDTO> getOneReservation(@PathVariable Long id) { 
		ReservationDTO retVal = reservationService.findReservation(id); 
		return new ResponseEntity<ReservationDTO>(retVal, HttpStatus.OK); }

	
	  @PostMapping(consumes = "application/json") 
	  public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO userDTO){
		  ReservationDTO retVal = reservationService.createReservation(userDTO); 
		  return new ResponseEntity<ReservationDTO>(retVal, HttpStatus.OK); 
	  }
	  
	  
	
		
	  @PutMapping(consumes = "application/json") 
	  public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO userDTO){ 
		  ReservationDTO retVal = reservationService.updateReservation(userDTO); 
		  return new ResponseEntity<ReservationDTO>(retVal, HttpStatus.OK); 
	  }
		 
	  
	  @DeleteMapping(value = "/{id}") 
	  public ResponseEntity<?> deleteReservation(@PathVariable Long id){ 
		  reservationService.deleteReservation(id);
	  
		  return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK); 
	  }

}
