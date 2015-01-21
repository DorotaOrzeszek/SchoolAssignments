/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad32;

import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
			
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog("Podaj 3 liczby");
    Scanner scan = new Scanner(input);
    String msg = "";
    try {
    	msg += NumTeller.say(scan.nextInt()) + '\n'; 
    	msg += NumTeller.say(scan.nextInt()) + '\n';
    	msg += NumTeller.say(scan.nextInt()) + '\n';
    	JOptionPane.showMessageDialog(null, msg);
    /* obsługa wyjątku błędnie wprowadzonych danych, np.
     * użytkownik wprowadza tekst zamiast liczb lub za mało liczb
     */
    } catch (NoSuchElementException ex) {
    	JOptionPane.showMessageDialog(null, "Podano niepoprawne dane");
    	ex.printStackTrace();
    }
  }

}