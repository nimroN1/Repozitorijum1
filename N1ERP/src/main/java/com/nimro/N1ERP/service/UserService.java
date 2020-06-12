package com.nimro.N1ERP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimro.N1ERP.model.User;
import com.nimro.N1ERP.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User res){
		userRepository.save(res);
	}
	
	
	  public List<User> findAllUsers(){
		 return userRepository.findAll();
	  }
	  
	  public User findUser(long id) {
		  User retVal = userRepository.getOne(id);
		  return retVal;
	  }
	  
	  public void updateUser(User res) {
		  userRepository.save(res);
	  }
	  
	  public void deleteUser(long id) {
		  userRepository.deleteById(id);
	  }


}
