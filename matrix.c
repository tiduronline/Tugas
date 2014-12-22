#include <stdio.h>



int main( void ) {

	printf("======================================================================\n\n");
	printf(" ..:: Perkalian dan Penjumlahan Matrix ordo 2x2 ::.. \n\n");
	printf("Nama : Verri Andriawan \n");
	printf("NIM : 14111036 \n");
	printf("Prodi : Teknik Informatika \n");
	printf("Kelas : 22 \n\n");
	printf("======================================================================\n\n");

	int ordo=2;
	int i,j,k,opt, tmp_rest=0;

	int matrix1[ordo][ordo];
	int matrix2[ordo][ordo];
	int hasil[ordo][ordo];


	getvalue:
		printf("\nMatrix 1 : \n");
		for(i=0;i<ordo;i++) {
			for(j=0;j<ordo;j++) {
			 	printf("Element [%d][%d] = ",i,j);
			 	scanf("%d", &matrix1[i][j]);
			}
		}

		printf("\nMatrix 2 : \n");
		for(i=0;i<ordo;i++) {
			for(j=0;j<ordo;j++) {
			 	printf("Element [%d][%d] = ",i,j);
			 	scanf("%d", &matrix2[i][j]);
			}
		}		

		printf("\nMatrix : \n\n");
		printf("| %d   %d |\t| %d   %d |\n", matrix1[0][0], matrix1[0][1], matrix2[0][0], matrix2[0][1]);
		printf("| %d   %d |\t| %d   %d |\n", matrix1[1][0], matrix1[1][1], matrix2[1][0], matrix2[1][1]);
		printf("\n");

		goto options;




	keluar:
		printf("Program terminated..!1");
		return 0;


	
	perkalian:
		for(k=0;k<ordo;k++) {
			for(i=0;i<ordo;i++) {

				hasil[k][i] = 0;
				for(j=0;j<ordo;j++) {
					hasil[k][i] = hasil[k][i] + ( matrix1[i][j] * matrix2[j][k] );
				}
			}
		}

		printf("\nResult : \n\n");
		printf("| %d   %d |\n", hasil[0][0], hasil[1][0]);
		printf("| %d   %d |\n", hasil[0][1], hasil[1][1]);
		printf("\n");

		goto options;



	penjumlahan:
		for(i=0;i<ordo;i++) {
			for(j=0;j<ordo;j++) {
				hasil[j][i] =  matrix1[i][j] + matrix2[i][j];
			}
		}
		

		printf("\nResult : \n\n");
		printf("| %d   %d |\n", hasil[0][0], hasil[1][0]);
		printf("| %d   %d |\n", hasil[0][1], hasil[1][1]);
		printf("\n");

		goto options;




	options:
		printf("========================== Program Continue ==========================\n\n");
		printf("1. Matrix perkalian \n");
		printf("2. Matrix penjumlahan \n");
		printf("0. Selesai \n");
		printf("======================================================================\n\n");

		printf("Pilihan 0, 1 atau 2? ");
		scanf("%d", &opt);

		switch(opt) {
			case 0:
				goto keluar;
				break;

			case 1:
				goto perkalian;
				break;
			case 2:
				goto penjumlahan;
				break;

			default:
				goto options;
		}

	return 0;

}