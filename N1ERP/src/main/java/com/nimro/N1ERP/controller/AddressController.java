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

import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.service.AddressService;

@RestController
@RequestMapping(value = "api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<Address>> getAllAddresses() {
		List<Address> retVal = addressService.findAllAddresses();
		return new ResponseEntity<List<Address>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> getOneAddresses(@PathVariable Long id) {
		Address retVal = addressService.findAddress(id);
		return new ResponseEntity<Address>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Address> addAddress(@RequestBody Address address){
		Address retVal = addressService.createAddress(address);
		return new ResponseEntity<Address>(retVal, HttpStatus.OK);
	}
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address){
		Address retVal = addressService.updateAddress(address);
		return new ResponseEntity<Address>(retVal, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long id){
		addressService.deleteAddress(id);
		
		return new ResponseEntity<>("Address deleted successfully", HttpStatus.OK);
	}
	

}
