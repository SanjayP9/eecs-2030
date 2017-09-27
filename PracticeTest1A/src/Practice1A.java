import java.util.ArrayList;
import java.util.List;

public class Practice1A extends Object {

	public Practice1A() {

	}

	public static final String TEST_VERSION = "PRACTICE";

	public static String hello(String name) {
		return "Hello, " + name;
	}

	public static List<Character> repeatedChars(String s) {
		List<Character> temp = new ArrayList<Character>();
		Character tempChar;

		for (int i = 0; i < s.length(); i++) {
			tempChar = s.charAt(i);
			for (int j = i; j < s.length(); j++) {
				if (j != i && (s.charAt(j) == tempChar)) {
					if (temp.contains(s.charAt(j)) == false) {
						temp.add(s.charAt(j));
					}
				}
			}
		}
		return temp;
	}

	public static List<Character> shuffle(List<Character> t) {
		List<Character> result = new ArrayList<Character>();
		int split = t.size() / 2;

		for (int i = 0; i < split; i++) {
			result.add(t.get(i));
			result.add(t.get(i + split));
		}

		return result;
	}

	public static String toString(List<Character> t) {

		if (t.isEmpty()) {
			throw new IllegalArgumentException();
		} else {

			String temp = "";
			for (int i = 0; i < t.size(); i++) {
				temp += t.get(i);
			}

			return temp;
		}
	}

	public static void main(String args[]) {
		// List<Character> charList = repeatedChars("EECS2030");
		//
		// for (int i = 0; i < charList.size(); i++) {
		// System.out.println(charList.get(i));
		// }
		/*
		 * List<Character> charList = new ArrayList<Character>(); charList.add('g');
		 * charList.add('o'); charList.add('o'); charList.add('d'); charList.add('b');
		 * charList.add('y'); charList.add('e');
		 * 
		 * System.out.println(toString(charList));
		 */
		List<Character> charList = new ArrayList<Character>();
		charList.add('a');
		charList.add('b');
		charList.add('c');
		charList.add('d');
		charList.add('e');
		charList.add('f');

		List<Character> result = shuffle(charList);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
