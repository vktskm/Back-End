package com.epicode.GodfathersPizza.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.classes.FoodItem;
import com.epicode.GodfathersPizza.controller.GestioneMenu;
import com.epicode.GodfathersPizza.serivices.MenuService;

@Component
public class MenuRunner implements CommandLineRunner {
	
	@Autowired MenuService menu;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run... MenuRunner");
		
		// Classe sostituita dal Service MenuService
		// GestioneMenu menu = new GestioneMenu();

		menu.stampaMenu();
		
		menu.createFoodItem();
		
		//menu.findAll();
		
		//FoodItem pizzaMargherita = menu.findById(1);
		//System.out.println(pizzaMargherita);
		
		//pizzaMargherita.setName("Pizza Margherita (tomato, cheese, basilico)");
		
		//menu.updateFoodItem(pizzaMargherita);
		
		//menu.removeFoodItem(pizzaMargherita);

	}

}
