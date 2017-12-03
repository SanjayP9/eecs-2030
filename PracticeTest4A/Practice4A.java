import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice4A {
    private Practice4A() {
        // empty by design
    }

    /**
     * Returns the string starting with n, followed by a
     * comma and a space, followed by n - 1, followed by a
     * comma and a space, and so on, ending with 0. For example:
     * <p>
     * <pre>
     * countdown(0) returns the string equal to "0"
     * countdown(1) returns the string equal to "1, 0"
     * countdown(2) returns the string equal to "2, 1, 0"
     * countdown(3) returns the string equal to "3, 2, 1, 0"
     * </pre>
     *
     * @param n a value to count down from
     * @return a string as described above
     * @pre. n is greater than or equal to zero
     */
    public static String countdown(int n) {
        if (n == 0) {
            return "0";
        } else {
            return Integer.toString(n) + ", " + countdown(n - 1);
        }
    }


    /**
     * Returns the string equal to the string formed by
     * removing all of the 'a' and 'A' characters from the
     * argument string s.
     * <p>
     * <p>
     * For example:
     * </p>
     * <p>
     * <pre>
     * removeA("") returns the empty string
     * removeA("a") returns the empty string
     * removeA("B") returns the string equal to "B"
     * removeA("ABA") returns the string equal to "B"
     * removeA("BananA") returns the string equal to "Bnn"
     * removeA("aaaaAAAaaA") returns the empty string.
     * </pre>
     *
     * @param s a string
     * @return the string equal to removing all of the lower
     * and uppercase a's from the argument string s
     */
    public static String removeA(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            if (Character.toLowerCase(s.charAt(0)) == 'a') {
                return removeA(s.substring(1));
            } else {
                return Character.toString(s.charAt(0)) + removeA(s.substring(1));
            }
        }
    }

    /**
     * Computes the sum of the elements in the argument list
     * t starting from the first element and skipping every
     * second element. The sum of an empty list is zero.
     * <p>
     * <p>
     * For example:
     * </p>
     * <p>
     * <pre>
     * if t is []                 then sumSkip(t) returns 0
     * if t is [1]                then sumSkip(t) returns 1
     * if t is [-1, 2]            then sumSkip(t) returns -1
     * if t is [1, 2, 8]          then sumSkip(t) returns 9
     * if t is [1, 0, -9, 4]      then sumSkip(t) returns -8
     * if t is [1, 2, 12, -3, 15] then sumSkip(t) returns 28
     * </pre>
     *
     * @param t a list of integer values
     * @return the sum of all of the elements of t having an
     * even index
     */
    public static int sumSkip(List<Integer> t) {
        if (t.size() == 0) {
            return 0;
        } else if (t.size() <= 2) {
            return t.get(0);
        } else {
            int temp = t.get(0);
            t.remove(0);
            t.remove(0);
            return temp + sumSkip(t);
        }
    }


    /**
     * Returns the largest sum that can be formed using the
     * elements of t that does not exceed n. Each element of
     * t can be used at most once in the sum.
     * <p>
     * <pre>
     * if t is []                 then maxSum(t, 1) returns 0
     * if t is [1]                then maxSum(t, 1) returns 1
     * if t is [10]               then maxSum(t, 1) returns 0
     * if t is [10, 20, 32]       then maxSum(t, 31) returns 30
     * if t is [20, 10, 32]       then maxSum(t, 100) returns 62
     * if t is [7, 30, 8, 22, 6, 1, 14] then maxSum(t, 19) returns 16
     * </pre>
     *
     * @param t a list of integer values
     * @param n the value not to exceed
     * @return a value less than or equal to n formed by
     * summing elements of t
     */
    public static int maxSum(List<Integer> t, int n) {
        return maxSum(t, n, 0);
        // You should implement the private method 
        // maxSum(List<Integer> t, int n, int currentSum)
    }

    /**
     * Returns the largest value not exceeding n that can be
     * formed by adding elements of t to currentSum. Each element of
     * t can be used at most once in the sum.
     *
     * @param t          a list of integer values
     * @param n          the value not to exceed
     * @param currentSum the current sum
     * @return the largest value not exceeding n that can be
     * formed by adding elements of t to currentSum
     * @pre. currentSum is less than or equal to n
     */
    private static int maxSum(List<Integer> t, int n, int currentSum) {
        if (t.size() == 0) {
            return currentSum;
        } else {
            if (t.get(0) + currentSum < n) {
                currentSum += t.get(0);
            }
            t.remove(0);
            return maxSum(t, n, currentSum);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < args.length - 1; i++) {
            list.add(Integer.parseInt(args[i]));
        }
        int n = Integer.parseInt(args[args.length - 1]);

        System.out.println(maxSum(list, n));
    }

}
