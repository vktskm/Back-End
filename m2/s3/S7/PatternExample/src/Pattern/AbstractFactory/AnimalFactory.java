package Pattern.AbstractFactory;

public class AnimalFactory implements AbstractFactory<Animal> {

	@Override
	public Animal create(String objType) {
		if(objType.equalsIgnoreCase("Dog")) {
			return new Dog();
		} else if(objType.equalsIgnoreCase("Duck")) {
			return new Duck();
		}
		
		return null;
	}

}
