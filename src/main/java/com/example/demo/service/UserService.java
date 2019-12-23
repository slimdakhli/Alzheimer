package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository ;
	
	
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public void save(User user ) {
		userRepository.save(user);
	}
	
	
	public Optional<User> deleteByLogin(String login) {
		return userRepository.deleteByLogin(login);
}
	public Optional<User> getByLogin(String login){
		return userRepository.findByLogin(login);
	}
	

}
