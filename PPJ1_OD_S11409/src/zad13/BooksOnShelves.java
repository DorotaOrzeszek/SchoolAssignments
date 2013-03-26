/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad13;


public class BooksOnShelves {

	// pola obiektu BooksOnShelves
	private int numberOfBooks;
	private int shelfCapacity;
	
	// konstruktor uzupełnia pola obiektu (ew. zgłaszając błąd danych)
	BooksOnShelves(int numOfBooks, int shelfCap) {
		numberOfBooks = numOfBooks;
		shelfCapacity = shelfCap;
		if (shelfCapacity == 0) {
			System.out.println("BŁĄD: pojemność półki musi być dodatnią liczbą calkowitą!");
		}
	}

	// getNumOfShelves oblicza minimalną liczbę półek, na których zmieszczą się książki
	public int getNumOfShelves() {
		int numberOfShelves;
		if (shelfCapacity == 0) {
			return -1; // kod błędu
		} else if (numberOfBooks % shelfCapacity == 0) {
			numberOfShelves = numberOfBooks / shelfCapacity;
		} else { // gdy numberOfBook % shelfCapacity != 0
			numberOfShelves = numberOfBooks / shelfCapacity + 1;
		}
		return numberOfShelves;
	}
	
	// getBooksOnLastShelf oblicza liczbę książek na ostatniej wykorzystanej półce
	public int getBooksOnLastShelf() {
		int booksOnLastShelf;
		if (shelfCapacity == 0) {
			return -1; // kod błędu
		} else if (numberOfBooks == 0) {
			booksOnLastShelf = 0;
		} else if (numberOfBooks % shelfCapacity == 0) {
			booksOnLastShelf = shelfCapacity;
		} else { // gdy numberOfBook % shelfCapacity != 0
			booksOnLastShelf = numberOfBooks % shelfCapacity;
		}
		return booksOnLastShelf;
	}
}