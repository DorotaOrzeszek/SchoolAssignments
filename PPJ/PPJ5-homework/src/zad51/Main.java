/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad51;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class Main {
  public static void main(String ... args) {
	  
	  // wyświetlenie dialogu wejściowego i pobranie tekstu wpisanego przez użytkownika
	  JOptionPane inputDialog = new JOptionPane();
	  String input = JOptionPane.showInputDialog(inputDialog, "Podaj łańcuch znakowy:");
	  JOptionPane subDialog = new JOptionPane();
	  String sub = JOptionPane.showInputDialog(subDialog, "Podaj poszukiwany podłańczuch:");
	  // 1) podanie na konsoli długości łańcucha
	  int inputLength = input.length();
	  System.out.println("Długość łańcucha: " + inputLength);
	  // 2) wyprowadzenie pierwszego i ostatniego znaku
	  char firstChar = input.charAt(0);
	  char lastChar = input.charAt(inputLength-1);
	  System.out.println("Pierwszy znak łańcucha: " + firstChar);
	  System.out.println("Ostatni znak łańcucha: " + lastChar);
	  // 3) wyprowadzenie podłańcucha od 3 do ostatniego znaku 
	  String substring1 = input.substring(2);
	  System.out.println("Podłańcuch od 3 do ostatniego znaku: " + substring1);
	  // 4) wyprowadzenie podłańcucha od 3 do przedostatniego znaku 
	  String substring2 = input.substring(2,inputLength-1);
	  System.out.println("Podłańcuch od 3 do przedostatniego znaku: " + substring2);
	  // 5) wyprowadzenie informacji o tym ile razy w wejściowym łańcuchu występuje zadany podłańcuch
	  Pattern p = Pattern.compile(sub);
	  Matcher m = p.matcher(input);
	  int c = 0;	// licznik wystąpień
	  while (m.find()) c++;
	  System.out.println("W łańcuchu wejściowym podłańcuch " + sub + " występuje " + c + " razy.");
	  // 6) stworzenie tablicy wszystkich słów łańcucha
	  String[] words = input.split("[ .,;]+");
	  System.out.println("Utworzono tablicę słów łańcucha. Zawiera ona słowa:");
	  for (String w : words) System.out.println(w);
	  // 7) stwierdzenie czy pierwsze i ostatnie słowo łańcucha jest takie samo
	  if (words[0].equals(words[words.length-1])) 
		  System.out.println("Pierwsze i ostatnie słowo są takie same.");
	  else if (words[0].equalsIgnoreCase(words[words.length-1])) 
		  System.out.println("Pierwsze i ostatnie słowo są prawie takie same - różnią się tylko wielkością liter.");
	  else System.out.println("Pierwsze i ostatnie słowo są różne.");
  
  }
}