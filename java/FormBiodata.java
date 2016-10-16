/**
 * Tugas Java P5
 * Program Java untuk Form Biodata
 *
 * Date: 14 Oct 2016
 * Dosen: A. Sidiq Purnomo
 * MatKul: Pemograman Java
 *
 * @author Verri Andriawan <verri@tiduronline.com>
 * ----------------------------------------------------- */

import java.awt.*;
import javax.swing.*;

class Form extends JFrame {
	// Layout
	// -----------------------------------------------------
	Font arialFont 	= new Font("Arial", Font.PLAIN, 12);
	int padding 	= 10;	
	int height 		= 20;
	int widthLabel 	= 100;
	int widthVal 	= 300;
	int colLeft 	= 0;
	int colRight 	= 0;
	int labelLeft 	= 10;
	int posFromTop 	= 0;
	int rowSize 	= 0;


 	// Fields
 	// -----------------------------------------------------
	JLabel labelNim 				= new JLabel("NIM");
	JLabel labelNimVal 				= new JLabel(": 14111036");
	JLabel labelName 				= new JLabel("Nama");
	JLabel labelNameVal 			= new JLabel(": Verri Andriawan");
	JLabel titleSection 			= new JLabel("E-Learning (Identity)");
	JLabel labelSIN 				= new JLabel("SIN");
	JTextField textSINField 		= new JTextField(35);
	JLabel labelNameEl 				= new JLabel("Name");
	JTextField textNameElField 		= new JTextField(100);
	JLabel labelAddress 			= new JLabel("Address");
	JTextField textAddressField 	= new JTextField(100);
	JLabel labelGender 				= new JLabel("Gender");
	JRadioButton radioGender1 		= new JRadioButton("Male");
	JRadioButton radioGender2 		= new JRadioButton("Female");
	ButtonGroup genderGroup 		= new ButtonGroup();

	JLabel labelReligion 			= new JLabel("Religion");
	String[] religions 				= { "Islam", "Protestant", "Katolik", "Hindu", "Budha", "Other"};
	JComboBox<String> comboReligion = new JComboBox<>(religions);

	JLabel labelEmail 				= new JLabel("Email");
	JTextField textEmail 			= new JTextField(100);
	JLabel labelFacebook 			= new JLabel("Facebook");
	JTextField textFacebook 		= new JTextField(100);
	JLabel labelPhone 				= new JLabel("Phone");
	JTextField textPhone 			= new JTextField(100);

	JButton buttonSave 				= new JButton("Save");
	JButton buttonUpdate 			= new JButton("Update");
	JButton buttonExit 				= new JButton("Exit");


	public Form() {
		windowLayout();	
	}

	public void windowLayout() {
		setLocation(100, 100);
		setSize(500, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		colLeft 	= padding;
		colRight 	= widthLabel + padding;
		posFromTop 	+= padding;
		rowSize 	= height + padding;


		// NIM Field
		// -------------------------------
		labelNim.setFont(arialFont);
		getContentPane().add(labelNim).setBounds(colLeft, posFromTop, widthLabel, height);

		labelNimVal.setFont(arialFont);
		getContentPane().add(labelNimVal).setBounds(colRight, posFromTop, widthVal, height);


		// Name Field 
		// -------------------------------
		posFromTop += rowSize;

		labelName.setFont(arialFont);
		getContentPane().add(labelName).setBounds(colLeft, posFromTop, widthLabel, height);

		labelName.setFont(arialFont);
		getContentPane().add(labelNameVal).setBounds(colRight, posFromTop, widthVal, height);


		// Section Title
		// -------------------------------
		posFromTop += rowSize;

		titleSection.setFont(arialFont);
		getContentPane().add(titleSection).setBounds(colLeft + 180, posFromTop, widthVal, height);

		// Name Field 
		// -------------------------------
		posFromTop += rowSize;

		labelSIN.setFont(arialFont);
		getContentPane().add(labelSIN).setBounds(colLeft, posFromTop, widthLabel, height);

		textSINField.setFont(arialFont);
		getContentPane().add(textSINField).setBounds(colRight, posFromTop, widthVal, height);


		// Name EL Field 
		// -------------------------------
		posFromTop += rowSize;

		labelNameEl.setFont(arialFont);
		getContentPane().add(labelNameEl).setBounds(colLeft, posFromTop, widthLabel, height);

		textNameElField.setFont(arialFont);
		getContentPane().add(textNameElField).setBounds(colRight, posFromTop, widthVal, height);


		// Address Field 
		// -------------------------------
		posFromTop += rowSize;

		labelAddress.setFont(arialFont);
		getContentPane().add(labelAddress).setBounds(colLeft, posFromTop, widthLabel, height);

		textAddressField.setFont(arialFont);
		getContentPane().add(textAddressField).setBounds(colRight, posFromTop, widthVal, height);


		// Gender Field 
		// -------------------------------
		posFromTop += rowSize;

		labelGender.setFont(arialFont);
		getContentPane().add(labelGender).setBounds(colLeft, posFromTop, widthLabel, height);

		genderGroup.add(radioGender1);
		genderGroup.add(radioGender2);
		getContentPane().add(radioGender1).setBounds(colRight, posFromTop, widthLabel, height);
		getContentPane().add(radioGender2).setBounds(colRight + widthLabel, posFromTop, widthLabel, height);
		

		// Religion Field 
		// -------------------------------
		posFromTop += rowSize;

		labelReligion.setFont(arialFont);
		getContentPane().add(labelReligion).setBounds(colLeft, posFromTop, widthLabel, height);

		comboReligion.setFont(arialFont);
		getContentPane().add(comboReligion).setBounds(colRight, posFromTop, widthVal, height);


		// Email Field 
		// -------------------------------
		posFromTop += rowSize;

		labelEmail.setFont(arialFont);
		getContentPane().add(labelEmail).setBounds(colLeft, posFromTop, widthLabel, height);

		textEmail.setFont(arialFont);
		getContentPane().add(textEmail).setBounds(colRight, posFromTop, widthVal, height);


		// Facebook Field 
		// -------------------------------
		posFromTop += rowSize;

		labelFacebook.setFont(arialFont);
		getContentPane().add(labelFacebook).setBounds(colLeft, posFromTop, widthLabel, height);

		textFacebook.setFont(arialFont);
		getContentPane().add(textFacebook).setBounds(colRight, posFromTop, widthVal, height);


		// Phone Field 
		// -------------------------------
		posFromTop += rowSize;

		labelPhone.setFont(arialFont);
		getContentPane().add(labelPhone).setBounds(colLeft, posFromTop, widthLabel, height);

		textPhone.setFont(arialFont);
		getContentPane().add(textPhone).setBounds(colRight, posFromTop, widthVal, height);


		// Button Field 
		// -------------------------------

		posFromTop += rowSize;
		int widthBtn = 80;

		getContentPane().add(buttonSave).setBounds(colRight, posFromTop, widthBtn, height);
		colRight += widthBtn + 10;
		getContentPane().add(buttonUpdate).setBounds(colRight, posFromTop, widthBtn, height);

		colRight += widthBtn + 10;
		getContentPane().add(buttonExit).setBounds(colRight, posFromTop, widthBtn, height);

	}

	public void windowShow() {
		setVisible(true);
	}
	
}

class FormBiodata {
	public static void main(String[] args) {
		Form form = new Form();
		form.windowShow();
	}
}