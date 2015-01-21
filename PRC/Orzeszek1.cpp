#include <iostream>
using namespace std;

// stale do testowania zmiany symbolu:
// #define _STAR_
// #define _EQU_

int main () {
#ifdef _STAR_ 
	/* jeśli _STAR_ jest ustawione, to s = '*' */
	char s = '*';
#endif
#ifdef _EQU_
	/* jeśli _EQU_ jest ustawione, to s = '=' */
	char s = '=';
#endif
	/* jeśli ustawione jest i _STAR_ i _EQU_, to wystąpi błąd kompilacji, bo redefiniujemy zmienną*/
	/* jeśli anie _STAR_ ani _EQU_ nie jest ustawione, to wystąpi błąd kompilacji, bo nie zdefiniowaliśmy zmiennej s*/
	int a;
	int b;
	int c;
	cout << "Proszę wpisać pierwszą liczbę naturalną: ";
	cin >> a;
	cout << "Proszę wpisać drugą liczbę naturalną: ";
	cin >> b;
	cout << "Proszę wpisać trzecią liczbę naturalną: ";
	cin >> c;
	/* znalezienie najwiekszej z liczb a, b, c */
	int max = a;
	if (max < b) {
		max = b;
	}
	if (max < c) {
		max = c;
	}
	while (max > 0) {
		if (max - a <= 0) {
			cout << s;
		} else {
			cout << " ";
		} 
		if (max - b <= 0) {
			cout << s;
		} else {
			cout << " ";
		} 
		if (max - c <= 0) {
			cout << s;
		} else {
			cout << " ";
		} 
		cout << endl;
		max--;
	}
}
