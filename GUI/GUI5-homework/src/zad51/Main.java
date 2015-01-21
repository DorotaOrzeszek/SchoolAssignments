/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad51;

import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


class TemperatureListModel extends AbstractListModel {

	@Override
	// zwraca elementy listy dla poszczególnych indeksów i
	public Object getElementAt(int i) {
		int k = i - 70; // stopnie Cejsjusza
		double f = 9.0/5.0 * k + 32; // stopnie Fahrenheita
		return k + " stopni C = " + Math.round(f*100.0)/100.0 + " stopni F";
	}

	@Override
	// zwraca długość listy - w naszym wypadku stałą, obejmującą podany zakres temperatur
	public int getSize() {
		return 70+60+1;
	}	

}

public class Main extends JFrame {
  	
	Main() {	
		// utworzenie okna i umieszczenie w niej listy z suwakami
		JPanel mainPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
	    this.setLayout(new BorderLayout());
		JList list = new JList(new TemperatureListModel());	
		JScrollPane scrollPane = new JScrollPane(list);
		mainPanel.add(scrollPane);
	    this.add(mainPanel,"Center");
	}
	
	public static void main(String ... args) {
		
		JFrame frame = new Main();
		frame.setVisible(true);  
		
  }

}