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

import com.nimro.N1ERP.dto.DateRangeDTO;
import com.nimro.N1ERP.dto.HotelRoomDTO;
import com.nimro.N1ERP.dto.MessageResponseDTO;
import com.nimro.N1ERP.service.HotelRoomService;

@RestController
@RequestMapping(value = "api/hotel-room")
public class HotelRoomController {
	
	@Autowired
	HotelRoomService hotelRoomService;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<HotelRoomDTO>> getAllHotelRooms() {
		List<HotelRoomDTO> retVal = hotelRoomService.findAllHotelRooms();
		return new ResponseEntity<List<HotelRoomDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HotelRoomDTO> getOneHotelRoom(@PathVariable Long id) {
		HotelRoomDTO retVal = hotelRoomService.findHotelRoom(id);
		return new ResponseEntity<HotelRoomDTO>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(value = "/{id}/available")
	public ResponseEntity<List<HotelRoomDTO>> getAvailableHotelRooms(
			@RequestBody DateRangeDTO dateRangeDTO, 
			@PathVariable Long id) {
		List<HotelRoomDTO> retVal = hotelRoomService.findAvailableHotelRooms(dateRangeDTO, id);
		return new ResponseEntity<List<HotelRoomDTO>>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<HotelRoomDTO> addHotelRoom(@RequestBody HotelRoomDTO hotel){
		HotelRoomDTO retVal = hotelRoomService.createHotelRoom(hotel);
		return new ResponseEntity<HotelRoomDTO>(retVal, HttpStatus.OK);
	}
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<HotelRoomDTO> updateHotelRoom(@RequestBody HotelRoomDTO hotel){
		HotelRoomDTO retVal = hotelRoomService.updateHotelRoom(hotel);
		return new ResponseEntity<HotelRoomDTO>(retVal, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MessageResponseDTO> deleteHotelRoom(@PathVariable Long id){
		hotelRoomService.deleteHotelRoom(id);
		
		return new ResponseEntity<MessageResponseDTO>(new MessageResponseDTO("Hotel room deleted successfully"), HttpStatus.OK);
	}
	
}
