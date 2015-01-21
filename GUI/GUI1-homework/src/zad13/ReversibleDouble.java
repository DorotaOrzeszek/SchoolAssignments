package zad13;

public class ReversibleDouble implements Reversible {
	
	// pole number oznacza odwracaną liczbę
	private double number;
	
	// konstruktor
	ReversibleDouble(double x) {
		number = x;
	}

	public Reversible reverse() {
		// odwracanie liczby
		double reversedDouble = 1.0/number;
		// zmiana obiektu na taki z odwróconą liczbą
		number = reversedDouble;
		return this;
	}
	
	// metoda toString() pozwala na wydruk wartości pola przy System.out.print...
	public String toString() {
		return Double.toString(number);
	}
	
}
