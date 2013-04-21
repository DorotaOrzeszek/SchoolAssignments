/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad31;


public class Appender {

	String src;
	
	// konstruktor 1
	Appender() {
		src = "";
	}
	
	// konstruktor 2
	Appender(String s) {
		try {
			if (s.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				src = s;
			} 
		} catch (RuntimeException ex) {
			System.out.println("Błąd: niepoprawny typ argumentu! Stworzono obiekt z napisem pustym.");
			src = "";
		}
	}
	
	// metoda append dopisuje do src napis app n razy
	Appender append(String app, int n) {
		try {
			if (app.equals(null)) {
				throw new IllegalArgumentException();
			} else if (n < 0) {
				throw new IllegalArgumentException();
			} else {
				while (n > 0) {
					src += app;
					n--;
				}
			}
		} catch (RuntimeException ex) {
			System.out.println("Błąd: niepoprawny typ argumentu! Nie dopisano nic do obiektu.");
		} return this;
	}
	
	// formatowanie wydruku na ekran
	public String toString() {
		return src;
	}
}