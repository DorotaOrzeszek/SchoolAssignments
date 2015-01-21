package zad22;

import javax.swing.JOptionPane;

public class End implements Runnable {
	
	public void run() {
		while (true) {
			int choice = JOptionPane.showConfirmDialog(null, "Czy zakończyć pracę?");
			// gdy użytkownik wybierze "Yes", program zakończy działanie
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}	
}
