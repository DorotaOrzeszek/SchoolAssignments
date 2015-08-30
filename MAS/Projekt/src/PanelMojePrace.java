import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class PanelMojePrace extends JPanel {
	
	
	
	public PanelMojePrace () {

		super(new BorderLayout());
		
		JLabel title = new JLabel("Prace dyplomowe");
		add(title, BorderLayout.NORTH);
		
		String[] nazwyPracDyplomowych = {"ABC", "DEF", "GHI", "JKL"};
		JList listaPracDyplomowych = new JList(nazwyPracDyplomowych);
		add(listaPracDyplomowych, BorderLayout.CENTER);
		
		JPanel details = new JPanel();
		details.setLayout(new FlowLayout());
		add(details, BorderLayout.SOUTH);
		
		JButton b = new JButton("Dodaj pracę dyplomową");
		details.add(b);
		
		System.out.println("PanelMojePrace");
	}
}
