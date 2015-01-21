/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad11;


public class Main {
  public static void main(String[] args) {
  
    int a =  6,            // liczby biorące udział w sumowaniu 
        b =  9,            // i mnożeniu oznaczam przez: a, b, c  
        c = 18;
    // sumy i iloczyn zapisuję w oddzielnych zmiennych
    int suma = a+b+c;
    int iloczyn = a*b*c;
    double sumapolowek = suma/2.0;
    double sumajednychtrzecich = suma/3.0;
    // wydruk wyników na konsolę
    System.out.println(a + " + " + b + " + " + c + " = " + suma);
    System.out.println(a + " * " + b + " * " + c + " = " + iloczyn);
    System.out.println(a + "/2 + " + b + "/2 + " + c + "/2 = " + sumapolowek);
    System.out.println(a + "/3 + " + b + "/3 + " + c + "/3 = " + sumajednychtrzecich);
  }
}