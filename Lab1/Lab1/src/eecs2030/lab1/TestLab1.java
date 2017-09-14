package eecs2030.lab1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLab1 {

	private static Random rng = new Random();

	@Test
	public void test01_maxInt() {
		assertEquals("maxInt returned the wrong value",
				Integer.MAX_VALUE, Lab1.maxInt());
	}

	@Test
	public void test02_minDouble() {
		assertTrue("minDouble returned the wrong value", 
				Double.MIN_VALUE == Lab1.minDouble());
	}

	@Test
	public void test03_removeLastTwoDigits() {
		final int[] EXPECTED = { 1, 5, 9, 27, 345, 7821 };
		for (Integer exp : EXPECTED) {
			for (int i = 0; i < 100; i++) {
				int n = i + 100 * exp;
				String error = String.format("removeLastTwoDigits(%d) failed", n);
				assertEquals(error, exp.intValue(), Lab1.removeLastTwoDigits(n));
			}
		}
		assertEquals("removeLastTwoDigits(2147483647) failed", 21474836, Lab1.removeLastTwoDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test04_lastTwoDigits() {
		final int[] FIRST_DIGITS = { 1, 5, 9, 27, 345, 7821 };
		for (Integer d : FIRST_DIGITS) {
			for (int exp = 0; exp < 100; exp++) {
				int n = 100 * d + exp;
				String error = String.format("lastTwoDigits(%d) failed", n);
				assertEquals(error, exp, Lab1.lastTwoDigits(n));
			}
		}
		assertEquals("lastTwoDigits(2147483647) failed", 47, Lab1.lastTwoDigits(Integer.MAX_VALUE));
	}

	@Test
	public void test05_yourAge() {
		rng.setSeed(5);
		final int THIS_YEAR = 2017;
		for (int birthYear = THIS_YEAR - 1; birthYear > THIS_YEAR - 100; birthYear--) {
			int address = rng.nextInt(10000);
			int expBirthdayThisYearFalse = THIS_YEAR - birthYear - 1;
			String error = String.format("yourAge(%d, %d, %d) failed", address, birthYear, 0);
			assertEquals(error, expBirthdayThisYearFalse, Lab1.yourAge(address, birthYear, 0));

			int expBirthdayThisYearTrue = expBirthdayThisYearFalse + 1;
			error = String.format("yourAge(%d, %d, %d) failed", address, birthYear, 1);
			assertEquals(error, expBirthdayThisYearTrue, Lab1.yourAge(address, birthYear, 1));
		}
	}

	@Test
	public void test06_avg() {
		rng.setSeed(6);
		for (int i = 0; i < 100; i++) {
			int a = rng.nextInt(2000) - 1000;
			int b = rng.nextInt(2000) - 1000;
			double exp = 0.5 * a + 0.5 * b;
			String error = String.format("avg(%d, %d) failed", a, b);
			assertEquals(error, exp, Lab1.avg(a, b), 10 * Math.ulp(exp));
		}
		// check for overflow
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		double exp = Integer.MAX_VALUE;
		String error = String.format("avg(%d, %d) failed", a, b);
		assertEquals(error, exp, Lab1.avg(a, b), Math.ulp(exp));
	}

	@Test
	public void test07_windChill() {
		final double[] AIR_TEMP = { 0.0, -5.0, -9.0, -12.0, -20.0 };
		final double[] WIND_VEL = { 5.0, 20.0, 25.0, 30.0, 40.0 };
		final double[] WIND_CHILL = { -1.589424, -11.551404, -17.475652, -22.130007, -34.134662 };
		for (int i = 0; i < AIR_TEMP.length; i++) {
			double airT = AIR_TEMP[i];
			double windV = WIND_VEL[i];
			double exp = WIND_CHILL[i];
			String error = String.format("windChill(%f, %f) failed", airT, windV);
			assertEquals(error, exp, Lab1.windChill(airT, windV), 1e-6);
		}
	}

	@Test
	public void test08_isOdd() {
		rng.setSeed(8);
		for (int i = 0; i < 100; i++) {
			int even = 2 * rng.nextInt(Integer.MAX_VALUE / 2);
			int odd = even + 1;
			String error = String.format("isOdd(%d) failed (returned true)", even);
			assertFalse(error, Lab1.isOdd(even));

			error = String.format("isOdd(%d) failed (returned false)", odd);
			assertTrue(error, Lab1.isOdd(odd));
		}
	}

	@Test
	public void test09_isOnUnitCircle() {
		rng.setSeed(9);
		// random points inside the unit circle
		for (int i = 0; i < 100; i++) {
			double radius = rng.nextDouble(); // less than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab1.isOnUnitCircle(x, y));
		}
		// random points outside the unit circle
		for (int i = 0; i < 100; i++) {
			double radius = 1.0 + rng.nextDouble() + Math.ulp(1.0); // greater
																	// than 1
			double radians = 2.0 * Math.PI * i / 100;
			double x = radius * Math.cos(radians);
			double y = radius * Math.sin(radians);
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned true)", x, y);
			assertFalse(error, Lab1.isOnUnitCircle(x, y));
		}
		// some points exactly on the unit circle
		final double[] X = { 1.0, 0.0, -1.0, 0.0 };
		final double[] Y = { 0.0, 1.0, 0.0, -1.0 };
		for (int i = 0; i < X.length; i++) {
			double x = X[i];
			double y = Y[i];
			String error = String.format("isOnUnitCircle(%f, %f) failed (returned false)", x, y);
			assertTrue(error, Lab1.isOnUnitCircle(x, y));
		}
	}

	@Test
	public void test10_isInsideUnitSquare() {
		double X[] = { 0.0, 0.3, 0.5, 0.7, 1.0 };
		double Y[] = { 0.0, 0.2, 0.5, 0.8, 1.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isInsideUnitSquare(%f, %f) failed (returned false)", x, y);
				assertTrue(error, Lab1.isInsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test11_isNotInsideUnitSquare() {
		double X[] = { -100.0, -0.01, 1.01, 100.0 };
		double Y[] = { -6.0, -0.001, 1.001, 7.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isInsideUnitSquare(%f, %f) failed (returned true)", x, y);
				assertFalse(error, Lab1.isInsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test12_isOutsideUnitSquare() {
		double X[] = { -100.0, -0.01, 1.01, 100.0 };
		double Y[] = { -6.0, -0.001, 1.001, 7.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isOutsideUnitSquare(%f, %f) failed (returned false)", x, y);
				assertTrue(error, Lab1.isOutsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test13_isNotOutsideUnitSquare() {
		double X[] = { 0.0, 0.3, 0.5, 0.7, 1.0 };
		double Y[] = { 0.0, 0.2, 0.5, 0.8, 1.0 };
		for (double x : X) {
			for (double y : Y) {
				String error = String.format("isOutsideUnitSquare(%f, %f) failed (returned true)", x, y);
				assertFalse(error, Lab1.isOutsideUnitSquare(x, y));
			}
		}
	}

	@Test
	public void test14_yourAgeChecked() {
		assertEquals("MIN_ADDRESS has the wrong value",
				1, Lab1.MIN_ADDRESS);
		assertEquals("MAX_ADDRESS has the wrong value",
				20000000, Lab1.MAX_ADDRESS);
		assertEquals("MIN_BIRTH_YEAR has the wrong value",
				1917, Lab1.MIN_BIRTH_YEAR);
		assertEquals("MAX_BIRTH_YEAR has the wrong value",
				2016, Lab1.MAX_BIRTH_YEAR);
		try {
			Lab1.yourAgeChecked(Lab1.MIN_ADDRESS - 1, Lab1.MIN_BIRTH_YEAR + 1, 0);
			fail("yourAgeChecked failed to throw an exception for an invalid address");
		}
		catch(IllegalAddressException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid address");
		}
	}
	
	@Test
	public void test15_yourAgeChecked() {
		try {
			Lab1.yourAgeChecked(Lab1.MAX_ADDRESS + 1, Lab1.MIN_BIRTH_YEAR + 1, 0);
			fail("yourAgeChecked failed to throw an exception for an invalid address");
		}
		catch(IllegalAddressException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid address");
		}
	}
	
	@Test
	public void test16_yourAgeChecked() {
		try {
			Lab1.yourAgeChecked(Lab1.MIN_ADDRESS + 1, Lab1.MIN_BIRTH_YEAR - 1, 0);
			fail("yourAgeChecked failed to throw an exception for an invalid birth year");
		}
		catch(IllegalBirthYearException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid birth year");
		}
	}

	@Test
	public void test17_yourAgeChecked() {
		try {
			Lab1.yourAgeChecked(Lab1.MIN_ADDRESS + 1, Lab1.MAX_BIRTH_YEAR + 1, 0);
			fail("yourAgeChecked failed to throw an exception for an invalid birth year");
		}
		catch(IllegalBirthYearException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid birth year");
		}
	}
	
	@Test
	public void test18_yourAgeChecked() {
		try {
			Lab1.yourAgeChecked(Lab1.MIN_ADDRESS + 1, Lab1.MIN_BIRTH_YEAR + 1, -1);
			fail("yourAgeChecked failed to throw an exception for an invalid number of birthdays");
		}
		catch(IllegalBirthdaysException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid number of birthdays");
		}
	}
	
	@Test
	public void test19_yourAgeChecked() {
		try {
			Lab1.yourAgeChecked(Lab1.MIN_ADDRESS + 1, Lab1.MIN_BIRTH_YEAR + 1, 2);
			fail("yourAgeChecked failed to throw an exception for an invalid number of birthdays");
		}
		catch(IllegalBirthdaysException x) {
			// ok
		}
		catch(Exception x) {
			fail("yourAgeChecked threw the wrong type of exception for an invalid number of birthdays");
		}
	}
	

	@Test
	public void test20_contains() {
		rng.setSeed(13);
		for (int i = 0; i < 100; i++) {
			int min = rng.nextInt(100) - 50;
			int max = min + i;
			this.testOutsideRange(min, max);
			this.testInsideRange(min, max);
		}
	}

	private void testOutsideRange(int min, int max) {
		final double[] X = { Double.NEGATIVE_INFINITY, min - 100.0, min - 1.0, Math.nextAfter(min, min - 1.0), min, max,
				Math.nextAfter(max, max + 1.0), max + 1.0, max + 100.0, Double.POSITIVE_INFINITY };
		Range r = new Range(min, max);
		for (double x : X) {
			String error = String.format("contains(%f, r) failed\n" + "where r = %s\n", x, r);
			assertEquals(error, 0, Lab1.contains(x, r));
		}
	}

	private void testInsideRange(int min, int max) {
		if (min == max) {
			return;
		}
		double xStart = Math.nextAfter(min, min + 1.0);
		double xEnd = Math.nextAfter(max, max - 1.0);
		double step = (xEnd - xStart) / 10;
		double[] X = new double[10];
		X[0] = xStart;
		X[9] = xEnd;
		for (int i = 1; i < 9; i++) {
			X[i] = X[i - 1] + step;
		}
		Range r = new Range(min, max);
		for (double x : X) {
			String error = String.format("contains(%f, r) failed\n" + "where r = %s\n", x, r);
			assertEquals(error, 1, Lab1.contains(x, r));
		}
	}

	@Test
	public void test21_compareTo() {
		rng.setSeed(14);
		for (int i = 0; i < 100; i++) {
			int min = rng.nextInt(100) - 50;
			Range skinny = new Range(min, min + 1);
			min = rng.nextInt(100) - 50;
			Range skinny2 = new Range(min, min + 1);
			min = rng.nextInt(100) - 50;
			Range wide = new Range(min, min + 2);
			String error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, skinny);
			assertEquals(error, 0, Lab1.compareTo(skinny, skinny));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, skinny2);
			assertEquals(error, 0, Lab1.compareTo(skinny, skinny2));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", skinny, wide);
			assertEquals(error, -1, Lab1.compareTo(skinny, wide));

			error = String.format("compareTo(r1, r2) failed for r1 = %s, r2 = %s", wide, skinny);
			assertEquals(error, 1, Lab1.compareTo(wide, skinny));
		}
	}

	@Test
	public void test22_getCourseName() {
		assertEquals("getCourseName() failed", 
				"Advanced Object Oriented Programming", Lab1.getCourseName());
	}

	@Test
	public void test23_toString() {
		String exp = "range from -10.00000001 to 9253.353156731684";
		Range r = new Range(-10.00000001, 9253.353156731684);
		String error = String.format("toString(r) failed for r = %s", r.toString());
		assertEquals(error, exp, Lab1.toString(r));
	}

	public static char randomChar() {
		return (char) (TestLab1.rng.nextInt('Z' - 'A') + 'A');
	}

	@Test
	public void test24_middleChar() {
		StringBuilder builder = new StringBuilder();
		int mid = 0;
		builder.append(TestLab1.randomChar());
		String s = builder.toString();
		String error = String.format("middleChar(%s) failed with s = %s", s, s);
		assertEquals(error, s.charAt(mid), Lab1.middleChar(s));
		mid++;

		for (int i = 0; i < 500; i++) {
			builder.append(TestLab1.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab1.middleChar(s));

			builder.append(TestLab1.randomChar());
			s = builder.toString();
			error = String.format("middleChar(%s) failed with s = %s", s, s);
			assertEquals(error, s.charAt(mid), Lab1.middleChar(s));

			mid++;
		}
	}

	@Test
	public void test25_sum() {
		String error = String.format("sum(t) failed with t = empty list");
		assertEquals(error, 0, Lab1.sumAbsolute(new ArrayList<Double>()), Math.ulp(0));

		rng.setSeed(18);
		ArrayList<Double> t = new ArrayList<>();
		double sum = 0.0;
		for (int i = 0; i < 100; i++) {
			double elem = rng.nextDouble();
			sum += elem;
			if (TestLab1.rng.nextBoolean()) {
				elem = -elem;
			}
			t.add(elem);
			ArrayList<Double> u = new ArrayList<>(t);
			error = String.format("sumAbsolute(t) failed with t = %s", t.toString());
			assertEquals(error, sum, Lab1.sumAbsolute(u), Math.ulp(sum));
			error = String.format("sum(t) failed because the list was modified");
			assertEquals(error, t, u);
		}
	}

	@Test
	public void test26_sort2() {
		ArrayList<Integer> t = new ArrayList<>();
		String error = "sort2(t) failed to throw an IllegalArgumentException";
		try {
			Lab1.sort2(t);
			fail(error);
		} catch (IllegalArgumentException x) {
			// do nothing
		} catch (Exception x) {
			fail("sort2(t) threw the wrong kind of exception");
		}

		t.add(1);
		try {
			Lab1.sort2(t);
			fail(error);
		} catch (IllegalArgumentException x) {
			// do nothing
		} catch (Exception x) {
			fail("sort2(t) threw the wrong kind of exception" + x);
		}

		t.add(2);
		t.add(3);
		try {
			Lab1.sort2(t);
			fail(error);
		} catch (IllegalArgumentException x) {
			// do nothing
		} catch (Exception x) {
			fail("sort2(t) threw the wrong kind of exception");
		}
	}

	@Test
	public void test27_sort2() {
		ArrayList<Integer> t = new ArrayList<>();
		t.add(1000);
		t.add(-1000);

		ArrayList<Integer> u = new ArrayList<>(t);
		String error = String.format("sort2(t) failed for t = %s", u.toString());
		Lab1.sort2(u);
		assertEquals(error, t, u);

		u.clear();
		u.add(t.get(1));
		u.add(t.get(0));
		error = String.format("sort2(t) failed for t = %s", u.toString());
		Lab1.sort2(u);
		assertEquals(error, t, u);
	}

	@Test
	public void test28_toUpperCase() {
		String[][] S = { {}, { "a" }, { "BIg", "cow" }, { "d", "123", "E" }, };
		String[][] EXP = { {}, { "A" }, { "BIG", "COW" }, { "D", "123", "E" }, };
		for (int i = 0; i < S.length; i++) {
			List<String> t = Arrays.asList(S[i]);
			List<String> exp = Arrays.asList(EXP[i]);
			String error = String.format("toUpperCase(t) failed for t = %s", t.toString());
			Lab1.toUpperCase(t);
			assertEquals(error, exp, t);
		}
	}

}
