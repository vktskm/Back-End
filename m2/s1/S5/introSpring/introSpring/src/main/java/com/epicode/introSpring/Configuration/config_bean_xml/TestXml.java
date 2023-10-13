package com.epicode.introSpring.Configuration.config_bean_xml;

// Classe POJO che non deve implementare o estendee nessuna interfaccia o classe predefinita
public class TestXml {
	
	private String txt;

	public TestXml() {
		super();
	}

	public TestXml(String txt) {
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
