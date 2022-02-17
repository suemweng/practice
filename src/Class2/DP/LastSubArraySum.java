/**
 * Laicode 97. Largest SubArray Sum
 *
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 1.
 * Examples
 *
 * {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 * {-2, -1, -3}, the largest subarray sum is -1
 */

package Class2.DP;

public class LastSubArraySum {

    public int largestSum(int[] array) {


        int lastSum = array[0];
        int maxSum = array[0];

        // Induction rule
        // if M[i - 1] < 0: M[i] = A[i]
        // else: M[i] = M[i - 1] + A[i]
        for (int i = 1; i < array.length; i++) {
            lastSum = Math.max(lastSum + array[i], array[i]);
            maxSum = Math.max(maxSum, lastSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LastSubArraySum obj = new LastSubArraySum();

        int[] array = {2, -1, 4, -2, 1};
        System.out.println(obj.largestSum(array));
    }
}

// TC: O(n)
// SC: O(1)
