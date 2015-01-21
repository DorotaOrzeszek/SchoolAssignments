/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad31;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
  public static void main(String ... args) {
  
	// argumenty dla rozkladu BorderLayout
    String myArguments[] = { "North", "West", "Center", "East", "South"};
    // teksty etykiet
    String myTexts[] = { "Oto pierwsza etykieta!", "Etykieta II", "...i trzecia...", "Nr 4", "A tutaj koniec" };
    // kolory tła
    Color myColors[] = { new Color(191, 25, 55), new Color(255, 255, 200),
        new Color(255, 255, 255), new Color(0, 255, 140), new Color(161, 224, 224) };
    // czcionki
    Font myFonts[] = { new Font("sansserif",Font.BOLD, 30), new Font("serif",Font.PLAIN,10), 
    		new Font("serif",Font.ITALIC,20), new Font("monospaced",Font.ITALIC,16), new Font("monospaced",Font.BOLD, 44)  };
    // kolory tekstu
    Color myTextColors[] = { new Color(255, 255, 255), new Color(100, 50, 20),
        new Color(201, 0, 245), new Color(100, 0, 250), new Color(200, 20, 30) };
    // podpowiedzi
    String myToolTips[] = {"Etykieta 1","Etykieta 2","itd.","...","Ostatnia etykieta"};
    // ramki
    Border myBorders[] = { BorderFactory.createLineBorder(Color.MAGENTA, 5), 
    		BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY), BorderFactory.createLineBorder(Color.ORANGE, 12), 
    		BorderFactory.createLineBorder(Color.YELLOW, 8), BorderFactory.createEtchedBorder(Color.RED, Color.PINK) };
    
    JFrame f = new JFrame();
    f.setVisible(true);
    f.setSize(610,430);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setTitle("Zadanie 3.1");
    f.setLayout(new BorderLayout());
    for (int i = 0; i < 5; i++) {
    	JLabel myLabel = new JLabel(myTexts[i]);
    	myLabel.setBackground(myColors[i]);
    	myLabel.setOpaque(true);
    	myLabel.setFont(myFonts[i]);
    	myLabel.setForeground(myTextColors[i]);
    	myLabel.setToolTipText(myToolTips[i]);
    	myLabel.setBorder(myBorders[i]);
    	f.add(myLabel, myArguments[i]);
    }
  }
}