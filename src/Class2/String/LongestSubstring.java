/**
 * Longest substring that contains only unique char
 * Given a string, returns the length of the longest substring without duplicate characters.
 * For example, the longest substring without repeating characters for "BDEFGADE" are "BDEFGA"
 * whose size is 6.
 */

package Class2.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int longest(String input) {
        // corner case
        if (input == null || input.length() == 0) {
            return 0;
        }

        char[] array = input.toCharArray();
        Set<Character> distinct = new HashSet<>();

        // [slow... fast-1] is the sliding window
        int slow = 0;
        int fast = 0;
        int max = 0;

        while(fast < array.length) {
            if (!distinct.contains(array[fast])) {
                // if there is no duplicate character, we can slide
                // the fast pointer, and we have a new sliding window of
                // (slow, fast) containing all distinct character
                distinct.add(array[fast]);
                fast++;
                max = Math.max(max, fast - slow);   // mistake: using distinct.size() might takes TC
            } else {
                // if there is duplicate character, we need to move
                // the slow pointer
                distinct.remove(array[slow]);
                slow++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstring obj = new LongestSubstring();

        String input = "BDEFGADE";
        int max = obj.longest(input);
        System.out.println(max);
    }

}

// TC: O(n)
// SC: O(n)