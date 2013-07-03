package zad33;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

public class ImagePanelTest extends JFrame {

	  public ImagePanelTest(String fname) throws InterruptedException {
	    ImagePanel p = new ImagePanel(fname);
	    add(p);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	  }

	  private BufferedReader readTestFile() throws FileNotFoundException {
			FileReader testFile = new FileReader(filePath);		
			return new BufferedReader(testFile);
		}
	  
	  public static void main(String args[]) throws IOException, InterruptedException {
		  // odczytanie pliku
		  String startFile = "c:\\Temp\\obrazki.txt";
		  BufferedReader infoFile = new BufferedReader( new FileReader(startFile) );
		  String info[] = infoFile.readLine().split(" ");
		  String path = info[0];
		  int delay = Integer.parseInt(info[1]);
		  int fontSize = Integer.parseInt(info[2]);
		  
		  // wczytanie listy ścieżek do plików z obrazkami
		  File directory = new File(path);
		  File listOfImages[] = directory.listFiles(); 
		  String imageNames[] = new String[listOfImages.length];
		  infoFile.close();
		  for (int i=0; i < listOfImages.length; i++) {
			  imageNames[i] = listOfImages[i].toString();			  
		  }	
		  
		  // uruchomienie nowego okienka dla każdego obrazka
		  for (String imageName : imageNames) {
			  new ImagePanelTest(imageName);
		   	  Thread.sleep(1000*delay);
		  }

	  }
	}