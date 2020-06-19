package com.nimro.N1ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.ReservationDTO;
import com.nimro.N1ERP.model.HotelRoom;
import com.nimro.N1ERP.model.Reservation;
import com.nimro.N1ERP.model.User;
import com.nimro.N1ERP.repository.HotelRoomRepository;
import com.nimro.N1ERP.repository.ReservationRepository;
import com.nimro.N1ERP.repository.UserRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	HotelRoomRepository hotelRoomRepository;
	
	public ReservationDTO createReservation(ReservationDTO reservationDTO){
		Reservation newReservation = new Reservation(reservationDTO);
		
		User user = userRepository.getOne(reservationDTO.getUserId());
		newReservation.setReservationUser(user);
		
		HotelRoom hotelRoom = hotelRoomRepository.getOne(reservationDTO.getHotelRoomId());
		newReservation.setHotelRoom(hotelRoom);
		
		reservationRepository.save(newReservation);
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
