package Pattern.MainProject;

import FacadePattern.CarEngineFacade;
import Pattern.AbstractFactory.AbstractFactory;
import Pattern.AbstractFactory.Animal;
import Pattern.AbstractFactory.FactoryProvider;
import Pattern.AbstractFactory.Person;
import Pattern.Factory.Forma;
import Pattern.Factory.ShapeFactory;
import Pattern.Prototype.Circle;
import Pattern.Singleton.SingletonObject;
import Pattern.Singleton.Test;

public class MainProject {

	public static void main(String[] args) {

		System.out.println("Design Patterns...");
		
		// Singleton Pattern
		System.out.println("1) Singleton Pattern");
		Test t1 = SingletonObject.getInstance();
		Test t2 = SingletonObject.getInstance();
		Test t3 = SingletonObject.getInstance();
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		// Prototype Pattern
		System.out.println("2) Prototype Pattern");
		Circle c = new Circle();
		c.x = 10;
		c.y = 20;
		c.color = "Red";
		c.radius = 15;
		
		Circle altro_c = (Circle) c.clone();
		altro_c.radius = 17;
		
		System.out.println(altro_c.color);
		
		// Factory Pattern
		System.out.println("3) Factory Pattern");
		Forma f1 = ShapeFactory.createShape("circle");
		Forma f2 = ShapeFactory.createShape("rectangle");
		
		f1.disegnaForma();
		f2.disegnaForma();
		
		// Abstract Factory Pattern
		System.out.println("4) Abstract Factory Pattern");
		
		AbstractFactory<Animal> animalContructor = FactoryProvider.getFactory("Animal");
		Animal dog = animalContructor.create("Dog");
		Animal duck = animalContructor.create("Duck");
		AbstractFactory<Person> personContructor = FactoryProvider.getFactory("Person");
		Person mario = personContructor.create("Uomo");
		Person maria = personContructor.create("Donna");
		
		System.out.println(dog.makeSound());
		System.out.println(duck.makeSound());
		System.out.println(mario.makeSound());
		System.out.println(maria.makeSound());
		
		// Facade Pattern
		System.out.println("5) Facade Pattern");
		CarEngineFacade car = new CarEngineFacade();
		car.startEngine();
		car.stopEngine();
		

	}

}
