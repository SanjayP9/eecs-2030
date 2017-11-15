package eecs2030.lab6;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveTests {

	// getParenthesis

	@Test
	public void test_01_getParenthesis() {

		String e = "(abc)";
		String a = RecursiveTasks.getParenthesis("xyz(abc)123");

		assertEquals("Failed: getParenthesis(\"xyz(abc)123)\")", e, a);
	}

	@Test
	public void test_02_getParenthesis() {

		String e = "(abc)";
		String a = RecursiveTasks.getParenthesis("xyz(abc)");

		assertEquals("Failed: getParenthesis(\"xyz(abc))\")", e, a);
	}


	@Test
	public void test_06_getParenthesis() {

		String e = "()";
		String a = RecursiveTasks.getParenthesis("()");

		assertEquals("Failed: getParenthesis(\"()\")", e, a);
	}

	
	// parenthIsNested()

	@Test
	public void test_08_parenthIsNested() {

		boolean e = true;
		boolean a = RecursiveTasks.parenthIsNested("(())");

		assertEquals("Failed: parenthIsNested(\"(())\")", e, a);
	}


	@Test
	public void test_11_parenthIsNested() {
		
		boolean e = false;
		boolean a = RecursiveTasks.parenthIsNested("(((x))");
	
		assertEquals("Failed: parenthIsNested(\"(((x))\")",e,a);
	}



	@Test
	public void test_13_parenthIsNested() {

		boolean e = true;
		boolean a = RecursiveTasks.parenthIsNested("()");

		assertEquals("Failed: parenthIsNested(\"()\")", e, a);
	}

	@Test
	public void test_14_parenthIsNested() {

		boolean e = true;
		boolean a = RecursiveTasks.parenthIsNested("");

		assertEquals("Failed: parenthIsNested(\"\")", e, a);
	}

	
	
	// numOccurrences

	@Test
	public void test_20_numOccurrances() {

		int e = 2;
		int a = RecursiveTasks.numOccurrences("dogmonkeydog", "dog");

		assertEquals("Failed: numOccurrences(\"dogmonkeydog\", \"dog\")", e, a);
	}
	
	@Test
	public void test_21_numOccurrances() {

		int e = 1;
		int a = RecursiveTasks.numOccurrences("dogmonkeydog", "mon");

		assertEquals("Failed: numOccurrences(\"dogmonkeydog\", \"mon\")", e, a);
	}
	
	@Test
	public void test_22_numOccurrances() {

		int e = 0;
		int a = RecursiveTasks.numOccurrences("dogmonkeydog", "cow");

		assertEquals("Failed: numOccurrences(\"dogmonkeydog\", \"cow\")", e, a);
	}
	
	
	
	
	// sumSome  and  genFractal  (come up with your own test cases here - 
	// follow those cases that demonstrate correctness and 
	
	
}
