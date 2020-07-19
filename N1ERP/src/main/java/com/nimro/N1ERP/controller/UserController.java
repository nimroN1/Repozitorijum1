package com.nimro.N1ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimro.N1ERP.dto.LoginDTO;
import com.nimro.N1ERP.dto.UserCredentialsDTO;
import com.nimro.N1ERP.dto.UserDTO;
import com.nimro.N1ERP.security.MyUserDetailsService;
import com.nimro.N1ERP.security.TokenUtils;
import com.nimro.N1ERP.service.UserService;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService myUserDetailsService;
	@Autowired
	TokenUtils tokenUtils;

	@GetMapping(value = "all")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> retVal = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(retVal, HttpStatus.OK);
	}


	@GetMapping(value = "/{id}") 
	public ResponseEntity<UserDTO> getOneUser(@PathVariable Long id) { 
		UserDTO retVal = userService.findUser(id); 
		return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); }

	
	  @PostMapping(consumes = "application/json") 
	  public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
		  UserDTO retVal = userService.createUser(userDTO); 
		  return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	  }
	
		
	  @PutMapping(consumes = "application/json") 
	  public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){ 
		  UserDTO retVal = userService.updateUser(userDTO); 
		  return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	  }
		 
	  
	  @DeleteMapping(value = "/{id}") 
	  @PreAuthorize("ADMIN")
	  public ResponseEntity<?> deleteUser(@PathVariable Long id){ 
		  userService.deleteUser(id);
	  
		  return new ResponseEntity<>("User deleted successfully", HttpStatus.OK); 
	  }
	 
	 @PostMapping(consumes = "application/json", value = "/login")
	  public ResponseEntity<LoginDTO> loginUser(@RequestBody UserCredentialsDTO userCredentialsDTO) {
		 System.out.println("Login user started");
		 
			
			  try { authenticationManager.authenticate(new
			  UsernamePasswordAuthenticationToken( userCredentialsDTO.getUsername(),
			  userCredentialsDTO.getPassword())); }catch(BadCredentialsException e){
			  System.out.println("Bad credentials!!!"); }
			  
			  UserDetails userDetails =
			  myUserDetailsService.loadUserByUsername(userCredentialsDTO.getUsername());
			  
			  String jwt = tokenUtils.generateToken(userDetails);
			 		 
		 UserDTO user = userService.findUserByUsername(userCredentialsDTO.getUsername());
		 
		  return new ResponseEntity<LoginDTO>(
				  new LoginDTO(user.getUsername(), user.getRole().toString(), jwt), HttpStatus.OK);
	  }


}
