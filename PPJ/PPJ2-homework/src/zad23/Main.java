/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad23;

import javax.swing.JOptionPane;

import zad22.Employee;


public class Main {
  
	static ListElement defEmp(String msg) throws Exception {
		  // tablica nazw wymaganych pól i lista do przechowywania odpowiedzi użytkownika
		  // można by równie dobrze kolejno wczytywać poszczególne pola, bez tablicy, ale tak jest moim zdaniem bardziej przejrzyście
		  // (*) zakładam, że użytkownik nie jest złośliwy i wpisze dane odpowiedniego typu
		  String[] fieldNames = {"Imię (napis)", "Nazwisko (napis)", "Wiek (liczba)", "Pensja (liczba)"};
		  String[] fieldValues = new String[4];
		  // dla każdego wymaganego pola pojawi się nowy dialog z odpowiednim komunikatem
		  for (int i = 0; i < fieldNames.length; i++) {
			  String newMsg = msg + "\n" + fieldNames[i] + " :";
			  String usersAnswer = JOptionPane.showInputDialog(newMsg);
			  // gdy użytkownik nie poda wymaganej danej, przypomni mu o tym oddzielny dialog
			  while (usersAnswer.equals("")) {
				  JOptionPane.showMessageDialog(null, "Nie podano danych");
				  usersAnswer = JOptionPane.showInputDialog(newMsg);
			  }
			  fieldValues[i] = usersAnswer;
		  }
		  // przepisanie i konwersja danych z listy odpowiedzi użytkownika do odpowiednich zmiennych
		  String name = fieldValues[0];
		  String surname = fieldValues[1];
		  int age = Integer.parseInt(fieldValues[2]);
		  double wage = Double.parseDouble(fieldValues[3]);
		  // utworzenie nowego rekordu pracownika o podanych przez użytkownika danych
		  Employee newEmployee = new Employee(name, surname, age, wage);
		  ListElement element = new ListElement(newEmployee);
		  return element;
	  } 
	
	public static void main(String ... args) throws Exception {
		
		// "interfejs graficzny" programu
	    int moreEmployees = JOptionPane.YES_OPTION;
	    // pętla pozwalająca na tworzenie wielu nowych pracowników
	    while (moreEmployees == JOptionPane.YES_OPTION) {
	    	ListElement element = defEmp("Podaj dane pracownika");
	    	moreEmployees = JOptionPane.showConfirmDialog(null, "Wprowadzić kolejnego pracownika?", "Kolejny pracownik", JOptionPane.YES_NO_OPTION);
	    }
	    // wyświetlenie listy pracowników w zwykłej i odwróconej kolejności
	    String message1 = "Employee list: \n" + ListElement.showForward();
	    String message2 = "Employee list backwards: \n" + ListElement.showBackward();
	    JOptionPane.showMessageDialog(null, message1 + "\n" + message2);
	    // pobranie od użytkownika procentu zmiany pensji i wyświetlenie zmienionych pensji
	    double percent = Double.parseDouble(JOptionPane.showInputDialog("O ile procent zmienić pensje? \n np. 20, 5.5, -10"));
	    ListElement.changeAllSalaries(percent);
	    String message3 = "Employee list with changed salaries: \n" + ListElement.showForward();
	    JOptionPane.showMessageDialog(null, message3);
	}
}