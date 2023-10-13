package FacadePattern;

public class FuelInjector {
	private String fuelPump = "pompa di benzina";
	
	public void on() {
		System.out.println("FuelInjector On");
	}
	
	public void inject() {
		System.out.println("FuelInjector inject " + fuelPump);
	}
	
	public void off() {
		System.out.println("FuelInjector Off");
	}
}
