package main.esercizio2;

public class Calls {

	long callerNumber;
	double duration;
	long receiverNumber;
	
	public Calls(long receiverNumber, long callerNumber, double duration) {
		this.callerNumber = callerNumber;
		this.receiverNumber = receiverNumber;
		this.duration = duration;
	}
	
	public String toString() {
		return  "Chiamante " + this.callerNumber + " durata " + this.duration + " Ricevente " + this.receiverNumber ;
		
	}
}
