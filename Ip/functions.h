#ifndef FUNCTION_H_INCLUDED
#define FUNCTION_H_INCLUDED
#define MAX_LENGTH 10

#include <stdio.h>	
#include <string.h>


// structs
typedef struct matkul {
	int no;
	char kode_mk[10];
	char nama_mk[50];
	int sks;
	char nilai[3];
	int bobot;
	int nilai_semester;
} MATKUL;


// functions
void cetak_title();
void cetak_profile();
void cetak_header();
void preview(MATKUL *datas, int total_sks, int total_nilai, float ip_semester);
void po_tabs(int length);

int bobot( MATKUL mata_kuliah );
int nilai_semester( MATKUL mata_kuliah);



#endif // FUNCTION_H_INCLUDED