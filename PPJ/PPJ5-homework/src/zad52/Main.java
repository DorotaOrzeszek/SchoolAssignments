/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad52;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	
	// funkcja leapYear zwraca prawdę, gdy podany rok jest przestępny
	static boolean leapYear(int y) {   
		return ((y%4 == 0 && y%100 != 0) || y%400 == 0);
	}
	
  public static void main(String ... args) {
	  
	  String fname = System.getProperty("user.home") + "/test/daty.txt";
	  
	  // kompilacja wzorca
	  Pattern p = Pattern.compile("(.*\\D+)?" + "\\d{4}-\\d{2}-\\d{2}" + "(\\D+.*)?");
	  Pattern p2 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	  // utworzenie listy do przechowywania wzorów potencjalnych dat i listy wzorów, które nie stanowią poprawnych dat
	  ArrayList<String> potentialDates = new ArrayList<String>(); 
	  ArrayList<String> wrongDates = new ArrayList<String>(); 
	  try {
		  // wczytanie pliku
		  File f = new File(fname);
		  Scanner s = new Scanner(f);
		  // zapisanie w liście potencjalnych dat odpowiednich części pliku
		  while (true) { 
			  if (s.hasNext(p)) {
				  String next = s.next(p);
				  Matcher m = p2.matcher(next);
				  while (m.find()) {
					  potentialDates.add(m.group());
				  }
			  } else if (s.hasNext()) {
				  s.next();
			  } else {
				  break;
			  }
		  }
		  // sprawdzenie poprawności dat i umieszczenie niepoprawnych w liście wrongDates
		  for (String element : potentialDates) {
			  String[] parts = element.split("-");
			  int yyyy = Integer.parseInt(parts[0]);
			  int mm = Integer.parseInt(parts[1]);
			  int dd = Integer.parseInt(parts[2]);
			  if (dd == 0 || mm == 0 || yyyy == 0) {
				  wrongDates.add(element);
			  } else if (mm > 12) {
				  wrongDates.add(element);
			  } else if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
				  if (dd > 31) wrongDates.add(element);
			  } else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
				  if (dd > 30) wrongDates.add(element);
			  } else if (mm == 2) {
				  if (dd > 29) wrongDates.add(element);
				  else if (dd == 29 && !(leapYear(yyyy))) wrongDates.add(element);
			  }
		  }
		  // wypisanie tylko poprawnych dat
		  for (String element : potentialDates) {
			  if (!(wrongDates.contains(element))) System.out.print(element + " ");
		  }
		  s.close();
	  } catch (Exception e) {
		  System.out.println("Niestety, wystąpił błąd programu.");
		  e.printStackTrace();
	  }
  }
}