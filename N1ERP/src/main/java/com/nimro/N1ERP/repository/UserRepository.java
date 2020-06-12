package com.nimro.N1ERP.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nimro.N1ERP.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//ako koristimo notaciju "findBy" + naziv kolone iz baze ne moramo proslijeđivati sql upit
	User findByPassword(String password); 
	
	@Query("select user.username from User user where password = ?1")	
	Page<User> getUserWithMyPass(String password, Pageable p);
	
}
