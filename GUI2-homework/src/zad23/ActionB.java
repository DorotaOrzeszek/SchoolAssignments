package zad23;

public class ActionB implements Runnable {

	// metoda weighLastProduct() zwraca wagę ostatniego niezważonego towaru na liście t
	double weighLastProduct() {
		synchronized (this){
			double productWeight = Main.t.get(0).weight;
			Main.t.remove(0);
			return productWeight;
		}
	}
	
	public void run() {
		// dodawanie wag kolejnych towarów
		double weightSum = 0;
		while (true) {
			try {
				synchronized (this) {
					wait();
				}
				weightSum += weighLastProduct();
				// wypisywanie na ekran informacji o liczbie zsumowanych wag towarów
				if (Towar.counter % 100 == 0) {
					System.out.println("podliczono wagę " + Towar.counter + " towarów");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} if (Main.t.size() == 0) {
				break;
			}
		}
		// wypisanie na ekran informacji o łącznej wadze wszystkich towarów
		System.out.println("sumaryczna waga wszystkich towarów: " + weightSum);
	}

	
}
