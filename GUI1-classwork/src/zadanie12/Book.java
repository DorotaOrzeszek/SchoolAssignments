package zadanie12;

public class Book {

	private String bookAuthor;
	private String bookTitle;
	
	// konstruktor
	Book(String author, String title) {
		bookAuthor = author;
		bookTitle = title;
	}
	
	// formatowanie wydruku na ekran
	public String toString() {
		return bookAuthor + " " + bookTitle;
	}
	
}
