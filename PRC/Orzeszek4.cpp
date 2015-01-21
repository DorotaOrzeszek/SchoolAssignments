#include <stdlib.h>
#include <iostream>
using namespace std;

void info(unsigned short kod) {
	int plec = (kod & 0b1000000000000000)>>15;
	int stan_cyw = (kod & 0b0110000000000000)>>13;
	int grupa_wiek = (kod & 0b0001100000000000)>>11;
	int edu = (kod & 0b0000011000000000)>>9;
	int zam = (kod & 0b0000000110000000)>>7;
	int region = (kod & 0b0000000001111000)>>3;
	int odp = kod & 0b0000000000000111;
	cout << "plec: " << plec << endl;
	cout << "stan cywilny: " << stan_cyw << endl;
	cout << "grupa wiekowa: " << grupa_wiek << endl;
	cout << "wyksztalcenie: " << edu << endl;
	cout << "miejsce zam.: " << zam << endl;
	cout << "region: " << region << endl;
	cout << "odpowiedz: " << odp << endl;
}

unsigned short koduj(int plec, int stan_cyw, int grupa_wiek, int edu, int zam, int region, int odp) {
	unsigned short kod = 0b0000000000000000;
	// zakodowanie zmiennej plec
	if (plec == 1) kod = (kod | 0b1000000000000000);
	// zakodowanie zmiennej stan_cyw
	if (stan_cyw = 1) kod = (kod | 0b0010000000000000);
	else if (stan_cyw = 2) kod = (kod | 0b0100000000000000);
	else if (stan_cyw = 3) kod = (kod | 0b0110000000000000);
	// zakodowanie zmiennej grupa_wiek
	if (grupa_wiek = 1) kod = (kod | 0b0000100000000000);
	else if (grupa_wiek = 2) kod = (kod | 0b0001000000000000);
	else if (grupa_wiek = 3) kod = (kod | 0b0001100000000000);
	// zakodowanie zmiennej edu
	if (edu = 1) kod = (kod | 0b0000001000000000);
	else if (edu = 2) kod = (kod | 0b0000010000000000);
	else if (edu = 3) kod = (kod | 0b0000011000000000);
	// zakodowanie zmiennej zam
	if (zam = 1) kod = (kod | 0b0000000010000000);
	else if (zam = 2) kod = (kod | 0b0000000100000000);
	else if (zam = 3) kod = (kod | 0b0000000110000000);
	// zakodowanie zmiennej region
	if (region = 1) kod = (kod | 0b0000000000001000);
	else if (region = 2) kod = (kod |  0b0000000000010000);
	else if (region = 3) kod = (kod |  0b0000000000011000);
	else if (region = 4) kod = (kod |  0b0000000000100000);
	else if (region = 5) kod = (kod |  0b0000000000101000);
	else if (region = 6) kod = (kod |  0b0000000000110000);
	else if (region = 7) kod = (kod |  0b0000000000111000);	
	else if (region = 8) kod = (kod |  0b0000000001000000);	
	else if (region = 9) kod = (kod |  0b0000000001001000);
	else if (region = 10) kod = (kod |  0b0000000001010000);
	else if (region = 11) kod = (kod |  0b0000000001011000);
	else if (region = 12) kod = (kod |  0b0000000001100000);
	else if (region = 13) kod = (kod |  0b0000000001101000);
	else if (region = 14) kod = (kod |  0b0000000001110000);
	else if (region = 15) kod = (kod |  0b0000000001111000);
	// zakodowanie zmiennej odp
	if (odp = 1) kod = (kod |  0b0000000000000001);
	else if (odp = 2) kod = (kod | 0b0000000000000010);
	else if (odp = 3) kod = (kod |  0b0000000000000011);
	else if (odp = 4) kod = (kod |  0b0000000000000100);
	else if (odp = 5) kod = (kod |  0b0000000000000101);
	else if (odp = 6) kod = (kod |  0b0000000000000110);
	else if (odp = 7) kod = (kod |  0b0000000000000111);
	cout << kod << endl;
}

int main() {
	// tutaj podajemy wartosc kodu dla funkcji info() i uruchamiamy ja
	unsigned short kod = 0b0000000000001100;
	info(kod);
	/* tutaj funkcja koduj() powinna generowac wartosc kodu dla danych parametrow,
	ale wyglada na to, ze generuje go niepoprawnie :( */
	koduj(1,0,0,0,0,0,1);
}
