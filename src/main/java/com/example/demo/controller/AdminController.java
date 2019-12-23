package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Activite;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.SalleActivite;
import com.example.demo.entity.User;
import com.example.demo.repository.ActiviteRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.SalleActiviteRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActiviteService;
import com.example.demo.service.AdminService;
import com.example.demo.service.PatientService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.SalleActiviteService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	AdminService adminService;
	@Autowired
	PatientService patientService ;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	ActiviteRepository activiteRepository;
	
	@Autowired
	ActiviteService activiteService ;
	
	@Autowired
	SalleActiviteService salleActiviteService;
	
	@Autowired
	SalleActiviteRepository salleActiviteRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	//********logout ***********
	@GetMapping("/logout")
	public String logOut() {
		return "redirect:/login";
	}
	
	@GetMapping("/listuser")
	public String list_User(Model model){
		List<User> listUser = userService.listAll();
		model.addAttribute("listUser",listUser);
		
		return "admin" ;
	}
	@GetMapping("/goadd")
	public String showUpdateForm(User user) {
		return "add-user";
	}
	
	@PostMapping("/add")
    public String addStudent(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.save(user);
      
        return "redirect:/listuser";
	
}
	
	@GetMapping("/edituser/{login}")
	public String showUpdateForm(@PathVariable("login") String login, Model model) {
	    User user = userService.getByLogin(login)
	      .orElseThrow(()-> new NoSuchElementException("Invalid user Login:" + login));		//orElseThrow(() -> new IllegalArgumentException("Invalid user Login:" + login))

	    model.addAttribute("user", user);
	    return "update-user";
	}
	
	
	@PostMapping("/updateuser/{login}")
	public String updateUser(@PathVariable("login") String login, @Valid User user,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        user.setLogin(login);
	        return "update-user";
	    }

	   // userService.save(user);
	  
	  //  adminService.save(user);
	 
		userRepository.save(user);

	    model.addAttribute("users", userService.listAll());
	    return "redirect:/admin/listuser";
	}
	
	@GetMapping("/deleteuser/{login}")
	public String deleteUser(@PathVariable("login") String login, Model model) {
	    User user = userService.getByLogin(login)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid user Login:" + login));
	//    userService.deleteByLogin(login);
	    userRepository.delete(user);
	   // adminService.deleteByLogin(login);
	    model.addAttribute("users", userService.listAll());
	    return "admin";
	}		
/*		@GetMapping("/rechercheuserbylogin/{login}")
	public String getUserByLogin(@PathVariable("login") String login , Model model) {
		Optional<User> userbylogin = userRepository.findByLogin(login);		//.orElseThrow(()-> new NoSuchElementException("Invalid user Login:" + login))
		
		if ( userbylogin != null) {
			model.addAttribute("userbylogin", userbylogin);
		}
		return "redirect:/admin/listuser";
	}*/
	
	/*@GetMapping("/rechercheuserbylogin")
	public String getUserByLogin(@RequestParam (value = "login", required = false) String login, Model model) {
		
	    model.addAttribute("search", userRepository.findByLogin(login));
	    return "admin";
	}		*/
	//-------------------- gérer patient-----------------------------------
	@GetMapping("/listpatient")
	public String list_Patient(Model model){
		List<Patient> listPatient = patientService.listAll() ;
	
	 model.addAttribute("listPatient",listPatient);
		
		return "list-patient" ;
	}
	
	@GetMapping("/goaddpa")
	public String showUpdateForm(Patient patient) {
		return "add-patient";
	}
	
	@PostMapping("/addpatient")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-patient";
        }
        patientService.save(patient);
      
        return "redirect:/admin/listpatient";
	
}
	@GetMapping("/editpatient/{nom}")
	public String showUpdateForm2(@PathVariable("nom") String nom, Model model) {
	    Patient patient = patientService.getByNom(nom)
	  . orElseThrow(()-> new NoSuchElementException("Invalid Patient:" + nom));		//orElseThrow(() -> new IllegalArgumentException("Invalid user Login:" + login))

	    model.addAttribute("patient", patient);
	    return "update-patient";
	}
	@PostMapping("/updatepatient/{nom}")
	public String updatepatient(@PathVariable("nom") String nom, @Valid Patient patient,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        patient.setNom(nom);
	        return "update-patient";
	    }
	    	
	 
		patientRepository.save(patient);

	    model.addAttribute("patients", patientService.listAll());
	    return "redirect:/admin/listpatient";
	}
	@GetMapping("/deletepatient/{nom}")
	public String deletepatient(@PathVariable("nom") String nom, Model model) {
	    Patient patient = patientService.getByNom(nom)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid Patient:" + nom));
	
	    patientRepository.delete(patient);
	 
	    model.addAttribute("patients", patientService.listAll());
	    return "redirect:/admin/listpatient";
	}		
	
	//--------------------- gerer les activitées ------------------------------------------------
	@GetMapping("/listactivite")
	public String list_Activite(Model model) {
		List<Activite> listActivite= activiteService.listAll();
		model.addAttribute("listActivite", listActivite);
		return "list-activite";
	}
	@GetMapping("/goaddac")
	public String showUpdateForm(Activite activite) {
		return "add-activite";
	}
	@PostMapping("/addactivite")
    public String addActivite(@Valid Activite activite, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-activite";
        }
        activiteService.save(activite);
      
        return "redirect:/admin/listactivite";
	
}
	@GetMapping("/editactivite/{nom}")
	public String showUpdateForm3(@PathVariable("nom") String nom, Model model) {
	    Activite activite = activiteService.getByNom(nom)
	  . orElseThrow(()-> new NoSuchElementException("Invalid activite:" + nom));		//orElseThrow(() -> new IllegalArgumentException("Invalid user Login:" + login))

	    model.addAttribute("activite", activite);
	    return "update-activite";
	}
	
	@PostMapping("/updateactivite/{nom}")
	public String updateactivite(@PathVariable("nom") String nom, @Valid Activite activite,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        activite.setNom(nom);
	        return "update-activite";
	    }
	    	
	 
		activiteRepository.save(activite);

	    model.addAttribute("activites", activiteService.listAll());
	    return "redirect:/admin/listactivite";
	}
	
	@GetMapping("/deleteactivite/{nom}")
	public String deleteactivite(@PathVariable("nom") String nom, Model model) {
	    Activite activite = activiteService.getByNom(nom)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid activité:n" + nom));
	
	    activiteRepository.delete(activite);
	 
	    model.addAttribute("activites", activiteService.listAll());
	    return "redirect:/admin/listactivite";
	}		
	
	//--------------- gerer les salles d'activité -----------------------------------------------------------
	@GetMapping("/listsalleactivite")
	public String list_Salle(Model model) {
		List<SalleActivite> listSalleActivite= salleActiviteService.listAll();
		model.addAttribute("listSalleActivite", listSalleActivite);
		return "list-salleactivite";
	}
	@GetMapping("/goaddsa")
	public String showUpdateForm(SalleActivite salleActivite) {
		return "add-salleactivite";
	}
	@PostMapping("/addsalleactivite")
    public String addSalleActivite(@Valid SalleActivite salleActivite, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-salleactivite";
        }
        salleActiviteService.save(salleActivite);
      
        return "redirect:/admin/listsalleactivite";
	
}	
	@GetMapping("/editsalleactivite/{numSalle}")
	public String showUpdateForm4(@PathVariable("numSalle") String numSalle, Model model) {
	    SalleActivite salleActivite = salleActiviteService.getByNumSalle(numSalle)
	  . orElseThrow(()-> new NoSuchElementException("Invalid numero de la salle :" + numSalle));		//orElseThrow(() -> new IllegalArgumentException("Invalid user Login:" + login))

	    model.addAttribute("salleActivite", salleActivite);
	    return "update-salleactivite";
	}
	
	@PostMapping("/updatesalleactivite/{numSalle}")
	public String updateSalleactivite(@PathVariable("numSalle") String numSalle, @Valid SalleActivite salleActivite,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        salleActivite.setNumSalle(numSalle);
	        return "update-salleactivite";
	    }
	    	
	 
		salleActiviteRepository.save(salleActivite);

	    model.addAttribute("salleActivites", salleActiviteService.listAll());
	    return "redirect:/admin/listsalleactivite";
	}
	@GetMapping("/deletesalleactivite/{numSalle}")
	public String deleteSalleActivite(@PathVariable("numSalle") String numSalle, Model model) {
	    SalleActivite salleActivite = salleActiviteService.getByNumSalle(numSalle)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid numero de la salle " + numSalle));
	
	    salleActiviteRepository.delete(salleActivite);
	 
	    model.addAttribute("salleActivites", salleActiviteService.listAll());
	    return "redirect:/admin/listsalleactivite";
	}
	//------------------------ reservation -------------------------------------
	
	@GetMapping("/listreservation")
	public String list_Reservation(Model model) {
		List<Reservation> listReservation= reservationService.ListAll();
		model.addAttribute("listReservation", listReservation);
		return "list-reservation";
	}
	@GetMapping("/goaddre")
	public String showUpdateForm(Reservation reservation) {
		return "add-reservation";
	}
	@PostMapping("/addreservation")
    public String addReservation(@Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-reservation";
        }
        reservationService.save(reservation);
      
        return "redirect:/admin/listreservation";
	
}	
	@GetMapping("/editreservation/{numRes}")
	public String showUpdateForm5(@PathVariable("numRes") String numRes, Model model) {
	    Reservation reservation = reservationService.getByNumRes(numRes)
	  . orElseThrow(()-> new NoSuchElementException("Invalid numero Reservation :" + numRes));		

	    model.addAttribute("reservation", reservation);
	    return "update-reservation";
	}
	@PostMapping("/updatereservation/{numRes}")
	public String updateReservation(@PathVariable("numRes") String numRes, @Valid Reservation reservation,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        reservation.setNumRes(numRes);
	        return "update-reservation";
	    }
	    	
	 
		reservationRepository.save(reservation);

	    model.addAttribute("reservations", reservationService.ListAll());
	    return "redirect:/admin/listreservation";
	}
	@GetMapping("/deletereservation/{numRes}")
	public String deleteReservation(@PathVariable("numRes") String numRes, Model model) {
	    Reservation reservation = reservationService.getByNumRes(numRes)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid numero de la reservation " + numRes));
	
	    reservationRepository.delete(reservation);
	 
	    model.addAttribute("reservation", reservationService.ListAll());
	    return "redirect:/admin/listreservation";
	}
}
