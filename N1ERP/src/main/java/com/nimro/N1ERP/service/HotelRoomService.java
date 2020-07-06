package com.nimro.N1ERP.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.DateRangeDTO;
import com.nimro.N1ERP.dto.HotelRoomDTO;
import com.nimro.N1ERP.model.Hotel;
import com.nimro.N1ERP.model.HotelRoom;
import com.nimro.N1ERP.model.Reservation;
import com.nimro.N1ERP.repository.HotelRepository;
import com.nimro.N1ERP.repository.HotelRoomRepository;

@Service
public class HotelRoomService {
	
	@Autowired
	HotelRoomRepository hotelRoomRepository;
	@Autowired
	HotelRepository hotelRepository;
	
	public HotelRoomDTO createHotelRoom(HotelRoomDTO hotelRoomDTO){
		HotelRoom newHotelRoom = new HotelRoom(hotelRoomDTO);
		
		Hotel hotel = hotelRepository.getOne(hotelRoomDTO.getHotelId());
		newHotelRoom.setHotel(hotel);
		
		hotelRoomRepository.save(newHotelRoom);
		return hotelRoomDTO;
	}
	
	  public List<HotelRoomDTO> findAllHotelRooms(){
		 List<HotelRoom> hotelRooms = hotelRoomRepository.findAll();
		 List<HotelRoomDTO> hotelRoomsDTO = new ArrayList<HotelRoomDTO>();
		 for(int i = 0; i<hotelRooms.size(); i++) {

			 hotelRoomsDTO.add(new HotelRoomDTO(hotelRooms.get(i)));
			 
		 }
		 
		 return hotelRoomsDTO;
	  }
	  
	  public List<HotelRoomDTO> findAvailableHotelRooms(DateRangeDTO dateRangeDTO, Long id){
		  Hotel hotel = hotelRepository.getOne(id);
		  List<HotelRoom> hotelRooms = hotel.getHotelRooms();
		  List<HotelRoomDTO> availableRooms = new ArrayList<HotelRoomDTO>(); 
		  for(int i=0; i< hotelRooms.size(); i++) {
			  HotelRoom room = hotelRooms.get(i);
			  List<Reservation> reservations = room.getRoomReservations();
			  boolean includeRoom = true;
			  for(int j=0; j<reservations.size(); j++) {
				  Reservation reservation = reservations.get(j);
				  if(
						  !((
						  dateRangeDTO.getDateFrom().before(Date.from(reservation.getReservationDateFrom().atZone(ZoneId.systemDefault()).toInstant())) 
						  && dateRangeDTO.getDateTo().before(Date.from(reservation.getReservationDateFrom().atZone(ZoneId.systemDefault()).toInstant()))
						  )
						  
						  || 
						  
						  (
								  dateRangeDTO.getDateFrom().after(Date.from(reservation.getReservationDateTo().atZone(ZoneId.systemDefault()).toInstant())) 
								  && dateRangeDTO.getDateTo().after(Date.from(reservation.getReservationDateTo().atZone(ZoneId.systemDefault()).toInstant()))
						  )
						  )
						  
						  ) {
					  
					  includeRoom = false;
				  }
			  }
			  
			  if(includeRoom)
				  availableRooms.add(new HotelRoomDTO(room));
		  }
		 return availableRooms;
		  
	  }
	  
	  public HotelRoomDTO findHotelRoom(Long id) {
		  HotelRoomDTO retVal = new HotelRoomDTO(hotelRoomRepository.getOne(id));
		  return retVal;
	  }
	  
	  public HotelRoomDTO updateHotelRoom(HotelRoomDTO hotelRoomDTO) {
		  HotelRoom u = hotelRoomRepository.getOne(hotelRoomDTO.getId());
		  u.setNumberOfBeds(hotelRoomDTO.getNumberOfBeds());
		  u.setRoomNumber(hotelRoomDTO.getRoomNumber());
		  hotelRoomRepository.save(u);
		  return hotelRoomDTO;
	  }
	  
	  public void deleteHotelRoom(Long id) {
		  hotelRoomRepository.deleteById(id);
	  }

}
