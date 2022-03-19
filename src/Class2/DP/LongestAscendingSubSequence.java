/**
 * Laicode 1. Longest Ascending Subsequence
 *
 * Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
 *
 * Assumptions
 *
 * A is not null
 * Examples
 * Input: A = {5, 2, 6, 3, 4, 7, 5}
 * Output: 4
 * Because [2, 3, 4, 5] is the longest ascending subsequence.
 */

package Class2.DP;

public class LongestAscendingSubSequence {

    // Method 1
    // Key insight:
    // linear scan all the elements on the left side and smaller

    // TC: O(n ^ 2)

    public int longest(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        // dp[i] = the length of the longest ascending subsequence ending at index i
        int[] dp = new int[array.length];
        int max = 0;

        // induction rule: max(dp[j]) A[j] < A[i] && j < i
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
