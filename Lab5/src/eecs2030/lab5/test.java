package eecs2030.lab5;

public class test {

	public static LinkedIntList t = new LinkedIntList();
	
	public static void main (String args[])
	{
		t.add(0);
		t.add(1);
		t.add(2);
		t.add(3);
		t.add(4);
		t.add(5);
		
		t.shiftRight(2);
		
		System.out.println("\n\nFinal:\n"+t.toString());
	}
}
