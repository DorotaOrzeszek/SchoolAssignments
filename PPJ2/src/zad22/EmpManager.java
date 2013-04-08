/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad22;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class EmpManager {
  
  // metoda defEmp pobiera od użytkownika dane pracownika i na ich podstawie tworzy obiekt Employee
  static Employee defEmp(String msg) {
	  // lista nazw wymaganych pól i lista do przechowywania odpowiedzi użytkownika
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
		  /* umieszczenie danej wprowadzonej przez użytkownika w liście fieldValues
		   * co prawda w mojej implementacji poniższe 2 linie można by zastąpić przez
		   * fieldValues[i] = usersAnswer;
		   * ale skoro w zadaniu kazano wykorzystać też skaner, to wykorzystuję :) */
		  Scanner scan = new Scanner(usersAnswer);
		  fieldValues[i] = scan.next(); 
	  }
	  // przepisanie i konwersja danych z listy odpowiedzi użytkownika do odpowiednich zmiennych
	  String name = fieldValues[0];
	  String surname = fieldValues[1];
	  int age = Integer.parseInt(fieldValues[2]);
	  double wage = Double.parseDouble(fieldValues[3]);
	  // utworzenie nowego pracownika o podanych przez użytkownika danych
	  Employee newEmployee = new Employee(name, surname, age, wage); 
	  return newEmployee;
  }
  
  // metoda showInfo wyświetla informacje o pracowniku
  static void showInfo(Employee employee) {
	  JOptionPane.showMessageDialog(null, employee);
  }
  
  // metoda changeSalary zmienia pensję pracownika o określony procent
  static void changeSalary(Employee employee) {
	  double percent = Double.parseDouble(JOptionPane.showInputDialog("O ile procent zmienić pensję? \n np. 20, 5.5, -10"));
	  employee.chgSalary(percent);
  }
  

  public static void main(String[] args) {
  
    // przykładowy kod sprawdzający poprawność programu (podany w treści zadania)
	Employee janek = new Employee("Jan", "Janek", 30, 4000);
    System.out.println(janek);
    System.out.println(janek.getFirstName() + " " + janek.getLastName());
    System.out.println("Za rok bedzie mial: " + (janek.getAge() + 1) + " lat.");
    janek.chgSalary(3.5);
    System.out.println("I bedzie zarabial: " + janek.getSalary() );
    
    // "interfejs graficzny" programu
    int moreEmployees = JOptionPane.YES_OPTION;
    // pętla pozwalająca na tworzenie wielu nowych pracowników
    while (moreEmployees == JOptionPane.YES_OPTION) {
    	Employee e = defEmp("Podaj dane pracownika");
    	showInfo(e);
    	changeSalary(e);
    	showInfo(e);
    	moreEmployees = JOptionPane.showConfirmDialog(null, "Wprowadzić kolejnego pracownika?", "Kolejny pracownik", JOptionPane.YES_NO_OPTION);
    }
  }
}