package zad23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActionA implements Runnable {

	ActionB notifiableThread;
	
	// konstruktor
	ActionA(ActionB newActionB) {
		notifiableThread = newActionB;
	}
	
	// metoda addCurrentProduct() tworzy i dodaje do listy obiektów nowowczytany towar
	void addCurrentProduct(String s, double d) {
		synchronized (notifiableThread) {
			Main.t.add(new Towar(s,d));
			notifiableThread.notify();
		}
	}
	
	public void run() {
		// wczytywanie pliku z danymi
		String usrHome = System.getProperty("user.home");
		FileReader myfile;
		try {
			myfile = new FileReader(usrHome + "/Testy/Towary.txt");
			BufferedReader file = new BufferedReader(myfile);
			String line;
			while ((line = file.readLine()) != null) {
				String[] productData = line.split(" ");
				addCurrentProduct(productData[0], Double.parseDouble(productData[1]));
				// wypisywanie na ekran informacji o liczbie utworzonych obiektów
				if (Towar.counter % 200 == 0) {
					System.out.println("utworzono " + Towar.counter + " obiektów");
				}
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
