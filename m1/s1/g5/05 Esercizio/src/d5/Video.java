package d5;

public class Video extends Riproduttore implements Volume, Luminosita {
	private int volume;
	private int tempo;
	private int luminosita;

	public Video(String titolo, int tempo, int volume, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
		this.volume = volume;
		this.tempo = tempo;
	}

	@Override
	public int getVolume() {
		if (volume < 0) {
			this.volume = 0;
		}
		return volume;
	}

	@Override
	public int getLuminosita() {
		if (luminosita < 0) {
			luminosita = 0;
		}
		return luminosita;
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
	public int aumentaLuminosita() {
		return ++luminosita;
	}

	@Override
	public int diminuisciLuminosita() {
		return --luminosita;
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

		System.out.printf("Titolo: " + this.getTitolo() + " Luminosita: ");
		for (int i = 1; i <= this.getLuminosita(); i++) {
			System.out.printf("*");
		}

	}
}