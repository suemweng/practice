package Class2.String;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    // maybe duplicate letters in the input string

    public void permutation(String input) {
        // corner case
        if (input == null || input.length() == 0) {
            return;
        }

        char[] array = input.toCharArray();
        permutation(array, 0);
    }

    private void permutation(char[] input, int index) {
        if (index == input.length) {
            System.out.println(input);
            return;                     // mistake: forgot to return;
        }

        Set<Character> used = new HashSet<>();
        for (int i = index; i < input.length; i++) {
            // set.add(e) returns false if this set already contains the element
            if (used.add(input[i])) {
                swap(input, index, i);
                permutation(input, index + 1);
                swap(input, index, i);
            }
        }
    }

    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        Permutation obj = new Permutation();

        String input = "abb";
        obj.permutation(input);
    }
}

// TC: O(n! * n)
// SC: O(n ^ 2)  -- (n + (n - 1) + (n - 2) + ... + 1) -- n * ( n + 1) / 2   -- sets created on each level