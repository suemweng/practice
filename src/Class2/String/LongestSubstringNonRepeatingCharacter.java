/**
 * Laicode  253. Longest Substring Without Repeating Characters
 *
 * Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
 *
 * For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 */

package Class2.String;

import java.util.Set;
import java.util.HashSet;

public class LongestSubstringNonRepeatingCharacter {

    public int longest(String input) {
        // Write your solution here

        if (input == null || input.length() == 0) {
            return 0;
        }
        Set<Character> visited = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;

        while (j < input.length()) {
            if (!visited.contains(input.charAt(j))){
                visited.add(input.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                visited.remove(input.charAt(i++));
            }

        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringNonRepeatingCharacter obj = new LongestSubstringNonRepeatingCharacter();

        String input = "bcdfbd";
        System.out.println(obj.longest(input));
    }
}

// TC: O(n)
// SC: O(n)
