package FacadePattern;

public class AirFlowController {
	private String airFlowMeter = "misuratore di flusso d'aria";
	
	public void takeAir() {
		System.out.println("AirFlowController " + airFlowMeter);
	}
	
	public void off() {
		System.out.println("AirFlowController Off");
	}
}
