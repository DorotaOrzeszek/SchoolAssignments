/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad13;


public class ReverseTest {
  public static void main(String[] args) {
    Reversible[] revers = new Reversible[] {
        new ReversibleString("Kot"),
        new ReversibleDouble(2),
        new ReversibleDouble(3),
        new ReversibleString("Pies"),
        new ReversibleString("Ala ma kota i psa"),
        new ReversibleDouble(10),
    };
  
    System.out.println("Normalne:");
    for (Reversible r : revers) {
      System.out.println(r);
    }
  
    for (Reversible r : revers) {
      r.reverse();
    }
  
    System.out.println("Odwrócone:");
    for (Reversible r : revers) {
      System.out.println(r);
    }
  
    System.out.println("Przywrócone i zmienione:");
    for (Reversible r : revers) {
    	// tutaj jest mój kod 
    	// przywrócenie elementów revers do stanu początkowego
    	r.reverse();
    	// zmiana postaci wydruku
    	if (r instanceof ReversibleString) {
    		System.out.println("Tekst " + r);
    	} else {
    	   	System.out.println(Double.parseDouble(r.toString()) + 10);
    	}
    }
  }
}