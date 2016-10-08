/**
 * Tugas Java P3
 * Program Java untuk menghitung
 *
 * Date: 7 Oct 2016
 * Dosen: A. Sidiq Purnomo
 * MatKul: Pemograman Java
 *
 * Note: Copyleft version >:D
 * @author Verri Andriawan <verri@tiduronline.com>
 *
 * 
 */

import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * Main Math Class
 * ============================================== */

class Hitung {

	protected float lebar = 0;
	protected float panjang = 0;
	protected float sisi = 0;
	
	public float persegi_panjang() {
		return lebar * panjang;
	}

	public float persegi() {
		return sisi * sisi;
	}

}


/**
 * Main Class
 * ============================================== */

class Menghitung {
	public static void main(String[] args) {
		System.out.println("// ------------------------------------");
		System.out.println("//  Nama\t: Verri A ");
		System.out.println("//  NIM \t: 14111*** ");
		System.out.println("// ------------------------------------\n\n");

		float hasil;
		float lebar;
		float panjang;

		String nim;
		String nama;
		String mikir; 

		Boolean loop = false;
		
		Hitung hitung = new Hitung();
		
		

		while(!loop) {
			System.out.println("===== Program Menghitung Luas =====");
			System.out.println("  1. Menghitung luas persegi panjang");
			System.out.println("  2. Menghitung luas persegi");
			System.out.println("  3. Input Biodata");
			System.out.println("  4. Selesai");
			System.out.println("===================================");

			System.out.print("Pilihan ( 1-4 ) ? ");

			int pilih;
			int error;
			Scanner in = new Scanner(System.in);
			String data;

			pilih = in.nextInt();
			

			switch(pilih) {

				/**
 				 * Hitung Persegi Panjang
				 * ======================================= */
				case 1:
					System.out.println("****** Menghitung Luas Bangun Persegi Panjang ******");
					error = 1;
					
					while(error > 0) {
						System.out.print("Panjang Persegi Panjang = ");
						hitung.panjang = in.nextFloat();

						System.out.print("Lebar Persegi Panjang = ");
						hitung.lebar = in.nextFloat();

						if( hitung.panjang > 0 && hitung.lebar > 0) {

							if( hitung.lebar < hitung.panjang ) {
								hasil = hitung.persegi_panjang();
								error = 0;
								System.out.println("Luas persegi panjang = " + hasil );
							} else {
								System.out.println("Lebar harus lebih kecil dari panjang");
							}
	
						} else {
							System.out.println("Nilai lebar dan panjanga tidak boleh negative");
						}

					}
					break;


				/**
 				 * Hitung Persegi
				 * ======================================= */
				case 2:
					System.out.println("****** Menghitung Luas Bangun Persegi ******");
					error = 1;

					while(error > 0) {
						System.out.print("Panjang Persegi Panjang = ");
						hitung.sisi = in.nextFloat();

						if(hitung.sisi > 0) {
							hasil = hitung.persegi();
							error = 0;
							System.out.println("Luas Persegi adalah " + hasil);
						} else {
							System.out.println("tidak boleh kurang dari 0");
						}
					}

					break;
				case 3:
					System.out.println("****** Biodata ******");
					
					System.out.print("NIM: ");
					nim = in.next();
				
					System.out.print("Nama: ");
					nama = in.next();

					System.out.print("Apa yang anda sedang pikirkan? ");
					mikir = in.next();

					System.out.println("\n****** Biodata ******");
					System.out.println("NIM\t: "+nim);
					System.out.println("Nama\t: "+nama);
					System.out.println("Saya sedang memikirkan = " + mikir);
					
					break;
				case 4:
					loop = true;
					System.out.println("Program terminated");
					break;
				default:
					loop = true;
					System.out.println("Nilai undefined");

			}
		}
	}

}
