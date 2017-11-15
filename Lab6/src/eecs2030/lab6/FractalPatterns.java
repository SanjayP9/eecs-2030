package eecs2030.lab6;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * FractalPatterns is a helper class that allows for the fractal pattern to be drawn to a window
 * (nothing to implement here)
 * 
 * @author user
 *
 */
public class FractalPatterns {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) { // create a MyCanvas object
		MyCanvas canvas1 = new MyCanvas();

		// set up a JFrame to hold the canvas
		JFrame frame = new JFrame();
		frame.setTitle("FractalCircles.java");
		frame.setSize(600, 600);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add the canvas to the frame as a content panel
		frame.getContentPane().add(canvas1);
		frame.setVisible(true);
	}// end main
}// end class



class MyCanvas extends Canvas {
	public MyCanvas() {
	} // end MyCanvas() constructor

	// this method will draw the initial circle and invisible line
	public void paint(Graphics graphics) {
		int x1, x2, y1, y2; // future x and y coordinates
		int radius = 125; // radius of first circle
		int xMid = 300, yMid = 300; // center point (x,y) of circle

		// draw axes
		graphics.drawLine(0, 300, 600, 300);
		graphics.drawLine(300, 0, 300, 600);


		// draw first circle
		graphics.drawOval(xMid - radius, yMid - radius, radius * 2, radius * 2);
		

		// create a list to hold circle objects
		List<Circle> drawlist = new ArrayList<Circle>();
		
		
		// run fractal algorithm to draw circles at 4 positions recursively for n=5 recursive iterations
		// you can modify this call to test other values of n
		int n=5;
		boolean [] mode = {true,true,true,true};
		
		RecursiveTasks.genFractal(drawlist, xMid, yMid, radius, n, mode);
		
		
		// quick and dirty loop to drawn all the circles that have been generated for the fractal
		for (Circle c : drawlist) {
			
			graphics.drawOval( c.getX()-c.getRad(), c.getY()-c.getRad(), 2*c.getRad(), 2*c.getRad());
		}

	}

}
