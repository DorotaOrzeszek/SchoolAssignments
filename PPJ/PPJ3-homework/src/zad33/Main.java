/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad33;


public class Main {
  public static void main(String[] args)  {
    
    String out = "";
    for (Month m : Month.values()) {
      out += m;
    }
    if (!out.equals("styczenlutymarzeckwiecienmajczerwieclipiecsierpienwrzesienpazdzierniklistopadgrudzien")) {
      System.out.println("Wadliwe enum Month");
      System.exit(1);
    } 
  
    MonthInYear m = new MonthInYear(Month.sierpien, 2013);
    System.out.println(m.getDays());
    System.out.println(m.getMonthName());
    System.out.println(m.getMonthNumber());
    System.out.println(m.getMonthSymbol());
    System.out.println(m.getYear());
    System.out.println(m.isLeapYear());
  }
}