package zadanie11;

public class Test11 {

	// podajZyski() wyswietla informacje o wydatkach i dochodach oraz oblicza zysk sklepu
	static void podajZyski(Sklep sklep) {
		double zysk = sklep.getDochody() - sklep.getWydatki();
		System.out.println(sklep);
		System.out.println("Wydatki: " + sklep.getWydatki());
		System.out.println("Dochody: " + sklep.getDochody());
		System.out.println("Zysk: " + zysk + "\n");
	}
	
	public static void main(String[] args) {
		
		Sklep.setCenaHurtowa(1.5);
		Sklep.setCenaDetaliczna(3);
		Sklep sklep1 = new Sklep();
		Sklep sklep2 = new Sklep();
		Sklep sklep3 = new Sklep();
		sklep1.kupno(100);
		sklep2.kupno(200);
		sklep3.kupno(300);
		System.out.println("Sklepy: \n" + sklep1 + '\n' + sklep2 + '\n' + sklep3 + '\n');
		sklep1.sprzedaz(95);
		sklep2.sprzedaz(100);
		sklep3.sprzedaz(250);
		podajZyski(sklep1);      // uwaga: to jest wywołanie metody z klasy Test, 
		podajZyski(sklep2);      // którą to metodę też trzeba napisać    
		podajZyski(sklep3); 
	}
	
}
