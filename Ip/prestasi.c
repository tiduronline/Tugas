#include <stdio.h>
#include "functions.h"


/**
 *	List Of Table Content
 */
MATKUL datas[ MAX_LENGTH ] = {

	{ 1, "FTI20", 	"Etika Profesi dan Budi Pekrti", 	2, "B", 0, 0 },
	{ 2, "TIF30", 	"Pengantar Teknik Informatika", 	2, "A", 0, 0 },
	{ 3, "UMB09", 	"Bahasa Inggris I", 				2, "B", 0, 0 },
	{ 4, "TIF31", 	"Matematika Diskret I", 			2, "B", 0, 0 },
	{ 5, "TIF32", 	"Algoritma dan Pemrograman", 		3, "A", 0, 0 },
	{ 6, "UMB10", 	"Aplikasi Komputer I", 				1, "B", 0, 0 },
	{ 7, "UMB10P", 	"Prak. Aplikasi Komputer I", 		1, "B", 0, 0 },
	{ 8, "UMB09P", 	"Prak. Bahasa Inggris I", 			1, "A", 0, 0 },
	{ 9, "TIF33", 	"Fisika optis dan Gelombang",		1, "C", 0, 0 },
	{ 10, "TIF34", 	"Kalkulus", 						2, "A", 0, 0 },

};



int main( void ) {

	int total_sks=0, total_ns=0, i;
	float ip_semester;
	

	for( i=0; i<MAX_LENGTH; i++ ) {
		datas[i].bobot = bobot( datas[i] );
		datas[i].nilai_semester = nilai_semester( datas[i] );

		total_sks += datas[i].sks;
		total_ns += datas[i].nilai_semester;
	}

	ip_semester = total_ns / total_sks;

	cetak_header();
	preview( datas, total_sks, total_ns, ip_semester );
	

	return 0;
}