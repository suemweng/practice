/**
 * Laicode 397. Right Shift By N Characters
 *
 * Right shift a given string by n characters.
 *
 * Assumptions
 *
 * The given string is not null.
 * n >= 0.
 * Examples
 *
 * "abc", 4 -> "cab"
 */

package Class2.String;

public class RightShift {

    // Assumption: input is not null, n >= 0
    public String rightShift(String input, int n) {

        // corner case
        if (input == null || input.length() <= 1 || n == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        n = n % array.length;

        reverse(array, 0, array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);

        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RightShift obj = new RightShift();

        String input = "abc";
        int n = 4;
        String result = obj.rightShift(input, n);
        System.out.println(result);
    }
}

// TC: O(n)
// SC: O(n)