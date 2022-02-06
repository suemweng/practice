/**
 * Laicod 396. Reverse String
 *
 * Reverse a given string.
 *
 * Assumptions
 *
 * The given string is not null.
 */

package Class2.String;

public class Reverse {

    // Method 1  Iterative
    // TC: O(n)
    // SC: O(n)

    public String reverseI(String input) {

        // corner case
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }

        return new String(array);
    }

    // Method 2: Recursion
    // TC: O(n) -- n / 2
    // SC: O(n) -- n / 2
    public String reverseR(String input) {
        // corner case
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        reverseR(array, 0, array.length - 1);
        return new String(array);
    }

    void reverseR(char[] input, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        swap(input, left, right);
        reverseR(input, left + 1, right - 1);
    }




    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        Reverse obj = new Reverse();

        String input = "apple";
        String result = obj.reverseR(input);
        System.out.println(result);
    }
}
