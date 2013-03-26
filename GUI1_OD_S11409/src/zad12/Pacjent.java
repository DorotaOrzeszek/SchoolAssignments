package zad12;

public class Pacjent {
	
	// pola określające podstawowe dane o każdym pacjencie
	public String nazwiskoPacjenta;
	public String chorobaPacjenta;
	public String leczeniePacjenta;
	
	// konstruktor
	Pacjent(String nazwisko) {
		nazwiskoPacjenta = nazwisko;
	}
	
	// metoda nazwisko() zwraca nazwisko pacjenta
	public String nazwisko() {
		return nazwiskoPacjenta;
	}

	// metoda choroba() zwraca chorobę, na którą cierpi pacjent
	public String choroba() {
		return chorobaPacjenta;
	}
	
	// metoda leczenie() zwraca zalecaną metodę leczenia pacjenta
	public String leczenie() {
		return leczeniePacjenta;
	}

}
