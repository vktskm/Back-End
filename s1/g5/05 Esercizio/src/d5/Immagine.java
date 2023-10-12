package d5;

public class Immagine extends Riproduttore implements Luminosita {
	private int luminosita;

	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	@Override
	public int aumentaLuminosita() {
		return ++luminosita;
	}

	@Override
	public int diminuisciLuminosita() {
		return --luminosita;
	}

	@Override
	public int getLuminosita() {
		return luminosita;
	}

	@Override
	public void show() {
		System.out.printf("Titolo: " + this.getTitolo() + " Luminosita: ");
		for (int i = 1; i <= this.getLuminosita(); i++) {
			System.out.printf("*");
		}
	}
}