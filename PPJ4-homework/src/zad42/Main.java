/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad42;

import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  
  public static void main(String ... args) {  
    String fname = System.getProperty("user.home") + "/Test/tab.txt";
    try {
    	// wczytywanie pliku
    	Scanner s = new Scanner(new File(fname));
    	ArrayList list = new ArrayList();
    	// utworzenie listy liczb z pliku
    	while (s.hasNext()) {
    		list.add(s.nextInt());
    	} 
    	s.close();
    	int maxNumber = (Integer) list.get(0); // wartość maksymalna;
    	ArrayList indexes = new ArrayList(); // indeksy pod którymi występuje wartość maksymalna
    	// przeniesienie liczb z listy do tablicy i odnalezienie wartości maksymalnej
    	int[] numbers = new int[list.size()];
    	for (int i = 0; i < list.size(); i++) {
    		numbers[i] = (Integer) list.get(i);
    		if (numbers[i] >= maxNumber) {
    			maxNumber = numbers[i];
    		} 
    	}
    	// wypisywanie liczb z tablicy i odnalezienie indeksów wartości maksymalnej
    	for (int i=0; i < list.size(); i++) {
    		System.out.print(numbers[i]+" ");
    		if (numbers[i] == maxNumber) {
    			indexes.add(i);
    		}
    	}
    	System.out.println();
    	// wypisanie elementu maksymalnego
    	System.out.println(maxNumber);
    	// wypisywanie pozycji elementów maksymalnych
    	for (int i = 0; i < indexes.size(); i++) {
    		System.out.print(indexes.get(i)+" ");
    	}
    } catch (Exception e) {
    	System.out.println("***");
    }
  }      
}