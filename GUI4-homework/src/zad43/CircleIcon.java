package zad43;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class CircleIcon implements Icon {

	private int diameter = 8; // średnica kółka-ikony (domyślnie: 8)
	Color iconColor = Color.LIGHT_GRAY; // kolor kółka-ikony (domyślnie: jasnoszary)

	// tablica obsługiwanych kolorów i przyporządkowanych im nazw
	static String[] colorNames = {"Black", "Blue", "Green", "Orange", "Red", "Yellow", "White"};
	static Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.ORANGE, Color.RED, Color.YELLOW, Color.WHITE};
		
	CircleIcon(String colorName) {
		for (int i=0; i < colorNames.length; i++) {
			if (colorName.equalsIgnoreCase(colorNames[i])) {
				iconColor = colors[i];
			}
		}		
	}
	
	@Override
	public int getIconHeight() {
		return diameter;
	}

	@Override
	public int getIconWidth() {
		return diameter;
	}
	
	public Color getIconColor() {
		return iconColor;
	}

	@Override
	public void paintIcon(Component container, Graphics g, int p, int q) {
		g.setColor(iconColor);
		g.fillOval(p, q, diameter - 1, diameter - 1);		
	}
	
}
