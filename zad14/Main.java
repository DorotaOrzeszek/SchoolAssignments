/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad14;


public class Main {
  public static void main(String ... args) {
	  // ustawiam zmianną pętli (x) na 97, czyli kod litery 'a'
	  int x = 97;
	  // w pętli iterujemy po kodach kolejnych liter wypisując kod x i jego postać znakową za pomocą (cast)
	  while (x <= 122) {
		  System.out.println("Kod znaku " + ((char) x) + " = " + x);
		  x++;
	  }
  }
}