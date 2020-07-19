package com.nimro.N1ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.dto.UserDTO;
import com.nimro.N1ERP.model.User;
import com.nimro.N1ERP.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserDTO createUser(UserDTO userDTO){
		User user = new User(userDTO);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userRepository.save(user);
		return userDTO;
	}
	
	
	  public List<UserDTO> findAllUsers(){
		 List<User> users = userRepository.findAll();
		 List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		 for(int i = 0; i<users.size(); i++) {

			 usersDTO.add(new UserDTO(users.get(i)));
			 
		 }
		 
		 return usersDTO;
	  }
	  
	  public UserDTO findUser(Long id) {
		  UserDTO retVal = new UserDTO(userRepository.getOne(id));
		  return retVal;
	  }
	  
	  public UserDTO findUserByUsername(String username) {
		  UserDTO retVal = new UserDTO(userRepository.findByUsername(username));
		  return retVal;
	  }
	  
	  public UserDTO updateUser(UserDTO userDTO) {
		  User u = userRepository.findByUsername(userDTO.getUsername());
		  u.setFirstName(userDTO.getFirstName());
		  u.setLastName(userDTO.getLastName());
		  u.setPassword(userDTO.getPassword());
		  u.setAddress(userDTO.getAddress());
		  u.setRole(userDTO.getRole());
		  userRepository.save(u);
		  return userDTO;
	  }
	  
	  public void deleteUser(Long id) {
		  userRepository.deleteById(id);
	  }


}
