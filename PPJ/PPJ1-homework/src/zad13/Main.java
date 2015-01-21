/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad13;

public class Main {
  public static void main(String ... args) {
    int numOfBooks; // = liczba ksiazek
    int shelfCap; // = pojemnosc polki
    // inicjalizacja zmiennych numOfBooks i shelfCap
    numOfBooks = 2;
    shelfCap = 5;
    // przykładowe testy w formacie:
    // (testowe numOfBooks, testowe shelfCap) = (poprawny wynik getNumOfShelves(), poprawny wynik getBooksOnLastShelf()):
    // (0,0) = (-1,-1) (BŁĄD), (5,0) = (-1,-1) (BŁĄD), (0,5) = (0,0), (2,5) = (1,2), (6,5) = (2,1), (10,5) = (2,5)
    BooksOnShelves b = new BooksOnShelves(numOfBooks, shelfCap);
    System.out.println("Liczba pólek: " + b.getNumOfShelves());
    System.out.println("Liczba ksiazek na ostatniej pólce: " + b.getBooksOnLastShelf());
  }
}