package zad13;

public class ReversibleString implements Reversible {
	
	// pole word oznacza odwracany napis
	private String word;
	
	// konstruktor
	ReversibleString(String s) {
		word = s;
	}

	public Reversible reverse() {
		// odwracanie napisu
		String reversedString = "";
		int max = word.length();
		for (int i = max-1; i >= 0; i--) {
			reversedString += word.charAt(i);
		}
		// zmiana obiektu na taki z odwróconym napisem
		word = reversedString;
		return this;
	}
	
	// metoda toString() pozwala na wydruk wartości pola przy System.out.print...
	public String toString() {
		return word;
	}
	
}
