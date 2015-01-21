/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Finder {

	String filePath;	// adres pliku testowego na dysku
	
	// konstruktor
	Finder(String path) throws FileNotFoundException {
		filePath = path;
	}
	
	// metoda pomicnicza readTestFile() zwraca zabuforowany plik testowy
	private BufferedReader readTestFile() throws FileNotFoundException {
		FileReader testFile = new FileReader(filePath);		
		return new BufferedReader(testFile);
	}
	
	/* getIfCount() zwraca liczbę występujących w programie instrukcji "if"
	 * UWAGA: metoda 
	 * 	*/ 
	int getIfCount() throws IOException {
		BufferedReader file = readTestFile();
		String line;
		// licznik powtórzeń poszukiwanego wyrażenia
		int ifCounter = 0;
		while ((line = file.readLine()) != null) {
			/* zakładam, że wczytałam plik z "ładnie" zapisanym kodem,
			 * tj. nie ma w tej samej linii więcej niż 1 instrukcji "if",
			 * chyba, że jest to "if" jako zwykłe słowo, np. w komentarzu
			 */
			if (line.matches(".*[}; ]*if *[(].*")) {
				ifCounter++;
			}
		}
		return ifCounter;
	}

	// getStringCount() zwraca liczbę występujących w programie instrukcji "if"
	int getStringCount(String s) throws IOException {
		BufferedReader file = readTestFile();
		String line;
		// licznik powtórzeń poszukiwanego wyrażenia
		int stringCounter = 0;
		while ((line = file.readLine()) != null) {
			// rozbicie wczytanej linii tekstu na słowa
			String[] wordsInLine = line.split("[^0-9a-zA-Z]");
			for (String word : wordsInLine) {
				if (word.equals(s)) {
					stringCounter++;
				}
			}
		}
		return stringCounter;
	}

}