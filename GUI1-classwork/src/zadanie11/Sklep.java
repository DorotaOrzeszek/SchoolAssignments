package zadanie11;

public class Sklep {

	private static double CenaHurtowa = 0;
	private static double CenaDetaliczna = 0;
	private static int licznikSklepow = 0;
	private int nrSklepu;
	private int jablkaNaStanie;
	private double wydatki = 0;
	private double dochody = 0;
		
	// konstruktor
	Sklep() {
		licznikSklepow ++;
		jablkaNaStanie = 0;
		nrSklepu = licznikSklepow;
	}
	
	// zmiana formatu drukowania na ekran
	public String toString() {
		return "Sklep nr " + nrSklepu + " aktualny stan jablek " + jablkaNaStanie + " kg";
	}
	
	// ustalenie ceny hurtowej
	static void setCenaHurtowa(double cenaHurtowa) {
		CenaHurtowa = cenaHurtowa;
	}

	// ustalenie ceny detalicznej
	static void setCenaDetaliczna(double cenaDetaliczna) {
		CenaDetaliczna = cenaDetaliczna;
	}

	// zakup jablek do sklepu
	void kupno(int ilosc) {
		jablkaNaStanie += ilosc;
		wydatki += ilosc * CenaHurtowa;
	}

	// sprzedaz jablek ze sklepu
	void sprzedaz(int ilosc) {
		jablkaNaStanie -= ilosc;
		dochody += ilosc * CenaDetaliczna;
	}
	
	// getWydatki() zwraca sumaryczne wydatki sklepu
	double getWydatki() {
		return wydatki;
	}
	
	// getDochody() zwraca sumaryczne dochody sklepu
	double getDochody() {
		return dochody;
	}
	
}
