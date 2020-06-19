package com.nimro.N1ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.HotelDTO;
import com.nimro.N1ERP.dto.HotelDTO;
import com.nimro.N1ERP.model.Hotel;
import com.nimro.N1ERP.model.Hotel;
import com.nimro.N1ERP.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	public HotelDTO createHotel(HotelDTO hotelDTO){
		hotelRepository.save(new Hotel(hotelDTO));
		return hotelDTO;
	}
	
	  public List<HotelDTO> findAllHotels(){
		 List<Hotel> hotels = hotelRepository.findAll();
		 List<HotelDTO> hotelsDTO = new ArrayList<HotelDTO>();
		 for(int i = 0; i<hotels.size(); i++) {

			 hotelsDTO.add(new HotelDTO(hotels.get(i)));
			 
		 }
		 
		 return hotelsDTO;
	  }
	  
	  public HotelDTO findHotel(Long id) {
		  HotelDTO retVal = new HotelDTO(hotelRepository.getOne(id));
		  return retVal;
	  }
	  
	  public HotelDTO updateHotel(HotelDTO hotelDTO) {
		  Hotel u = hotelRepository.getOne(hotelDTO.getId());
		  u.setAddress(hotelDTO.getAddress());
		  u.setName(hotelDTO.getName());
		  hotelRepository.save(u);
		  return hotelDTO;
	  }
	  
	  public void deleteHotel(Long id) {
		  hotelRepository.deleteById(id);
	  }

}
