#include <stdlib.h>
#include <iostream>
#include <cmath>
using namespace std;

double* aver(double* arr, size_t size, double& average) {
	double suma = 0;
	for (int i = 0; i < (int) size; i++) {
		suma += arr[i];
	}
	average = suma / size;
	double mindiff = abs(arr[0] - average);
	double* p = &arr[0];
	for (int i = 1; i < (int) size; i++) {
		double checkdiff = abs(arr[i] - average);
		if (checkdiff < mindiff) {
			mindiff = checkdiff;
			p = &arr[i];
		}
	}
	return p;
}

int main() {
	double arr[] = {1,2,3,4,5,7};
	size_t size = sizeof(arr)/sizeof(arr[0]);
	double average = 0;
	double* p = aver(arr,size,average);
	cout << *p << " " << average << endl;
} // 4 3.66667
