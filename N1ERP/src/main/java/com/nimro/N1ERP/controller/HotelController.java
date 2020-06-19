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

import com.nimro.N1ERP.dto.HotelDTO;
import com.nimro.N1ERP.service.HotelService;

@RestController
@RequestMapping(value = "api/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<HotelDTO>> getAllHotels() {
		List<HotelDTO> retVal = hotelService.findAllHotels();
		return new ResponseEntity<List<HotelDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HotelDTO> getOneHotel(@PathVariable Long id) {
		HotelDTO retVal = hotelService.findHotel(id);
		return new ResponseEntity<HotelDTO>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<HotelDTO> addHotel(@RequestBody HotelDTO hotel){
		HotelDTO retVal = hotelService.createHotel(hotel);
		return new ResponseEntity<HotelDTO>(retVal, HttpStatus.OK);
	}
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotel){
		HotelDTO retVal = hotelService.updateHotel(hotel);
		return new ResponseEntity<HotelDTO>(retVal, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteHotel(@PathVariable Long id){
		hotelService.deleteHotel(id);
		
		return new ResponseEntity<>("HotelDTO deleted successfully", HttpStatus.OK);
	}

}
