package com.nimro.N1ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.HotelRoomDTO;
import com.nimro.N1ERP.model.Hotel;
import com.nimro.N1ERP.model.HotelRoom;
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
