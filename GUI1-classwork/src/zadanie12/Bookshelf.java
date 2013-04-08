package zadanie12;

import java.util.ArrayList;

public class Bookshelf {

	private String shelfName;
	private int shelfCapacity;
	private ArrayList<Book> booksOnShelf;
	
	// konstruktor
	Bookshelf(String name, int capacity) {
		shelfName = name;
		shelfCapacity = capacity;
		booksOnShelf = new ArrayList<Book>(shelfCapacity);
	}
	
	// formatowanie wydruku na ekran
	public String toString() {
		return "Półka " + shelfName;
	}
	
	void insert(Book book) throws Exception {
		if (booksOnShelf.size() < shelfCapacity) {
			booksOnShelf.add(book);
		} else {
			throw new Exception();
		}
	}
	
	void remove(Book book) {
		booksOnShelf.remove(book);
	}
	
	ArrayList<Book> getBooks() {
		return booksOnShelf;
	}
	
}
