/**
 *
 *  @author Orzeszek Dorota S11409
 *
 */
package zad33;


public class MonthInYear {

	Month month;
	int year;
	// enumeracja symboli miesięcy
	enum Symbols {I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII};
	
	// konstruktor
	MonthInYear(Month m, int y) {
		month = m;
		year = y;
	}
	
	// zwraca rok
	public int getYear() {
		return year;
	}
	
	// zwraca nazwę miesiąca
	public String getMonthName() {
		return month.toString();
	}
	
	// zwraca kolejny numer miesiąca
	public int getMonthNumber() {
		return month.ordinal() + 1;
	}
	
	// zwraca liczbę rzymską reprezentująca miesiąc
	public String getMonthSymbol() {
		return Symbols.values()[this.getMonthNumber()-1].toString();
	}
	
	// zwraca true, gdy rok jest przestępny
	public boolean isLeapYear() {
		if (year % 4 != 0) {
			return false;
		} else {
			if ((year <= 1582) || (year % 400 == 0)) {
				return true;
			} else if ((year > 1582) && (year % 100 == 0)) {
				return false;
			} else {
				return true;
			}			
		}
	}
	
	// zwraca liczbę dni miesiąca
	public int getDays() {
		int days = 7;
		switch (month) {
		case styczen:
			days = 31;
			break;
		case luty:
			// korzystamy z funkcji isLeapYear(), żeby określić czy rok jest przestępny
			if (this.isLeapYear()) {
				days = 29;
			} else {
				days = 28;
			} break;
		case marzec:
			days = 31;
			break;
		case kwiecien:
			days = 30;
			break;
		case maj:
			days = 31;
			break;
		case czerwiec:
			days = 30;
			break;
		case lipiec:
			days = 31;
			break;
		case sierpien:
			days = 31;
			break;
		case wrzesien:
			days = 30;
			break;
		case pazdziernik:
			days = 31;
			break;
		case listopad:
			days = 30;
			break;
		case grudzien:
			days = 31;
			break;
		}
		return days;		
	}	
	
}