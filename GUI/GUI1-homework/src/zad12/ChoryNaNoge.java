package zad12;

public class ChoryNaNoge extends Pacjent {
	
	// konstruktor
	ChoryNaNoge(String nazwisko) {
		// nazwisko pacjenta określa nadklasa
		super(nazwisko);
		// pozostałe pola wypełniane są danymi specyficznymi dla "chorego na nogę"
		chorobaPacjenta = "noga";
		leczeniePacjenta = "gips";
	}	
	
}
