package zad11;

public class Person {

	private String name;

	// konstruktor (jako argument przyjmuje imię nowej osoby)
	Person(String personsName) {
		name = personsName;
	}
	
	// getName() zwraca imię osoby
	public String getName() {
		return name;
	}
	
}
