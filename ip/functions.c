#include "functions.h"

/** 
 *	Print Title table
 */

void cetak_title() {
	printf("\n\t\t\t\tKartu Hasil Studi ( Versi Beta ) \n");
	printf("\t\t\t\t   Target yang ingin dicapai \n\n\n");
}


/**
 * Print Affiliasi
 */
void cetak_profile() {

	printf("  NIM\t\t: 14111036 \n");
	printf("  Nama\t\t: Verri Andriawan \n");
	printf("  Prodi\t\t: Teknik Informatika \n");
	printf("  Semester\t: 1 \n\n");
	
}

/** 
 *	Build Headers
 */
void cetak_header() {
	cetak_title();
	cetak_profile();
}


/**
 *	Make tabs
 */
void po_tabs(int length) {
	
	if(length > 28 ) {
		printf("\t\t|");

	} else if(length > 21) {

		printf("\t\t\t|");
	} else if(length > 18) {

		printf("\t\t\t\t|");
	} else if(length > 15) {

		printf("\t\t\t\t|");
	} else {

		printf("\t\t\t\t\t|");
	}
}



/**
 *	Print Out The Tables
 */
void preview( MATKUL *datas, int total_sks, int total_nilai, float ip_semester ) {
	int i;
	printf("  ---------------------------------------------------------------------------------------------------------\n");
	printf("  No.\t|  Kode MK\t|  Nama MK\t\t\t\t\t|  SKS  |  Nilai  |  Bobot  |  NS  \n");
	printf("  ---------------------------------------------------------------------------------------------------------\n");

	for(i=0; i<MAX_LENGTH; i++) {
		printf("   %d\t|", datas[i].no);
		printf("  %s\t|", datas[i].kode_mk);
		printf("  %s", datas[i].nama_mk);

		po_tabs(strlen(datas[i].nama_mk));

		printf("   %d   |", datas[i].sks);
		printf("    %s    |", datas[i].nilai);
		printf("    %d    |", datas[i].bobot);
		printf("  %d   ", datas[i].nilai_semester);
		printf("\n");

	}

	printf("  ---------------------------------------------------------------------------------------------------------\n\n");


	printf("  Jumlah SKS : %d  \n", total_sks);
	printf("  Jumlah NILAI SEMESTER : %d  \n", total_nilai);
	printf("\n  IP Semester : %.1f  \n\n", ip_semester);

}



/** 
 * Get Bobot Value ( I have no idea 'bobot' in English :P )
 */

int bobot( MATKUL mata_kuliah ) {
	int ret;

	switch( *mata_kuliah.nilai ) {
		case 'A': ret = 4;
			break;
		case 'B': ret = 3;
			break;
		case 'C': ret = 2;
			break;
		case 'D': ret = 1;
			break;
		default: ret = 0;
	}
	return ret;
}


/**
 * Get Nilai Semester
 */
int nilai_semester( MATKUL mata_kuliah ) {
	return ( mata_kuliah.sks * mata_kuliah.bobot);
}




