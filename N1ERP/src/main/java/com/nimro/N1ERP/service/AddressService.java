package com.nimro.N1ERP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public void createAddress(){
		Address adr = new Address();
		adr.setCountry("Srbija");
		adr.setCity("Beograd");
		adr.setStreet("Kneza Lazara");
		adr.setNumber(8);
		
		addressRepository.save(adr);
	}
	
	
	  public List<Address> findAllAddresses(){
		 return addressRepository.findAll();
	  }
	  
	  public Address findAddress(long id) {
		  Address retVal = addressRepository.getOne(id);
		  return retVal;
	  }
	  
	  public void updateAddress(Address address) {
		  addressRepository.save(address);
	  }
	  
	  public void deleteAddress(long id) {
		  addressRepository.deleteById(id);
	  }
	 

}
