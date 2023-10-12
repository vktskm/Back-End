package com.epicode.teoria;

public class AltraClasseConcreta implements IMessage {

	@Override
	public String getMesage() {
		return "ClasseConcreta message";
	}
	
	public String saluta() {
		return "Ciao ciao";
	}

}
