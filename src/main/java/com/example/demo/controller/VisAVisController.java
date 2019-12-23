package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.VisAVis;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/visavis")
public class VisAVisController {
	
	@Autowired
	ReservationService reservationService;
	
	
	
	@Autowired
	ReservationRepository reservationRepository;
	@GetMapping("/listreservationvisavis/{numRes}")
	public String list_Reservation(Model model, @PathVariable("numRes") String numRes) {
		Reservation listReservation= reservationRepository.findByNumRes(numRes)
				. orElseThrow(()-> new NoSuchElementException("Invalid Reservation:" + numRes));	;
		model.addAttribute("listReservation", listReservation);
		return "list-reservation-visavis";
	}

	
	 @GetMapping("/goaddre")
	public String showUpdateForm(Reservation reservation) {
		return "add-reservation-visavis";
	}
	@PostMapping("/addreservationvisavis")
    public String addReservation(@Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-reservation-visavis";
        }
        reservationService.save(reservation);
        String numRes= reservation.getNumRes();
        
        return "redirect:/visavis/listreservationvisavis/"+numRes;
	
}	
	
}
