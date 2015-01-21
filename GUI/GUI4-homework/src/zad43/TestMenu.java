package zad43;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class TestMenu extends JFrame implements ActionListener {

	// addMenuOptions dodaje do zadanego menu elementy z listy menuItems wraz z mnemonikami
	public void addMenuOptions(JMenu menu, List<JMenuItem> menuItems, char[] mnemonics) {
		for(int i = 0; i < menuItems.size(); i++) {
			JMenuItem mi = menuItems.get(i);
			if (mnemonics != null) { 
				mi.setMnemonic(mnemonics[i]);
				mi.setAccelerator(KeyStroke.getKeyStroke(
					(int) mnemonics[i], ActionEvent.CTRL_MASK));
			}
			menu.add(mi);
		}
	}
	
	// createColorMenuItems tworzy listę elementów menu z serii napisów
	private List<JMenuItem> createMenuItems(String ... items) {
	    List<JMenuItem> list = new ArrayList<JMenuItem>();
	    for(String s : items) {
	      JMenuItem mi = new JMenuItem(s);
	      mi.addActionListener(this);
	      list.add(mi);
	    }
	    return list;
	}
	
	// createColorMenuItems tworzy listę kolorów - elementów menu z serii napisów
	private List<JMenuItem> createColorMenuItems(String ... items) {
		List<JMenuItem> list = new ArrayList<JMenuItem>();
	    for(String s : items) {
	      JMenuItem mi = new JMenuItem(s);
	      mi.setIcon(new CircleIcon(s));
	      mi.addActionListener(this);
	      list.add(mi);
	    }
	    return list;
	}
	
	// dane do tworzenia menu edytora
	List<JMenuItem> fileItems = createMenuItems("Open", "Save", "Save as");
    char[] fileItemsMnemonics = {'O','S','A','X'};
    List<JMenuItem> addressItems = createMenuItems("Dom", "Szkoła", "Firma");
    char[] addressItemsMnemonics = {'D','S','F'};
    List<JMenuItem> optionsItems = createMenuItems("Foreground", "Background", "Font size");
    List<JMenuItem> foregroundItems = createColorMenuItems("Yellow","Orange","Black");
    List<JMenuItem> backgroundItems = createColorMenuItems("Blue","Red","White");
    List<JMenuItem> fontSizeItems = createMenuItems("8 pts", "10 pts", "12 pts", "14 pts", "16 pts", "18 pts", "20 pts", "22 pts", "24 pts");
    // przy większej liczbie wielkości czcionki warto byłoby automatycznie wygenerować napisy "x pts", ale tu zwykłe kopiuj-wklej było szybsze
    JMenuItem exitItem = new JMenuItem("Exit");
    JTextArea ta = new JTextArea(10,20);
    JFileChooser currentFile = null;	// "spamiętywanie" obecnie otwartego pliku
    File lastDirectory;	// "spamiętywanie" ostatnio otwartego katalogu
    
	public TestMenu() {
	    
	    // menu "File"
	    JMenu pulldown1 = new JMenu("File");
	    addMenuOptions(pulldown1, fileItems, fileItemsMnemonics);
	    pulldown1.addSeparator();
	    exitItem.setMnemonic('X');
	    exitItem.setAccelerator(KeyStroke.getKeyStroke(
				(int) 'X', ActionEvent.CTRL_MASK));
	    exitItem.addActionListener(this);
	    pulldown1.add(exitItem);
	    
	    // menu "Edit"
	    JMenu pulldown2a = new JMenu("Adresy");
	    addMenuOptions(pulldown2a, addressItems, addressItemsMnemonics);
	    JMenu pulldown2 = new JMenu("Edit");
	    pulldown2.add(pulldown2a);
	    
	    // menu "Options"
	    JMenu pulldown3a = new JMenu("Foreground");
	    addMenuOptions(pulldown3a, foregroundItems, null);
	    JMenu pulldown3b = new JMenu("Background");
	    addMenuOptions(pulldown3b, backgroundItems, null);
	    JMenu pulldown3c = new JMenu("Font size");
	    addMenuOptions(pulldown3c, fontSizeItems, null);
	    JMenu pulldown3 = new JMenu("Options");
	    pulldown3.add(pulldown3a);
	    pulldown3.add(pulldown3b);
	    pulldown3.add(pulldown3c);
	    
	    // dodanie wszystkich menu do okna
	    JMenuBar mb = new JMenuBar();
	    mb.add(pulldown1);
	    mb.add(pulldown2);
	    mb.add(pulldown3);
	    setJMenuBar(mb);
	    
	    // dodanie pola tekstowego edytora
	    add(new JScrollPane(ta));
	    ta.setFont(new Font("sansserif",Font.PLAIN,14));
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setTitle("Prosty edytor - " + "bez tytułu"); // domyślny napis na górnym pasku okna
	    setSize(800, 400);
	    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// otwieranie pliku - "Open"
		if (e.getSource().equals(fileItems.get(0))) {
			JFileChooser openFile = new JFileChooser();
			openFile.setCurrentDirectory(lastDirectory);
			int returnVal = openFile.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(openFile.getSelectedFile().getAbsolutePath()));
					ta.read(br, null);
					br.close();
					ta.requestFocus();
					setTitle("Prosty edytor - " + currentFile.getSelectedFile().getAbsolutePath());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				currentFile = openFile;
				lastDirectory = currentFile.getSelectedFile().getParentFile();
			} 
		// zapisywanie pliku - "Save"
		} else if (e.getSource().equals(fileItems.get(1))) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile.getSelectedFile().getAbsolutePath()));
				ta.write(bw);
				bw.close();
				ta.requestFocus();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		// zapisywanie pliku jako - "Save As"
		} else if (e.getSource().equals(fileItems.get(2))) {
			JFileChooser saveAsFile = new JFileChooser();
			int returnVal = saveAsFile.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				currentFile = saveAsFile;
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(saveAsFile.getSelectedFile().getAbsolutePath()));
					ta.write(bw);
					bw.close();
					ta.requestFocus();
					setTitle("Prosty edytor - " + currentFile.getSelectedFile().getAbsolutePath());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		// wyjście z programu - "Exit"
		} else if (e.getSource().equals(exitItem)) {
			System.exit(0);
		// wstawienie adresów z menu "Edit"
		} else if (addressItems.contains(e.getSource())) {
			String address;
			if (e.getSource().equals(addressItems.get(0))) {
				address = "DOM - ul. Rodzinna 33";
			} else if (e.getSource().equals(addressItems.get(0))) {
				address = "SZKOŁA - ul. Nauczycielska 42";
			} else {
				address = "FIRMA - ul. Pracowita 100";
			}
			ta.insert(address, ta.getCaretPosition());
		// zmiana rozmiaru czcionki w menu "Options"
		} else if (fontSizeItems.contains(e.getSource())) {
			int pts = Integer.parseInt( ( (JMenuItem)e.getSource() ).getText().split(" ")[0] );
			ta.setFont(new Font("sansserif",Font.PLAIN,pts));
		// zmiana koloru czcionki w menu "Options"
		} else if (foregroundItems.contains(e.getSource())) {
			Color foregroundColor = Color.BLACK;
			String colorName = ((JMenuItem) e.getSource()).getText();
			for (int i=0; i < CircleIcon.colorNames.length; i++) {
				if (colorName.equalsIgnoreCase(CircleIcon.colorNames[i])) {
					foregroundColor = CircleIcon.colors[i];
				}
			}
			ta.setForeground(foregroundColor);
		// zmiana koloru tła w menu "Options"
		} else if (backgroundItems.contains(e.getSource())) {
			Color backgroundColor = Color.WHITE;
			String colorName = ((JMenuItem) e.getSource()).getText();
			for (int i=0; i < CircleIcon.colorNames.length; i++) {
				if (colorName.equalsIgnoreCase(CircleIcon.colorNames[i])) {
					backgroundColor = CircleIcon.colors[i];
				}
			}
			ta.setBackground(backgroundColor);
		}		
	}
	
}
