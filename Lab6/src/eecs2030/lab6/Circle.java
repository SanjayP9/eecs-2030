package eecs2030.lab6;


/**
 * This class is incomplete - implemented sufficiently only to enable Circle
 * objects to be added and queried from a list.
 * 
 * 
 * For other types of comparisons (equality, compareTo etc, a more complete version is necessary)
 * 
 * @author 
 *
 */
public class Circle {

	private int x;
	private int y;
	
	private int radius;
	
	public Circle() {

		this(0,0,1);
		
	}
	
	public Circle(int x, int y, int radius) {
		
		this.x = x;
		this.y = y;
		
		this.radius = radius;
	
		
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public int getRad() {
		return this.radius;
	}


	
	

}
