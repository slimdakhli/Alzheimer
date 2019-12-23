package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	UserRepository userRepository;
	
	public List<User> listAll(){
		return userRepository.findAll();
	}
	
	public void save(User user ) {
		userRepository.saveAndFlush(user);
	}
	public Optional<User> deleteByLogin(String login) {
		return userRepository.deleteByLogin(login);
}
	public Optional<User> getByLogin(String login){
		return userRepository.findByLogin(login);
	}
	
}
