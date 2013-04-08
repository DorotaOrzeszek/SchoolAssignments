/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad22;


public class Employee {

	private String firstName;
	private String lastName;
	private int age;
	private double salary;
	
	// konstruktor
	public Employee(String name, String surname, int years, double wage) {
		firstName = name;
		lastName = surname;
		age = years;
		salary = wage;
	}
	
	// formatowanie wydruku na ekran
	public String toString() {
		return this.getFirstName() + " " +
				this.getLastName() + " " +
				this.getAge() + " " +
				this.getSalary();
	}
	
	String getFirstName() {
		return firstName;
	}
	
	String getLastName() {
		return lastName;
	}
	
	int getAge() {
		return age;
	}
	
	double getSalary() {
		return salary;
	}
	
	void setSalary(double newSalary) {
		salary = newSalary;
	}
	
	public double chgSalary(double percent) {
		salary *= (1 + percent/100.0);
		return salary;
	}
	
	
}