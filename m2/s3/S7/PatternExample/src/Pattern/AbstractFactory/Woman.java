package Pattern.AbstractFactory;

public class Woman implements Person {

	@Override
	public String getPerson() {
		return "Woman!!";
	}

	@Override
	public String makeSound() {
		return "Ciao sono una donna...";
	}
	
}
