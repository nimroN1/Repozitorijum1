package com.nimro.N1ERP.dto;

import java.util.ArrayList;
import java.util.List;

import com.nimro.N1ERP.enums.Role;
import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.model.Reservation;
import com.nimro.N1ERP.model.User;

public class UserDTO {
	

	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;
	private Address address;
	private List<ReservationDTO> reservations = new ArrayList<ReservationDTO>();
	
	public UserDTO() {
		
	}
	
	public UserDTO(User u) {
		
		 this.setAddress(u.getAddress());
		 this.setFirstName(u.getFirstName());
		 this.setLastName(u.getLastName());
		 this.setPassword(u.getPassword());
		 this.setRole(u.getRole());
		 this.setUsername(u.getUsername());
		 
		 
		 List<Reservation> userReservations = u.getReservations();
		 List<ReservationDTO> userReservationsDTO = new ArrayList<ReservationDTO>();
		 
		 for(int j = 0; j<userReservations.size(); j++) {
			 ReservationDTO aUserReservationDTO = new ReservationDTO();
			 aUserReservationDTO.setId(userReservations.get(j).getId());
			 aUserReservationDTO.setReservationDate(userReservations.get(j).getReservationDate());
			 aUserReservationDTO.setUserId(u.getId());
			 
			 userReservationsDTO.add(aUserReservationDTO);
		 }
		 
		 this.setReservations(userReservationsDTO);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ReservationDTO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}

}
