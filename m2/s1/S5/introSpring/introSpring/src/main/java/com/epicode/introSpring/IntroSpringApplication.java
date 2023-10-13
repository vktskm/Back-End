package com.epicode.introSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epicode.introSpring.Configuration.config_bean.ConfigurationTest;
import com.epicode.introSpring.Configuration.config_bean.Test;
import com.epicode.introSpring.Configuration.config_bean_Component.TestComponent;
import com.epicode.introSpring.Configuration.config_bean_xml.TestXml;
import com.epicode.introSpring.DipendencyInjection.Person;
import com.epicode.introSpring.DipendencyInjection.PersonConfiguration;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
	
		// metodo 1
		// Configurazione dei beans tramite una classe Configuration
		//configWith_Beans1();
		configWith_BeansDependencyInjection();
		
		// metodo 2
		//configWith_Beans_XML1();
		
		// metodo 3
		//configWith_Beans_Component1();
	}
	
	public static void configWith_Beans1() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
	
		// Recupero un bean Singleton
		Test t1 = (Test) appContext.getBean("test"); // invoco un bean di nome test e mi faccio restituire ogg
		System.out.println(t1);
		System.out.println(t1.info());
		
		// Recupero un bean Singleton
		Test t2 = (Test) appContext.getBean("test"); // invoco un bean di nome test e mi faccio restituire ogg
		System.out.println(t2);
		
		// Recupero un bean Prototype
		Test t3 = (Test) appContext.getBean("testParam", "Test Params Bean"); // invoco un bean di nome testParam e mi faccio restituire ogg
		System.out.println(t3);
		System.out.println(t3.info());
		
		// Recupero un bean Prototype
		Test t4 = (Test) appContext.getBean("testParam", "Test Params Bean"); // invoco un bean di nome testParam e mi faccio restituire ogg
		System.out.println(t4);
		System.out.println(t4.info());
		
		appContext.close();
		
	}
	
	public static void configWith_BeansDependencyInjection() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PersonConfiguration.class);
		
		// Recupero un bean Singleton
		Person p =  (Person) appContext.getBean("person");
		System.out.println(p.toString());
	
		appContext.close();
	}

	public static void configWith_Beans_XML1() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
		// Recupero un bean Singleton
		TestXml t1 = (TestXml) appContext.getBean("TestXML");
		System.out.println(t1.info());
	
		appContext.close();
	}

	public static void configWith_Beans_Component1() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		
		// scannerizzo un package alla ricerca di bean da istanziare tramtie componenti
		appContext.scan("com.epicode.introSpring.Configuration.config_bean_Component");
		appContext.refresh();
		
		// Recupero un bean Prototype
		TestComponent t1 = (TestComponent) appContext.getBean("TestComponent", "Ciao Mondo");
		System.out.println(t1.info());
		
		appContext.close();
	}
}
