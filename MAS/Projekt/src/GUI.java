import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class GUI extends JFrame {

	PanelMojePrace panelMojePrace;
	ImageIcon icon;

	public GUI () {
		
		super("System Obsługi Prac Dyplomowych");
		setLayout(new BorderLayout());
		
		/*
		 * tytuł
		 */
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		
		icon = new ImageIcon(getClass().getResource("logo.png"));
		JLabel logo = new JLabel(icon);
		titlePanel.add(logo);
		
		JLabel pageTitle = new JLabel("System Obsługi Prac Dyplomowych");
		titlePanel.add(pageTitle);
		
		/*
		 * menu
		 */
		
		String[] menuItems = {"Moje konto", "Dodaj pracę dyplomową", "Wyszukaj pracę dyplomową"};
		JList menu = new JList(menuItems);
		
		/*
		 * główny panel
		 */
		
		panelMojePrace = new PanelMojePrace();
		
		/*
		 * dodanie wszystkich elementów ekranu do okna
		 */
		
		add(titlePanel, BorderLayout.NORTH);
//		add(new JSeparator(SwingConstants.HORIZONTAL));
		add(menu, BorderLayout.WEST);
//		add(new JSeparator(SwingConstants.VERTICAL));
		add(panelMojePrace, BorderLayout.CENTER);
		int x = panelMojePrace.getWidth();
		System.out.println("added panelMojePrace " + x);
		
	}

}
