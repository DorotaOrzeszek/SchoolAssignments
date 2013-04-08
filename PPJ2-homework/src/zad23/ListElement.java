package zad23;

import zad22.Employee;

public class ListElement {

	Employee employee;
	ListElement prev = null;
	ListElement next = null;
	static int counter = 0;	// licznik pracowników na liście
	static ListElement firstEmployee = null;	// pole przechowujące pierwszy element listy
	static ListElement lastEmployee = null;	// // pole przechowujące ostatni element listy
	
	// konstruktor
	ListElement(Employee e) throws Exception {
		counter++;
		employee = e;
		if (counter > 1) {
			prev = lastEmployee;
			lastEmployee.next = this;
		} else if (counter == 1) {
			firstEmployee = this;
		}
		lastEmployee = this;
	}
	
	// wyświetlanie spisu pracowników w kolejności podanej przez użytkownika
	static String showForward() {
		String forwardEmployeeList = "";
		ListElement currentEmployee = firstEmployee;
		for (int i = 0; i < counter; i++) {
			forwardEmployeeList += currentEmployee.employee + "\n";
			currentEmployee = currentEmployee.next;
		}
		return forwardEmployeeList;
	}
	
	// wyświetlanie spisu pracowników w kolejności odwrotnej do tej podanej przez użytkownika
	static String showBackward() {
		String backwardEmployeeList = "";
		ListElement currentEmployee = lastEmployee;
		for (int i = 0; i < counter; i++) {
			backwardEmployeeList += currentEmployee.employee + "\n";
			currentEmployee = currentEmployee.prev;
		}
		return backwardEmployeeList;
	}
	
	// zmiana pensji wszystkich pracowników na liście o tę samą wartość procentową
	static void changeAllSalaries(double percent) {
		ListElement currentEmployee = firstEmployee;
		for (int i = 0; i < counter; i++) {
			currentEmployee.employee.chgSalary(percent);
			currentEmployee = currentEmployee.next;
		}
	}
	
}
