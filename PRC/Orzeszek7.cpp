#include <stdlib.h>
#include <iostream>
using namespace std;

template <typename T>
struct Node {
	T data;
	Node* next;
};

/* podpunkt 1 */
template <typename T>
Node<T>* arrayToList(const T tab[], size_t size) {
	Node<T>* head = new Node<T>();
	head->data =	tab[0];
	Node<T>* current_last = head;
	for (int i = 1; i < size; i++) {
		current_last->next = new Node<T>();
		current_last = current_last->next;
		current_last->data = tab[i];
	}
	current_last->next = NULL;
	return head;
}

/* podpunkt 2 */
template <typename T>
Node<T>* extract(Node<T>*& head, bool (*predicate)(const T&)) {
	Node<T>* current = head;
	Node<T>* previous = NULL;
	Node<T>* extract_head = NULL;
	Node<T>* extract_last = NULL;
	while (current != NULL) {
		if (!predicate(current->data)) {
			previous = current;
			current = current->next;
		} else {
			if (extract_last != NULL) {
				extract_last->next = current;
			} else {
				extract_head = current;
			}
			extract_last = current;
			current = extract_last->next;
			extract_last->next = NULL;
			if (previous != NULL) {
				previous->next = current;
			} else {
				head = current;
			}
		}
	}
	return extract_head;
}

/* podpunkt 3 */
template <typename T>
void deleteList(Node<T>*& head) {
	Node<T>* last = head;
	Node<T>* current = head;
	while (last != NULL) {
		last = last->next;
		cout << "DEL " << current->data << "; ";
		delete current;
		current = last;
	}
	cout << endl;
	head = NULL;
}

/* podpunkt 4 */
template <typename T>
void showList (Node<T>* first) {
	Node<T>* current = first;
	while (current != NULL) {
		cout << current->data << " ";
		current = current->next;
	}
	cout << endl;
}
/*
int main() {

	int t[] = {1, 2, 3, 4, 5};
	size_t s = 5;
	
	Node<int>* answer = arrayToList(t, s);
	show_all(answer);

	deleteList(answer);
	show_all(answer);

	return 0;
}
*/


bool isEven(const int& n)
{ return n%2 == 0;
}
bool isLong(const string& s) { return s.size() >=5; }
int main() {
int tabi[] = {2,1,4,3,6,5,7,8};
size_t sizei = sizeof(tabi)/sizeof(tabi[0]);
Node<int> *listAi = arrayToList(tabi, sizei);
showList(listAi);
Node<int> *listBi = extract(listAi,isEven);
showList(listAi);
showList(listBi);
deleteList(listAi);
deleteList(listBi);
string tabs[] = {"Kasia", "Ola", "Ala",
"Zosia", "Ela", "Basia"};
size_t sizes = sizeof(tabs)/sizeof(tabs[0]);
Node<string> *listAs = arrayToList(tabs, sizes);
showList(listAs);
Node<string> *listBs = extract(listAs,isLong);
showList(listAs);
showList(listBs);
deleteList(listAs);
deleteList(listBs);
return 0;
}
