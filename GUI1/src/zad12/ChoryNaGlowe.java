package zad12;

public class ChoryNaGlowe extends Pacjent {

	// konstruktor
	ChoryNaGlowe(String nazwisko) {
		// nazwisko pacjenta określa nadklasa
		super(nazwisko);
		// pozostałe pola wypełniane są danymi specyficznymi dla "chorego na głowę"
		chorobaPacjenta = "głowa";
		leczeniePacjenta = "aspiryna";
	}	
	
}
