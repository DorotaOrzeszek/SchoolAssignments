#include <iostream>
using namespace std;

template<typename T>
class Queue {
	struct Node {
		T element;
		Node* next;
	};
	Node* head;
	Node* tail;
public:
	Queue();
	bool empty() const;
	void put(const T& data);
	T get();
	~Queue();
};

template<typename T>
Queue<T>::Queue() {
	head = NULL;
	tail = NULL;
}

template<typename T>
bool Queue<T>::empty() const {
	if (head == NULL && tail == NULL) {
		return true;
	} else {
		return false;
	}
}

template<typename T>
void Queue<T>::put(const T& data) {
	if (!this->empty()) {
		tail->next = new Node();
		tail->next->next = NULL;
		tail->next->element = data;
		tail = tail->next;
	} else {
		head = new Node();
		tail = head;
		head->element = data;
		head->next = NULL;
	}
}

template<typename T>
T Queue<T>::get() {
	T old_head_value = head->element;
	Node* old_head = head;
	head = head->next;
	delete old_head;
	if (head == NULL) {
		tail = NULL;
	}
	return old_head_value;
}

template<typename T>
Queue<T>::~Queue() {
	while (!this->empty()) {
		cout << "Del " << this->get() << " ";
	}
	cout << endl;
}

int main() {
	int data1,data2;
	
	Queue<int>* q = new Queue<int>();
	q->put(1);
	data1 = q->get();
	std::cout << " data1=" << data1 << std::endl;
	q->put(1);
	q->put(2);
	data1 = q->get();
	data2 = q->get();
	std::cout << " data1=" << data1
		<< " data2=" << data2 << std::endl;

	q->put(1); q->put(2); q->put(3);
	q->put(4); q->put(5); q->put(6);
	while (!q->empty()) std::cout << " " << q->get();
	std::cout << std::endl;

	q->put(1); q->put(2); q->put(3);
	delete q;
}

