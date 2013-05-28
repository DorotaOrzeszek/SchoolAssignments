/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad43;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
  
  public static void main(String ... args) {  
    String fname = System.getProperty("user.home") + "/Test/pakiety.txt";
    
    try {
    	// wczytywanie pliku
    	Scanner s = new Scanner(new File(fname));
    	long startSize = s.nextInt();	// rozmiar pierwszego pakietu
    	long maxDiscSpace = s.nextInt() * 1048576; // dostępna przestrzeń dyskowa w BAJTACH
    	long packageSizeSum = 0;	// suma rozmiarów odebranych pakietów
    	long packageNumber = 1;		// numer porządkowy pakietu
    	long packageSize = 0;		// rozmiar bieżącego pakietu
    	ArrayList list = new ArrayList(); // lista przechowująca wyniki
    	// sumowanie rozmiarów pakietów według podanego w zadaniu schematu
    	while (true) {
    		if (packageNumber == 1) {
    			packageSize = startSize;
    			packageSizeSum += packageSize;    			
    		} else if (packageNumber < 6) {
    			packageSize *= 2;
    			packageSizeSum += packageSize;
    		} else {
    			packageSize *= 3;
    			packageSizeSum += packageSize;
    		}
    		if (packageSizeSum > maxDiscSpace) {
    			break;
    		} else {
    			list.add(packageSize);
    		}
    		packageNumber++;
    	}
    	// wypisywanie wyników
    	System.out.println(list.size());
    	for (int i = 0; i < list.size(); i++ ) {
    		System.out.println((i+1)+" "+list.get(i));
    	}
    	System.out.println(packageSizeSum-packageSize);    	
    } catch (Exception e) {
    	System.out.println("***");
    }
    
  }      
}