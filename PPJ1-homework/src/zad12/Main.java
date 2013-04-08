/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad12;


public class Main {
  public static void main(String ... args) {
	// dane
	String[] towary = {"truskawki","gruszki","ziemniaki"};
	double[] ceny = {4.5,2.0,1.0};
	double[] wagi = {1.0,0.5,2.0};
	// obliczenie kosztów zakupów
	double	[] koszty = new double[3];
	double sumakosztow = 0;
	for (int i = 0; i<3; i++) {
		koszty[i] = wagi[i]*ceny[i];
		sumakosztow += koszty[i];
	}
	// wydruk na konsolę
	System.out.println("Kupiono:");
	System.out.println("===========================================================================");
	for (int i = 0; i<3; i++) {
		System.out.println(towary[i] + " - " + wagi[i] + " kg po " + ceny[i] + " zł/kg = " + koszty[i] + " zł (" + koszty[i]/sumakosztow*100 + " % sumy kosztow)");
	}
	System.out.println("===========================================================================");
	System.out.println("Do zapłaty: " + sumakosztow + " zł");
  }
}