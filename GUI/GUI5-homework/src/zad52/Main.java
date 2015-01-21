/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad52;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// model listy
class ExtendableListModel extends AbstractListModel {

	Vector v = new Vector(); // zawiera elementy listy
	
	ExtendableListModel() {} // domyślny konstruktor
	
	// konstruktor do tworzenia listy z "gotowca"
	ExtendableListModel(Object[] initialList) {
		for (int i = 0; i < initialList.length; i++) v.addElement(initialList[i]);
	}	
	
	@Override
	// zwraca elementy listy dla poszczególnych indeksów i
	public Object getElementAt(int i) {
		return v.elementAt(i);
	}

	@Override
	// zwraca długość listy, tj. wektora v
	public int getSize() {
		return v.size();
	}	
	
	// dodaje element na końcu listy
	public void add(Object element) {
		v.add( getSize(), element);
		fireContentsChanged(v, 0, this.getSize());
	}

	// usuwa element na pozycji i
	void remove(int i) {
		v.removeElementAt(i);
		fireIntervalRemoved(this, i, i);
	}

}

// dodawanie elementu z listy
class AddToList implements ActionListener {

	ExtendableListModel listModel;
	JTextField textField;
	
	public AddToList(ExtendableListModel listModel, JTextField textField) {
		this.listModel = listModel;
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listModel.add(textField.getText());
	}	
}

// usuwanie elementu z listy
class RemoveFromList implements MouseListener {

	ExtendableListModel listModel;
	JList list;
	
	public RemoveFromList(ExtendableListModel listModel, JList list) {
		this.listModel = listModel;
		this.list = list;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.isAltDown()) {
			int index = list.getSelectedIndex();
			listModel.v.remove(index);
		}	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) {	}

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	
}

public class Main {
	public static void main(String ... args) {
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		// utworzenie listy i podłączenie do niej zdarzeń
	    String[] initialElements = { "Dzień dobry!", "Wpisz coś w pole tekstowe", "Dodaj element z pola wciskając enter", "Usuń element alt-klikając" };
		ExtendableListModel listModel = new ExtendableListModel(initialElements);
		JList  list = new JList(listModel);
		JTextField textField = new JTextField();
		textField.setColumns(50);
		AddToList action1 = new AddToList(listModel, textField);
		textField.addActionListener(action1);
		RemoveFromList action2 = new RemoveFromList(listModel, list);
		list.addMouseListener(action2);
		// lista początkowych elementów listy
		JScrollPane scrollPane = new JScrollPane(list);
		mainPanel.add(scrollPane);
		frame.add(textField,"North");
		frame.add(mainPanel,"Center");
		frame.setVisible(true);  
	}

	
}