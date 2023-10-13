package com.epicode.introSpring.Configuration.config_bean;

// Classe POJO che non deve implementare o estendee nessuna interfaccia o classe predefinita
public class Test {
	
	private String txt;

	public Test() {
		super();
	}

	public Test(String txt) {
		this.txt = txt;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public String info() {
		return "INFO: " + txt;
	}
	

}
