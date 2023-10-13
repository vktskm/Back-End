package com.epicode.GodfathersPizza.classes;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Menu {
	
	private List<PizzaBase> menuPizza = new ArrayList<PizzaBase>();
	private List<Drink> menuDrink = new ArrayList<Drink>();

}
