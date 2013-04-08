/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad21;


public class Zbiornik {

	static int licznikZbiornikow = 0;
	private int numerZbiornika;
	private double pojemnoscZbiornika;
	private double stanZbiornika;
	
	Zbiornik(double pojemnosc) {
		licznikZbiornikow++;
		numerZbiornika = licznikZbiornikow;
		stanZbiornika = 0;
		pojemnoscZbiornika = pojemnosc;
	}
	
	public String toString() {
		return "Zbiornik " + numerZbiornika + ", pojemność " + pojemnoscZbiornika + ", stan wody " + stanZbiornika;
	}
	
	void dolej(double woda) {
		if (stanZbiornika + woda <= pojemnoscZbiornika) {
			stanZbiornika += woda;
		} else {
			stanZbiornika = pojemnoscZbiornika;
			System.out.println("Za dużo wody. Zbiornik został napełniony a nadwyżka wody ponad jego pojemność wylała się na podłogę.");
		}
	}
	
	void odlej(double woda) {
		if (stanZbiornika - woda >= 0) {
			stanZbiornika -= woda;
		} else {
			stanZbiornika = 0;
			System.out.println("Za mało wody w zbiorniku. Zbiornik został całkowicie opróżniony, ale nie udało się odlać z niego podanej ilości wody.");
		}
	}
	
}