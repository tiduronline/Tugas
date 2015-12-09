#include <iostream>
#include <math.h>
using namespace std;


class SegitigaSiku {

	private:
		float tinggi;
		float alas; 
		float hasil;

	public:
		SegitigaSiku( float tinggi, float alas) {
			SegitigaSiku::tinggi = tinggi;
			SegitigaSiku::alas = alas;
		}

		void dapatSisiMiring() {
			SegitigaSiku::hasil = sqrt(pow(SegitigaSiku::tinggi, 2) + pow(SegitigaSiku::alas,2));
		}

		void printResult( void ) {
			SegitigaSiku::dapatSisiMiring();
			
			cout << endl << "Panjang sisi miring segitiga jika diketahui " << endl;
			cout << "- Panjang alas = " << alas << " cm" << endl;
			cout << "- Panjang tinggi = " << tinggi << " cm" << endl;
			cout << " hasilnya adalah " << hasil << " cm" << endl << endl; 

		}
		
};

int main( void ) {

	SegitigaSiku segitiga(10,10);
	segitiga.printResult();

	return 0;
}