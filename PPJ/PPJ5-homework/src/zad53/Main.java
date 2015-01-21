/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad53;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;


public class Main {
  public static void main(String ... args) {
	  
	  Calendar c1 = Calendar.getInstance();
	  Calendar c2 = Calendar.getInstance();
	  c1.setLenient(false);
	  c2.setLenient(false);
	  JOptionPane dialog = new JOptionPane();
	  String input = JOptionPane.showInputDialog(dialog,"Podaj datę OD i datę DO rozdzielone spacjami [RRRR-MM-DD]");
	  try {
		String[] dates = input.split(" +");
		String[] startDate = dates[0].split("-");
		String[] endDate = dates[1].split("-");
		int startY = Integer.parseInt(startDate[0]);
		int startM = Integer.parseInt(startDate[1]);
		int startD = Integer.parseInt(startDate[2]);
		int endY = Integer.parseInt(endDate[0]);
		int endM = Integer.parseInt(endDate[1]);
		int endD = Integer.parseInt(endDate[2]);
		// ustawienie daty początkowej i końcowej oraz sprawdzenie czy są poprawne dzięki isLenient = false
		c1.set(startY, startM - 1, startD);
		c1.getTime();
		c2.set(endY, endM - 1, endD);
		c2.getTime();
		// wypisanie kolejnych dat w pożądanym formacie
		Locale.setDefault(new Locale("pl"));
		if (c1.before(c2)) {
			System.out.printf("%tF %ta \n", c1, c1);
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		else System.out.println("Pierwsza data jest późniejsza od drugiej.");
		while (c1.before(c2)) {
			System.out.printf("%tF %ta \n", c1, c1);
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
	} catch (Exception e) {
		System.out.println("Wprowadzone daty nie są poprawne.\n");
		e.printStackTrace();
	}	
  }
}