package com.epicode.esercizio2;

public class MainProject2 {

	public static void main(String[] args) {

		CartaSIM c1 = new CartaSIM("123456789");
		c1.ricaricaSim(10);
		c1.effettuaChiamata("789123456", 2);
		c1.effettuaChiamata("963258741", 1);
		c1.stampaDatiSIM();

	}

}
