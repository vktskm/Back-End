package com.epicode.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.Spring.model.Contact;
import com.epicode.Spring.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired ContactService constactService;
	
//	@GetMapping("/")
//	public @ResponseBody String getHomeTest() {
//		return "Home page test!!!";
//	}
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/rubrica")
	public ModelAndView getRubrica() {
		List<Contact> listaContatti = constactService.getAllContacts();
		//System.out.println(listaContatti.size());
		//listaContatti.forEach(c -> System.out.println(c));
		ModelAndView model = new ModelAndView("rubrica"); // nome della pagina html che voglio richiamare
		model.addObject("lista", listaContatti);
		return model;
	}
	
	@GetMapping("/rubrica/{id}")
	public ModelAndView getRubrica(@PathVariable long id) {
		Contact contact = constactService.getContactsByID(id);
		System.out.println(contact);
		ModelAndView model = new ModelAndView("dettaglio");
		model.addObject("c", contact);
		return model;
	}

}
