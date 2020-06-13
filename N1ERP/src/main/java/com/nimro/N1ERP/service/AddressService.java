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
	
	public Address createAddress(Address address){
		Address adr = new Address();
		adr.setCountry(address.getCountry());
		adr.setCity(address.getCity());
		adr.setStreet(address.getStreet());
		adr.setNumber(address.getNumber());
		
		return addressRepository.save(adr);
	}
	
	
	  public List<Address> findAllAddresses(){
		 return addressRepository.findAll();
	  }
	  
	  public Address findAddress(long id) {
		  Address retVal = addressRepository.getOne(id);
		  return retVal;
	  }
	  
	  public Address updateAddress(Address address) {
		  return addressRepository.save(address);
	  }
	  
	  public void deleteAddress(long id) {
		  addressRepository.deleteById(id);
	  }
	 

}
