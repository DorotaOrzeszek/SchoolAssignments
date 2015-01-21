/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad32;


public class NumTeller {

	// zwraca liczbę z odpowiednim przyrostkiem
	static String say(int n) {
		String number;
		// sign = 1, gdy liczba dodatnia i -1, gdy ujemna
		int sign = 1;
		if (n < 0) {
			n *= -1;
			sign = -1;
		}
		// 0-owy
		if (n == 0) {
			number = n + "-owy";
		// 1-szy, 21-szy, 101-szy itd.
		} else if (n % 10 == 1 && n % 100 != 11) {
			number = sign*n + "-szy";
		// 2-gi, 32-gi, 202-gi itd.
		} else if (n % 10 == 2 && n % 100  != 12) {
			number = sign*n + "-gi";
		// 3-ci, 43-ci, 333-ci itd.
		} else if (n % 10 == 3 && n % 100  != 13) {
			number = sign*n + "-ci";
		// 7-my, 8-my, 28-my, 1237-my itd.
		} else if ((n % 10 == 7 && n % 100  != 17) || (n % 10 == 8 && n % 100 != 18)) {
			number = sign*n + "-my";
		// 1000000-owy itd.
		} else if (n % 1000000 == 0) {
			number = sign*n + "-wy";
		// 100-ny, 270300-ny itd.
		} else if (n % 100 == 0) {
			number = sign*n + "-ny";
		// wszystkie pozostałe liczby
		} else {
			number = sign*n + "-ty";
		} return number;
	}
}