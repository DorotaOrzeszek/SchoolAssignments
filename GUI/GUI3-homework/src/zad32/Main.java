/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad32;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class Main {
  public static void main(String ... args) {
	  
	  // utworzenie panelu zawierającego górny rząd przycisków A1-A3 i B1-B3
	  JPanel topPanel = new JPanel();
	  topPanel.setBackground(Color.GRAY);
	  topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
	  // utworzenie pomocniczych paneli: górny prawy i górny lewy
	  JPanel leftTopPanel = new JPanel();
	  JPanel rightTopPanel = new JPanel();
	  leftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	  leftTopPanel.setOpaque(false);
	  rightTopPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	  rightTopPanel.setOpaque(false);
	  // utworzenie przycisków A1-A3 i B1-B3
	  JButton buttons[] = { new JButton("A1"), new JButton("A2"), new JButton("A3"),
			  new JButton("B1"), new JButton("B2"), new JButton("B3") };
	  // umieszczenie przycisków w lewym i prawym górnym panelu
	  for (int i=0; i<6; i++) {
		  buttons[i].setBackground(Color.GRAY);
		  if (i < 3) {
			  leftTopPanel.add(buttons[i]);
		  } else {
			  rightTopPanel.add(buttons[i]);
		  }
	  }
	  // umieszczenie lewego i prawego górnego panelu w górnym panelu
	  topPanel.add(leftTopPanel);
	  topPanel.add(rightTopPanel);

	  // utworzenie panelu zawierającego centralne pole tekstowe
	  JTextArea centralTextArea = new JTextArea("To jest JTextArea                                            ");
	  centralTextArea.setRows(15);
	  centralTextArea.setFont(new Font("sansserif",Font.PLAIN, 20));
	  JScrollPane middlePanel = new JScrollPane(centralTextArea);
	  middlePanel.setBackground(Color.GRAY);
	  middlePanel.setVisible(true);
	  
	  // utworzenie panelu zawierającego dolne przyciski numeryczne i pola tekstowe
	  JPanel bottomPanel = new JPanel();
	  bottomPanel.setBackground(Color.GRAY);
	  bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
	  // utworzenie pomocniczych paneli: dolny prawy i dolny lewy
	  JPanel leftBottomPanel = new JPanel();
	  JPanel rightBottomPanel = new JPanel();
	  leftBottomPanel.setLayout(new BoxLayout(leftBottomPanel, BoxLayout.PAGE_AXIS));
	  leftBottomPanel.setOpaque(false);
	  leftBottomPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,100));
	  rightBottomPanel.setLayout(new BoxLayout(rightBottomPanel, BoxLayout.PAGE_AXIS));
	  rightBottomPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
	  // utworzenie przycisków numerycznych i umieszczenie ich w lewym dolnym panelu
	  JPanel topNumbers = new JPanel();
	  topNumbers.setOpaque(false);
	  JPanel middleNumbers = new JPanel();
	  middleNumbers.setOpaque(false);
	  JPanel bottomNumbers = new JPanel();
	  bottomNumbers.setOpaque(false);
	  String n[] = { "1","2","3","4","5","6","7","8","9" };
	  for (int i=0; i<9; i++) {
		  JButton b = new JButton(n[i]);
		  b.setBackground(Color.GRAY);
		  if (i < 3) {
			  topNumbers.add(b);
		  } else if (i < 6) {
			  middleNumbers.add(b);
		  } else {
			  bottomNumbers.add(b);
		  }
	  }
	  leftBottomPanel.add(topNumbers);
	  leftBottomPanel.add(middleNumbers);
	  leftBottomPanel.add(bottomNumbers);	  
	  // utworzenie pól tekstowych i umieszczenie ich w prawym dolnym panelu
	  for (int i=0; i<3; i++) {
		  JTextField textField = new JTextField("To jest JTextField");
		  textField.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
		  rightBottomPanel.add(textField);
	  }
	  // umieszczenie lewego i prawego górnego panelu w dolnym panelu
	  bottomPanel.add(leftBottomPanel);
	  bottomPanel.add(rightBottomPanel);
	  	  
	  // utworzenie głównego okna
	  JFrame mainFrame = new JFrame();
	  mainFrame.setVisible(true);
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mainFrame.setTitle("Zadanie 3.2");
	  mainFrame.setSize(450,400);
	  mainFrame.setLayout(new BorderLayout());
	  // umieszczenie w głównym oknie 3 paneli pomocniczych
	  mainFrame.add(topPanel,"North");
	  mainFrame.add(middlePanel, "Center");
	  mainFrame.add(bottomPanel, "South");
	  
  }
}