package com.epicode.GodfathersPizza.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.controller.GestioneMenu;

@Component
public class MenuRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");
		
		GestioneMenu menu = new GestioneMenu();
		menu.stampaMenu();
		
	}

}
