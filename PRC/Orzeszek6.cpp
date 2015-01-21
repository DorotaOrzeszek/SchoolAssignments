#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

struct Point {
	int x, y;
};

struct Rect {
	Point bottom_left, top_right;
};

void printPoint(const Point& p) {
	cout << "(" << p.x << "," << p.y << ")";
}

void printRect(const Rect* r) {
	cout << "[";
	printPoint(r->bottom_left);
	cout << ",";
	printPoint(r->top_right);
	cout << "]" << endl;
}

bool haveIntersection(const Rect* r1, const Rect* r2) {
	Point a1 = r1->bottom_left;
	Point a2 = r1->top_right;
	Point a3 = r2->bottom_left;
	Point a4 = r2->top_right;
	if ( a3.y > a2.y || a1.y > a4.y || a3.x > a2.x || a1.x > a4.x ) {
		return false;
	} else
		return true;
}

Rect intersection(const Rect* r1, const Rect* r2) {
	if ( !haveIntersection(r1, r2) ) {
		throw string("Error in 'intersection'");
	}
	Point a1 = r2->bottom_left;
	Point a2 = r1->top_right;
	Point a3 = r1->bottom_left;
	Point a4 = r2->top_right;
	Point x = { max(a1.x, a3.x), max(a1.y, a3.y) };
	Point y = { min(a2.x, a4.x), min(a2.y, a4.y) };
	Rect intersection = { x, y };
	return intersection;
}

int main() {
	Rect r1 = { {1,1}, {4,3} };
	Rect r2 = { {2,0}, {3,4} };
	Rect r3 = { {0,4}, {1,5} };

	if (haveIntersection(&r1,&r2)) {
		Rect r = intersection(&r1,&r2);
		printRect(&r);
	} else
		cout << "No intersection" << endl;
	if (haveIntersection(&r1,&r3)) {
		Rect r = intersection(&r1,&r3);
		printRect(&r);
	} else
		cout << "No intersection" << endl;

/* 
Sprawdzenie wartości haveIntersection(r1,r3) w warunku if zabezpiecza program 
przed sytuacją, w której wywołanie intersection(r1,r3) spowoduje wyjątek.
Gdyby nie było takiego sprawdzenia, należałoby napisać, np.

	try {
		Rect r = intersection(&r1,&r3);
		printRect(&r);
	} catch (string error) { cout << error << endl;}

*/

}
