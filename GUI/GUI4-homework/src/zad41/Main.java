/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad41;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

// klasa changeColor służy do zmiany koloru przycisku po kliknięciu
class changeFont implements ActionListener {

	static Color myColors[] = {Color.white, Color.yellow, Color.red, Color.magenta, Color.blue, Color.black}; // lista kolorów tła
	int clicks;		// licznik kliknięć w przycisk

	public changeFont() {
		super();
		clicks = 0;
	}
	
	public void actionPerformed(ActionEvent e) {
		clicks++;
		((JButton) e.getSource() ).setBackground(myColors[clicks % myColors.length]);
	}
	
}

public class Main {
	
	  public static void main(String ... args) {
		  // utworzenie głównego okna
		  JFrame frame = new JFrame("Zmiana koloru");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(1000, 400);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		  frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));
		  // utworzenie przycisku i dodanie go do okna
		  JButton button = new JButton("Zmień kolor przycisku");
		  button.setFont(new Font("sansserif",Font.BOLD,44));
		  button.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		  button.setBackground(Color.white);
		  frame.add(button);
		  // zmiana kolorów przycisku
		  changeFont action = new changeFont();
		  button.addActionListener(action);
	  }
	  
}