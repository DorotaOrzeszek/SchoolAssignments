package zad23;

public class Towar {

	static int counter = 0;
	String id;
	double weight;
	
	// konstruktor
	Towar(String productId, double productWeight) {
		id = productId;
		weight = productWeight;
		counter++;
	}
	
	// getWeight() zwraca wagę towaru
	public double getWeight() {
		return weight;
	}
}
