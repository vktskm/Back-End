package FacadePattern;

public class CoolingController {
	private String radiator;
	private String temperatureSensor;
	
	public void setTemperatureUpperLimit() {
		System.out.println("CoolingController setTemperatureUpperLimit");
	}
	
	public void run() {
		System.out.println("CoolingController run");
	}
	
	public void cool() {
		System.out.println("CoolingController cool");
	}
	
	public void stop() {
		System.out.println("CoolingController stop");
	}
}
