/**
 * Tugas Java P5
 * Program Java untuk Membentuk YinYang
 *
 * Date: 14 Oct 2016
 * Dosen: A. Sidiq Purnomo
 * MatKul: Pemograman Java
 *
 * @author Verri Andriawan <verri@tiduronline.com>
 * ----------------------------------------------------- */

import java.awt.*;
import java.awt.event.*;


class Circle {
	protected Color color;
	protected int diameter;
	protected int postLeft;
	protected int postTop;
	protected int degree;
	protected int startAng;

	public Circle(Color color, int diameter, int postLeft, int postTop, int startAng, int degree) {
		this.color 		= color;
		this.diameter 	= diameter;
		this.postLeft 	= postLeft;
		this.postTop	= postTop;
		this.degree 	= degree;
		this.startAng 	= startAng;
	}

	public Circle() {
		this(Color.white, 300, 0, 0, 0, 360);
	}


	public void show(Graphics circle){
		circle.setColor(this.color);
		circle.fillArc(this.postLeft, this.postTop, this.diameter, this.diameter, this.startAng, this.degree);
	}
}


class YinYangCanvas extends Canvas {
	private int diameter;
	private int padding;

	public YinYangCanvas(int diameter, int padding) {
		this.diameter 	= diameter;
		this.padding  	= padding;
	}

	public YinYangCanvas() {
		this(500, 20);
	}

	private int getDiameter() {
		return this.diameter - this.padding;
	}

	private int getRadius() {
		return this.diameter/2;
	}



	@Override
	public void paint(Graphics graph) {
		int diameter 	= getDiameter();
		int radius 		= getRadius();
		int startAng 	= 90;
		
		// Main Circle
		// -----------------------------------------------
		Circle mainBuled = new Circle(Color.black, diameter, this.padding, this.padding, startAng, 360);
		mainBuled.show(graph);


		// Main Half Circle
		// -----------------------------------------------
		Circle mainHalfBuled = new Circle(Color.white, diameter, this.padding, this.padding, startAng, 180);
		mainHalfBuled.show(graph);
		

		// Medium Circle 
		// -----------------------------------------------		
			int medDiameter = diameter/2;
			int medRadius 	= medDiameter/2;

			int medPosLT 	= (radius + this.padding) - medRadius;


			// White C
			// -----------------------------------------------
			Circle medCircleW = new Circle(Color.white, medDiameter, medPosLT, this.padding, 0, 360);
			medCircleW.show(graph);


			// Black C
			// -----------------------------------------------
			Circle medCircleB = new Circle(Color.black, medDiameter, medPosLT, (medDiameter + this.padding), 0, 360);
			medCircleB.show(graph);


		// Small Circle 
		// -----------------------------------------------
		int smallDiameter 	= medDiameter/4;
		int smallRadius 	= (smallDiameter/2);

		int smallPostLeft 	= (radius + this.padding) - smallRadius;
		int smallPostTop 	= (medRadius + this.padding) - smallRadius;


			// Black SC
			// -----------------------------------------------
			Circle smallCircleW = new Circle(Color.black, smallDiameter, smallPostLeft, smallPostTop, 0, 360);
			smallCircleW.show(graph);


			// White SC
			// -----------------------------------------------
			Circle smallCircleB = new Circle(Color.white, smallDiameter, smallPostLeft, smallPostTop + medDiameter, 0, 360);
			smallCircleB.show(graph);
	}
}



public class YinYang {
	public static void main(String[] args) {
		final int width 	= 500;
		final int height 	= 500;
		final int padding 	= 20;

		YinYangCanvas yinyang = new YinYangCanvas(width, padding);
		
		Frame f = new Frame("Draw a YinYang");
		f.setSize(width + padding, height + (padding * 2));
		f.add(yinyang);

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.setVisible(true);
	}
}
