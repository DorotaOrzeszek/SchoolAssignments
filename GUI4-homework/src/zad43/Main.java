/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad43;

import javax.swing.*;


public class Main {
	
  public static void main(String ... args) {
	  
	  SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new TestMenu();
	      }
	    });
  
  }

	
}