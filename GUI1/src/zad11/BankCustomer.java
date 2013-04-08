package zad11;

public class BankCustomer {
	
	private String customersName;
	private Account customersAccount;

	// konstruktor (jako argument przyjmuje osobę, która stanie się klientem banku)
	BankCustomer(Person person) {
		customersName = person.getName();	// imię nowego klienta
		customersAccount = new Account();	// zakładamy klientowi rachunek :)
	}
	
	// toString() pozwoli wypisywać System.out.println(klient) w pożądanej postaci
	public String toString() {
		return "Klient: " + customersName + " stan konta " + customersAccount.balance;
	}
	
	// getAccount sprawdza i zwraca stan konta klienta
	public Account getAccount() {
		return customersAccount;
	}
	
	// getCustomersName sprawdza i zwraca imię klienta
	public String getCustomersName() {
		return customersName;
	}

}
