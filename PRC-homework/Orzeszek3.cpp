#include <stdlib.h>
#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

// funkcje pomocnicze
bool has_8_chars(const char* s) {
	if ( strlen(s) >= 8 )
		return true;
	return false;
}

bool has_6_different_chars(const char* s) {
	char chars[6];
	chars[0] = s[0];
	unsigned int i = 1;
	for (unsigned int j = 1; j < strlen(s); j++) {
		bool isequal = false;
		for (unsigned int k = 0; k < i; k++) {
			if ( chars[k] == s[j] ) {
				isequal = true;
				break;
			}
		}
		if ( ! isequal ) {
			chars[i] = s[j];
			i++;
		}
		if ( i == 6 )
			return true;
	}
	return false;
}

bool has_integer(const char* s) {
	for (unsigned int i = 0; i < strlen(s); i++) {
		if ( s[i] >= '0' && s[i] <= '9' ) {
			return true;
		}
	}
	return false;
}

bool has_capital(const char* s) {
	for (unsigned int i = 0; i < strlen(s); i++) {
		if ( s[i] >= 'A' && s[i] <= 'Z' ) {
			return true;
		}
	}
	return false;
}

bool has_small(const char* s) {
	for (unsigned int i = 0; i < strlen(s); i++) {
		if ( s[i] >= 'a' && s[i] <= 'z') {
			return true;
		}
	}
	return false;
}

bool has_punctuation(const char* s) {
	for (unsigned int i = 0; i < strlen(s); i++) {
		if ( s[i] < '0' ) {
			return true;
		} else if ( s[i] > '9' && s[i] < 'A') {
			return true;
		} else if ( s[i] > 'Z' && s[i] < 'a' ) {
			return true;
		} else if ( s[i] > 'z' ) {
			return true;
		}
	}
	return false;
}

// glowna funkcja sprawdzjaca haslo
bool check(const char* pass) {
	if ( ! has_8_chars(pass) ) {
		cout << "Haslo zawiera mniej niz 8 znakow"<< endl;
		return false;
	}
	if ( ! has_6_different_chars(pass) ) {
		cout << "Haslo zawiera mniej niz 6 roznych znakow" << endl;
		return false;
	}
	if ( ! has_integer(pass) ) {
		cout << "Haslo nie zawiera cyfry" << endl;
		return false;
	}
	if ( ! has_capital(pass) ) {
		cout << "Haslo nie zaiwera wielkiej litery" << endl;
		return false;
	}
	if ( ! has_small(pass) ) {
		cout << "Haslo nie zawiera malej litery" << endl;
		return false;
	}
	if ( ! has_punctuation(pass) ) {
		cout << "Haslo nie zawiera znaku interpunkcyjnego" << endl;
		return false;
	}
	cout << "Haslo jest OK" << endl;
	return true;
}

int main () {
	char pass[100];
	scanf("%s", pass);
	check(pass);
}
