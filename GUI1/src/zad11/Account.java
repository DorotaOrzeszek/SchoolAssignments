package zad11;

public class Account {
	
	static double interestRate;
	double balance = 0;
	
	// setInterestRate() ustawia oprocentowanie wszystkich rachunków
	public static void setInterestRate(double rate) {
		interestRate = rate;
	}
	
	// deposit() zmienia saldo konta klienta w wyniku wpłaty
	public void deposit(int amount) {
		balance += amount;
	}
	
	// withdraw() zmienia saldo konta klienta w wyniku wypłaty
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	// transfer() zmienia salda kont 2 klientów w wyniku wykonania przelewu
	public void transfer(Account beneficiarysAccount, int amount) {
		balance -= amount;
		beneficiarysAccount.balance += amount;
	}
	
	// addInterest() zmienia saldo konta klienta w wyniku dopisania do niego rocznych odsetek
	public void addInterest() {
		balance *= (1+interestRate/100.0);
	}
}
