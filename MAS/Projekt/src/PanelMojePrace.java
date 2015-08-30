import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class PanelMojePrace extends JPanel {
	
	private static JPanel panel;
	
	public PanelMojePrace () {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Prace dyplomowe");
		panel.add(title, BorderLayout.NORTH);
		
		String[] nazwyPracDyplomowych = {"ABC", "DEF", "GHI", "JKL"};
		JList listaPracDyplomowych = new JList(nazwyPracDyplomowych);
		panel.add(listaPracDyplomowych, BorderLayout.CENTER);
		
		JPanel details = new JPanel();
		details.setLayout(new FlowLayout());
		panel.add(details, BorderLayout.SOUTH);
		
		JButton b = new JButton("Dodaj pracę dyplomową");
		details.add(b);
		
		System.out.println("PanelMojePrace");
	}
}
