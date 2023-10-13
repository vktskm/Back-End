package Pattern.AbstractFactory;

public class FactoryProvider {
	
	public static AbstractFactory getFactory(String s) {
		if(s.equalsIgnoreCase("Animal")) {
			return new AnimalFactory();
		} else if(s.equalsIgnoreCase("Person")) {
			return new PersonFactory();
		}
		
		return null;
	}

}
