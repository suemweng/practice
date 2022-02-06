/**
 * Laicode 84. Reverse Words In A Sentence I
 *
 * Reverse the words in a sentence.
 *
 * Assumptions
 *
 * Words are separated by single space
 * There are no heading or tailing white spaces
 * Examples
 *
 * “I love Google” → “Google love I”
 * Corner Cases
 *
 * If the given string is null, we do not need to do anything.
 */

package Class2.String;

public class ReverseWords {
    // Assumptions:
    // 1. The words are separated by one space character
    // 2. There are no leading or tailing spaces
    // 3. input is not null

    public String reverseWords(String input) {

        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        // Try to convert it to char array and
        // solve the problem in-place
        char[] array = input.toCharArray();

        // reverse the whole char array
        reverse(array, 0, array.length - 1);

        int i = 0;
        // reverse each of the words
        for(int j = 0; j < array.length; j++) {
            // the start index of the word
            if (array[j] != ' ' && (j == 0 || array[j - 1] == ' ')) {
                i = j;
            }

            // the end index of the word
            if (array[j] != ' ' && (j == array.length - 1 || array[j + 1] == ' ')) {
                reverse(array, i, j);
            }
        }
        return new String(array);

    }

    // My own logic in while loop
    public String reverseWords2(String input) {

        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();

        reverse(array, 0, array.length - 1);

        int i = 0;
        int j = 0;
        // reverse when j points to space or end of the array
        while (j <= array.length) {
            if (j == array.length || array[j] == ' ') {
                reverse(array, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }
        }
        return new String(array);

    }

    private void reverse(char[] array, int left, int right) {

        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();

        String input = "an apple";
        String result = obj.reverseWords2(input);
        System.out.println(result);
    }
}

// TC: O(n)
// SC: O(n)