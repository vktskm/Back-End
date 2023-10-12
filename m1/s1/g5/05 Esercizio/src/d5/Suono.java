package d5;

public class Suono extends Riproduttore implements Volume {
	private int volume;
	private int tempo;

	public Suono(String titolo, int tempo, int volume) {
		super(titolo);
		this.volume = volume;
		this.tempo = tempo;

	}

	@Override
	public int getVolume() {
		if (this.volume < 0) {
			this.volume = 0;
		}
		return this.volume;
	}

	public int getTempo() {
		if (tempo < 0) {
			System.out.println("Errore: il tempo dev'essere un valore positivo");
		}
		return tempo;
	}

	@Override
	public int aumentaVolume() {
		return ++volume;
	}

	@Override
	public int diminuisciVolume() {
		return --volume;
	}

	@Override
	public void play() {
		if (getTempo() > 0) {
			for (int i = 1; i <= this.getTempo(); i++) {
				System.out.printf("Titolo: " + this.getTitolo() + " Minuto: " + (i));
				System.out.printf(" Volume: ");

				for (int j = 0; j < this.getVolume(); j++) {
					System.out.printf("!");
				}
				System.out.println();
			}
		} else
			System.out.println("Errore: il tempo dev'essere un valore positivo");

	}
}