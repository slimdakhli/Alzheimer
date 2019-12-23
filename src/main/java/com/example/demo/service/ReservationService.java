package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	public List<Reservation> ListAll(){
		return reservationRepository.findAll();
	}
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	public Optional<Reservation> getByNumRes(String numRes){
		return reservationRepository.findByNumRes(numRes);
	}
	public Optional<Reservation> deleteByNumRes(String numRes){
		return reservationRepository.deleteBynumRes(numRes);
	}
	
}
