/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad53;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Main {
	  public static void main(String ... args) {
		  // utworzenie okna programu
		  JFrame frame = new JFrame();
		  JPanel mainPanel = new JPanel();
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(400, 200);
		  frame.setLocationRelativeTo(null);
		  frame.setLayout(new BorderLayout());
		  // utworzenie edytowalnej (po dwukliku) tabeli i wypełnienie jej danymi z pliku myBooks
		  String[] columnNames = {"Autor", "Tytuł", "Cena"};
		  String[][] data = new String[5][3];	// 5 i 3 to w tym wypadku "zahardkodowane" wymiary pliku testowego
		  try {
			  Scanner sc = new Scanner(new FileReader(System.getProperty("user.home") + "/Test/myBooks.txt"));
			  int i = 0;
			  while (sc.hasNextLine()) {
				  int j = 0;
				  String[] line = sc.nextLine().split(" --- ");
				  while (j < line.length) {
					  data[i][j] = line[j];
					  j++;
				  } i++;
			  }
			  JTable table = new JTable(data, columnNames);
			  // umieszczenie tabeli w oknie
			  mainPanel.add(table);
			  frame.add(mainPanel,"Center");
			  frame.setVisible(true);  
		  } catch (Exception e) {
			  System.out.println("Niestety, wystąpił błąd");
			  e.printStackTrace();
		  }
	  }
}
