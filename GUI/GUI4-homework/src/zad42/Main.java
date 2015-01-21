/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad42;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

	// klasa changeFont1 służy do zmiany czcionki przycisków po kliknięciu
	class ChangeFont implements ActionListener {

		int clicks;		// licznik kliknięć w przycisk
		int size = 12; // rozmiar czcionki
		JButton b1;
		JButton b2;
		JFrame frame;
		
		public ChangeFont(JButton b1, JButton b2, JFrame frame) {
			super();
			clicks = 0;
			this.b1 = b1;
			this.b2 = b2;
			this.frame = frame;
		}
		
		// metoda zmienia rozmiar czcionki i dostosowuje rozmiar okna
		public void actionPerformed(ActionEvent e) {
			clicks++;
			size = size + clicks;
			((JButton) e.getSource() ).setFont(new Font("sansserif",Font.BOLD,size));
			int minwidth = b1.getSize().width + b2.getSize().width + 500;
			int minheight = Math.max(b1.getSize().height, b2.getSize().height) + 100;
			frame.setSize(minwidth, minheight);		
		}
		
	}

	
public class Main {

  public static void main(String ... args) {
	  
	  // utworzenie głównego okna
	  JFrame frame = new JFrame("Zmiana koloru");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setMinimumSize(new Dimension(840,215));
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  frame.setLayout(new FlowLayout(FlowLayout.CENTER));
	  // utworzenie przycisków i dodanie ich do okna
	  JButton button1 = new JButton("Przycisk 1");
	  button1.setFont(new Font("sansserif",Font.BOLD,12));
	  button1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	  button1.setBackground(Color.blue);
	  JButton button2 = new JButton("Przycisk 2");
	  button2.setFont(new Font("sansserif",Font.BOLD,12));
	  button2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	  button2.setBackground(Color.green);
	  frame.add(button1);
	  frame.add(button2);
	  // zmiana rozmiaru czcionki przycisku
	  ChangeFont action1 = new ChangeFont(button1, button2, frame);
	  button1.addActionListener(action1);
	  ChangeFont action2 = new ChangeFont(button1, button2, frame);
	  button2.addActionListener(action2);
  
  }
}