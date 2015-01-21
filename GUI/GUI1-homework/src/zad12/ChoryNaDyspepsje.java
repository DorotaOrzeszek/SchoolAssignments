package zad12;

public class ChoryNaDyspepsje extends Pacjent {
	
	// konstruktor
	ChoryNaDyspepsje(String nazwisko) {
		// nazwisko pacjenta określa nadklasa
		super(nazwisko);
		// pozostałe pola wypełniane są danymi specyficznymi dla "chorego na dyspepsję"
		chorobaPacjenta = "dyspepsja";
		leczeniePacjenta = "węgiel";
	}	
	
}
