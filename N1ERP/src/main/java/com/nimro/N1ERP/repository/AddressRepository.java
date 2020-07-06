package com.nimro.N1ERP.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nimro.N1ERP.model.Address;
import com.nimro.N1ERP.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Query("select address from Address address "
			+ "group by address.country, address.city")	
	List<Address> getUniqueAddresses();

}
