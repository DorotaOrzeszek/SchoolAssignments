package zad22;

public class LetterPrinter implements Runnable {

	String letter;	// pole określa literę drukowaną przez wątek
	int pause;	// pole określa czas pomiędzy wydrukiem kolejnych liter
	
	// konstruktor
	LetterPrinter(String character, int seconds) {
		letter = character;
		pause = seconds;
	}
	
	public void run() {
		while (true) {
			try {
				/* Do testowania programu obok liter drukowałam też obiekt date klasy Date, 
				 * żeby sprawdzić, czy litery drukują się co wskazany interwał czasowy:
				 * 
				 * Date date = new Date();
				 * System.out.println(letter + " -> printed " + date);	
				 * 
				 */
				System.out.println(letter);
				Thread.sleep(pause*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}

}
