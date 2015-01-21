#include <iostream>
#include <algorithm>

using namespace std;

struct Node {
	char letter;
	int left;
	int right;
};
Node tree[10000005];
int usednodes = 1;

string eldestword;

void addpath(char letter, string directions) {
	int index = 0;
	for (int i = 2; i < directions.size(); i++) {
		if (directions[i] == 'L') {
			if (tree[index].left == 0) {
				tree[index].left = usednodes;
				usednodes++;
			}
			index = tree[index].left;
		}
		if (directions[i] == 'R') {
			if (tree[index].right == 0) {
				tree[index].right = usednodes;
				usednodes++;
			}
			index = tree[index].right;
		}
	}
	tree[index].letter = letter;
}

void findwords(int index, string prefix) {
	prefix += tree[index].letter;
	if (tree[index].left != 0) {
		findwords(tree[index].left, prefix);
	}
	if (tree[index].right != 0) {
		findwords(tree[index].right, prefix);
	}
	if (tree[index].left == 0 && tree[index].right == 0) {
		reverse(prefix.begin(), prefix.end());
		//cout << index << "|" << prefix << "|" << eldestword << endl;
		if (eldestword < prefix) {
			eldestword = prefix;
		}
	}
}

int main() {
	string line;
	while (true) {
		getline(cin, line);
		if (cin.eof()) {
			break;
		}
		addpath(line[0], line);
	}
//	cout << endl;
//	for (int i=0; i<usednodes; i++) {
//		cout << tree[i].letter << tree[i].left << tree[i].right << endl;
//	}
	
	findwords(0, "");
	cout << eldestword;
	return 0;
}
