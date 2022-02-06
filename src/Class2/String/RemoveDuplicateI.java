/**
 * Laicode 79. Remove Adjacent Repeated Characters I
 *
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 *
 * Assumptions
 *
 * Try to do it in place.
 * Examples
 *
 * “aaaabbbc” is transferred to “abc”
 * Corner Cases
 *
 * If the given string is null, returning null or an empty string are both valid.
 */

package Class2.String;

public class RemoveDuplicateI {

    public String deDup(String input) {

        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        // Try to convert string to char array and do it in-place
        char[] array = input.toCharArray();
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            // repeated characters will be ignored
            // except for the first character in the sequence
            if (array[j] != array[i]) {
                array[++i] = array[j];
            }
        }
        return new String(array, 0, i + 1);
    }

    public static void main(String[] args) {
        RemoveDuplicateI obj = new RemoveDuplicateI();

        String input = "aaaaabbbc";
        String result = obj.deDup(input);
        System.out.println(result);
    }
}

// TC: O(n)
// SC: O(n)