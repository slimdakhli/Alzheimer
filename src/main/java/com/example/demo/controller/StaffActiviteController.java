package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Activite;
import com.example.demo.entity.Planning;
import com.example.demo.service.ActiviteService;
import com.example.demo.service.PlanningService;

@Controller
@RequestMapping("/staffactivite")
public class StaffActiviteController {

	@Autowired
	PlanningService planningService;
	
	@Autowired
	ActiviteService activiteService;
	
	@GetMapping("/listplanning")
	public String listPlanning(Model model) {
		List<Planning> listPlanning = planningService.findAll();
		model.addAttribute("listPlanning", listPlanning);
		return "staffactivite";
	}
	@GetMapping("/goproac")
	public String showUpdateForm(Activite activite) {
		return "proposer-activite";
	}
	@PostMapping("/proactivite")
    public String addActivite(@Valid Activite activite, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "proposer-activite";
        }
        activiteService.save(activite);
      
        return "redirect:/staffactivite/listplanning";
	
}
}
