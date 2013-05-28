/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad41;

import java.io.File;
import java.util.Scanner;

public class Main {
  
  public static void main(String ... args) {
    String fname = System.getProperty("user.home") + "/Test/iter.txt";
    try {
    	// wczytywanie danych z pliku
    	Scanner s = new Scanner(new File(fname));
    	int start = s.nextInt();
    	int end = s.nextInt();
    	int limit = s.nextInt();
    	int sum = 0;
    	// obliczenie sumy
    	for (int i = start; i <= end; i++) {
    		if (sum < limit) {
    			sum += i;
    		} else {
    			break;
    		}
    	}
    	s.close();
    	// wypisanie sumy
    	System.out.println(sum);
    } catch (Exception e) {
    	System.out.println("***");
    } 
  }
}