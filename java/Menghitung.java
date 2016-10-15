/**
 * Tugas Java P3
 * Program Java untuk menghitung
 *
 * Date: 7 Oct 2016
 * Dosen: A. Sidiq Purnomo
 * MatKul: Pemograman Java
 *
 * @author Verri Andriawan <verri@tiduronline.com>
 */

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Static Banner
 * ============================================== */

class Banner {

	private static String[] biodata = {
		"// ------------------------------------",
		"//  Nama\t: Verri Andriawan ",
		"//  NIM \t: 14111036 ",
		"// ------------------------------------"
	};


	private static String[] titleProgram = {
		"===== Program Menghitung Luas =====",
		"  1. Menghitung luas persegi panjang",
		"  2. Menghitung luas persegi",
		"  3. Input Biodata",
		"  4. Selesai",
		"===================================",
	};

	private static String arrayJoin(String[] text) {
		String sBanner = "\n";
		
		for(String txt: text) {
			sBanner += txt;
			sBanner += "\n";
		};
		return sBanner += "\n";
	}

	public static void print(String type) {

		switch(type) {
			case "biodata":
				String sBannerIdentity = arrayJoin(Banner.biodata);	
				System.out.print(sBannerIdentity);
				break;
			case "title":
				String sBannerChoice = arrayJoin(Banner.titleProgram);
				System.out.print(sBannerChoice);
		}
	}

}


/**
 * Main Math Class
 * ============================================== */

class HitungObject {

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
 * Validation Class
 * ============================================== */

class Validation {
    HitungObject obj;

	public Validation(HitungObject obj) {
		this.obj = obj;
	}

	public Boolean is_equal() {
		if(obj.lebar == obj.panjang) {
			return true;
		}
		return false;
	}
	
	public Boolean precision(){
		if(obj.lebar < obj.panjang)
			return true;
		return false;
	}


	public Boolean positive() {
		if ( obj.lebar < 0 || 
			 obj.panjang < 0 ||
			 obj.sisi < 0
			) 
		{ return false; }

		return true;
	}
}



/**
 * Main Class
 * ============================================== */

class Menghitung {
	public static void main(String[] args) {
		Banner.print("biodata");
		
		float hasil = 0, lebar = 0, panjang = 0;
		String nim, nama, mikir; 
		Boolean loop = false;
		

		HitungObject hitung_object = new HitungObject();
		Validation validation = new Validation(hitung_object);
		

		while(!loop) {
			Banner.print("title");
			pr("Pilihan ( 1-4 ) ? ");

			int choiced;
			Boolean error = true;
			Scanner inputReader = new Scanner(System.in);
			String data;

			choiced = (int)get_value_or_loop(inputReader, "Hanya ada pilihan 1 - 4. Silahkan masukan pilihan anda ");
			

			switch(choiced) {

				/**
 				 * Hitung Persegi Panjang
				 * ======================================= */
				case 1:
					prln("****** Menghitung Luas Bangun Persegi Panjang ******");
					
					while(error) {
						pr("Panjang Persegi Panjang = ");
						hitung_object.panjang = get_value_or_loop(inputReader, "Hanya diperbolehkan masukan angka positive. ");

						pr("Lebar Persegi Panjang = ");
						hitung_object.lebar = get_value_or_loop(inputReader, "Hanya diperbolehkan masukan angka positive. ");

						if (validation.positive()) {
							if (validation.precision() && !validation.is_equal()) {

								hasil 	= hitung_object.persegi_panjang();
								error 	= false;

								prln("\n[+] Luas Persegi Panjang adalah " + hasil + "\n");

							} else {
								prln("\n[E] Ukuran panjang harus lebih besar dari lebar \n");
							}
						} else {
							prln("\n[E] Ukuran tidak boleh kurang dari 0 \n");
						}
					}
					break;


				/**
 				 * Hitung Persegi
				 * ======================================= */
				case 2:
					prln("****** Menghitung Luas Bangun Persegi ******");

					while(error) {
						pr("Panjang Persegi Panjang = ");
						hitung_object.sisi = get_value_or_loop(inputReader, "Hanya diperbolehkan masukan angka positive. ");
						
						if(validation.positive()) {
							
							hasil 	= hitung_object.persegi();
							error 	= false;

							prln("\n[+] Luas Persegi adalah " + hasil + "\n");
						} else {
							prln("\n[E] Ukuran tidak boleh kurang dari 0 \n");
						}
					}

					break;
				case 3:
					prln("****** Biodata ******");
					
					pr("NIM: ");
					nim = inputReader.next();
				
					pr("Nama: ");
					nama = inputReader.next();

					pr("Apa yang anda sedang pikirkan? ");
					mikir = inputReader.next();

					prln("\n****** Biodata ******");
					prln("NIM\t: "+nim);
					prln("Nama\t: "+nama);
					prln("Saya sedang memikirkan = " + mikir);
					
					break;
				case 4:
					loop = true;
					prln("Program terminated");
					break;
				default:
					loop = true;
					prln("Nilai undefined");

			}
		}
	}

	private static float get_value_or_loop(Scanner inputReader, String message) {
		Boolean input_error = true;
		float value = 0;
		
		while(input_error) {
			if(inputReader.hasNextLine()){
				try {
					value = inputReader.nextFloat();	
					input_error = false;
				} catch(InputMismatchException e) {
					prln(message);
					pr("=> ");
					inputReader.next();
				}
			} 
		}
		return value;
	}

	private static void pr(String message) {
		System.out.print(message);
	}

	private static void prln(String message) {
		System.out.println(message);
	}
}