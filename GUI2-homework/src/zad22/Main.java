/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad22;


public class Main {
  
	public static void main(String ... args) {
		
	  // definicja "zadań", które staną się oddzielnymi wątkami
	  LetterPrinter A = new LetterPrinter("A", 3);
	  LetterPrinter B = new LetterPrinter("B", 4);
	  LetterPrinter C = new LetterPrinter("C", 5);
	  // dialog pozwalający na przerwanie działania programu
	  End end = new End();
	  // umieszczenie każdego "zadania" w oddzielnym wątku
	  Thread thread1 = new Thread(A);
	  Thread thread2 = new Thread(B);
	  Thread thread3 = new Thread(C);
	  Thread thread4 = new Thread(end);
	  // uruchomienie wszystkich wątków
	  thread1.start();
	  thread2.start();
	  thread3.start();
	  thread4.start();
	}
}