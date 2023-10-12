package d5;

public abstract class Riproduttore {
	private String titolo;
	public int xImmagine;

	public Riproduttore(String titolo) {
		this.titolo = titolo;
	}

	public void play() {
	}

	public void show() {
	}

	public String getTitolo() {
		return titolo;
	}

}
