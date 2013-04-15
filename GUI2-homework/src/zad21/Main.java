/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad21;


public class Main {
  
  public static void main(String ... args) throws Exception  {
    String usrHome = System.getProperty("user.home");
    Finder finder = new Finder(usrHome + "/Testy/Test.java");
    int nif = finder.getIfCount();
    int nwar = finder.getStringCount("wariant");
    System.out.println("Liczba instrukcji if: " + nif);
    System.out.println("Liczba napisow wariant: " + nwar);
  }
}