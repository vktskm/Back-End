package com.epicode.Spring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@GetMapping("/homepage")
	public @ResponseBody String getHomePage() {
		// con @ResponseBody
		// stampo a video come stringa ciò che ritorna il metodo 
		return "<h1>Prima pagina Spring web MVC</h1>";
	}
	
	// Passaggio di paramteri tramite queryString
	@GetMapping("/params")
	public @ResponseBody String getHomePageQueryString(@RequestParam String name ) {
		// leggo i parametri che mi passa il client tramite una queryString
		// ho la possibilità di leggere questi parametri tramite @RequestParam
		// http://localhost:8080/params?name=Mario%20Rossi
		return "Ciao " + name;
	}
	
	// Passaggio di paramteri tramite PathVariable
	@GetMapping("/params/{name}")
	public @ResponseBody String getHomePagePathParam(@PathVariable String name ) {
		// leggo i parametri che mi passa il client tramite url {name}
		// ho la possibilità di leggere questi parametri tramite @PathVariable
		// http://localhost:8080/params/Mario Rossi
		return "Ciao " + name;
	}

	// collegamento di una rotta ad un template html
	@GetMapping("/home")
	public String getHomePageTymeleaf() {
		// senza @ResponseBody 
		// richiamo un template html chiamato pageThymeleaf.html 
		// contenuto nella cartella templates in src/main/resources
		return "pageThymeleaf";
	}
	
	// collegamento di una rotta ad un template html e passaggio di dati
	@GetMapping("/home/param1/{name}/{age}")
	public String getHomePageTymeleafParam1(
									Map<String, String> model, 
									@PathVariable String name, 
									@PathVariable String age) {
		// http://localhost:8080/home/param1/Mario Rossi/45
		// Passaggio di paramentri ad un template HTML
		// Soluzione 1
		// Utilizzando un Map<key,value>
		model.put("fullname", name);
		model.put("myAge", age);
		return "pageThymeleaf";
	}
	
	// collegamento di una rotta ad un template html e passaggio di dati
	@GetMapping("/home/param2/{name}/{age}")
	public String getHomePageTymeleafParam2(
									Model model, 
									@PathVariable String name, 
									@PathVariable String age) {
		// http://localhost:8080/home/param2/Mario Rossi/45
		// Passaggio di paramentri ad un template HTML
		// Soluzione 2
		// Utilizzando un Ogg Model
		model.addAttribute("fullname", name);
		model.addAttribute("myAge", age);
		return "pageThymeleaf";
	}
	
	// collegamento di una rotta ad un template html e passaggio di dati
	@GetMapping("/home/param3/{name}/{age}")
	public String getHomePageTymeleafParam3(
									ModelMap model, 
									@PathVariable String name, 
									@PathVariable String age) {
		// http://localhost:8080/home/param3/Mario Rossi/45
		// Passaggio di paramentri ad un template HTML
		// Soluzione 3
		// Utilizzando un Ogg ModelMap
		model.addAttribute("fullname", name);
		model.addAttribute("myAge", age);
		return "pageThymeleaf";
	}
	
	// collegamento di una rotta ad un template html e passaggio di dati
	@GetMapping("/home/param4/{name}/{age}")
	public ModelAndView getHomePageTymeleafParam4(
									@PathVariable String name, 
									@PathVariable String age) {
		// http://localhost:8080/home/param4/Mario Rossi/45
		// Passaggio di paramentri ad un template HTML
		// Soluzione 4
		// Utilizzando un Ogg ModelAndView che contiene il template html
		// con al suo interno tutti i parametri
		ModelAndView model = new ModelAndView("pageThymeleaf");
		model.addObject("fullname", name);
		model.addObject("myAge", age);
		return model;
	}
	
}
