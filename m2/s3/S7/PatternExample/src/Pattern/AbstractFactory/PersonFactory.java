package Pattern.AbstractFactory;

public class PersonFactory implements AbstractFactory<Person> {

	@Override
	public Person create(String objType) {
		if(objType.equalsIgnoreCase("Uomo")) {
			return new Man();
		} else if(objType.equalsIgnoreCase("Donna")) {
			return new Woman();
		}
		
		return null;
	}

}
