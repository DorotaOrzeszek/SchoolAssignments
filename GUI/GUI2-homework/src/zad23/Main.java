/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad23;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Main {
  
	// pole przechowujące wczytywane obiekty-towary
	static List<Towar> t = new ArrayList<Towar>();
	
	public static void main(String ... args) throws FileNotFoundException {
	  // utworzenie wątków - w tym przekazanie wątkowi A wątku B w konstruktorze
	  ActionB B = new ActionB();
	  ActionA A = new ActionA(B);
	  Thread threadA = new Thread(A);
	  Thread threadB = new Thread(B);	  
	  // uruchomienie obu wątków
	  threadA.start();
	  threadB.start();
  }
}