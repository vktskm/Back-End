package com.epicode.introSpring.Configuration.config_bean_Component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Classe POJO che non deve implementare o estendee nessuna interfaccia o classe predefinita
@Component("TestComponent")
@Scope("prototype")
public class TestComponent {
	
	private String txt;

	public TestComponent() {
		super();
	}

	public TestComponent(String txt) {
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
