import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1B {

	private Practice1B() {

	}

	public static int alternatingSum(List<Integer> t) {

		int sum = 0;

		for (int i = 0; i < t.size(); i++) {
			if (i % 2 == 0) {
				sum += t.get(i);
			} else {
				sum -= t.get(i);
			}
		}

		return sum;
	}

	public static List<Integer> encode(List<Integer> t) {

		int count = 0;
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < t.size(); i++) {
			count = 0;

			for (int j = i; j < t.size(); j++) {
				if (t.get(i) == t.get(j)) {
					count++;
				} else {
					break;
				}
			}
			result.add(count);
			result.add(t.get(i));
			i += count - 1;
		}

		return result;
	}

	public static Integer last(List<Integer> t) {
		return t.get(t.size() - 1);
	}

	public static int totalArea(List<Integer> widths, List<Integer> heights) {

		if (widths.size() != heights.size()) {
			throw new IllegalArgumentException();
		} else {

			int sum = 0;

			for (int i = 0; i < widths.size(); i++) {
				if (widths.get(i) > 0 && heights.get(i) > 0) {
					sum += widths.get(i) * heights.get(i);
				}
			}

			return sum;
		}
	}

	public static void main(String args[]) {
		/*
		 * List<Integer> temp = Arrays.asList(0,1,2,3,4,5);
		 * 
		 * System.out.println(alternatingSum(temp));
		 */

		/*
		 * List<Integer> temp = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
		 * 
		 * System.out.println(encode(temp));
		 */

		List<Integer> w = Arrays.asList(1, 5, 10);
		List<Integer> h = Arrays.asList(2, 3, 4);
		
		System.out.println(totalArea(w,h));

	}
}
