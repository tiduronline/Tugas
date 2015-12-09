#include <iostream>
using namespace std;

double rerata = 0.0;
int lists[] = { 11,12,13,14,15 };
int nilaiMin = lists[0];


/**
 * Get min value in array
 * @param number Array
 * @param i Integer
 * @return void
======================================== */

void getMin(int number[], int i=0 ){
	
	i++;
	if( i < 5 ) {
		if(number[i] > 0){
			if(nilaiMin > number[i]) {
				nilaiMin = number[i];
			}
			getMin(number, i);
		}
	}
}

/**
 * Sum an Array
 * @param number Array
 * @param i Integer
 * @return void
======================================== */

void getSum(int number[], int i=0 ){
	if( i < 5 ) {
		rerata += number[i];
		i++;	
		getSum(number, i);
	}
}


int main(void) {
	getMin(lists, 0);
	getSum(lists, 0);

	rerata = rerata/5;

	cout << endl;
	cout << "Nilai minmal dari array = " << nilaiMin << endl;
	cout << "Nilai Rerata dari array = " << rerata << endl;
	cout << endl;

	return 0;
}