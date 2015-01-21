#include <vector>
#include <iostream>

using namespace std;

int main() {
	int t;
	vector<int> C;
	int new_element;
	// reading intput
	cin >> t;
	cin >> new_element;
	while (!cin.eof()) {
		C.push_back(new_element);
		cin >> new_element;
	}
	// algorithm
	if (C.size()==0) {
		cout << -1;
		return 0;
	} else {
		int c;
		int pos = 0;
		for (int i=0; i<t; i++) {
			if (C[pos] % 2 == 0) {   // R
				c = C[(pos+1) % C.size()];   // c <- element at position (pos+1)
				if (pos == C.size()-1) {
					C.erase(C.begin());
					pos--;
				} else {
					C.erase(C.begin() + (pos+1));
				}
				if (C.size()==0) {
					cout << -1;
					return 0;
					break;
				}
			} else {   // X
				c = C[pos];   // c <- element at position pos
				C.insert(C.begin()+pos+1, c-1);
			}
			pos = (pos + c) % C.size();
		}
		for (int i=0; i<C.size(); i++) {
			if (pos < C.size()) {
				cout << C[pos] << " ";
			} else {
				int temp = pos % C.size();
				cout << C[temp] << " ";
			}
			pos++;
		}
	}
	return 0;
}
