/**
 * Laicode 103. Longest Consecutive 1s
 *
 * Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */

package Class2.DP;

public class LongestOnes {

    public int longest(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int cur = array[0];
        int max = cur;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestOnes obj = new LongestOnes();

        int[] array = {0, 1, 0, 1, 1, 1, 0};
        System.out.println(obj.longest(array));

    }
}

// TC: O(n)
// SC: O(1)