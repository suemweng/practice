/**
 * Laicode 88. Array Hopper I
 *
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position
 * (you can only jump towards the end of the array). Determine if you are able to reach the last index.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 1.
 * Examples
 *
 * {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
 * {2, 1, 1, 0, 2}, we are not able to reach the end of array
 */

package Class2.DP;

public class ArrayHopperI {


    public boolean canJump(int[] array) {
        // Write your solution here
        // base case
        // dp[array.length - 1] = T
        // Induction rule
        // dp[i] = dp[i + 1] || dp[i + 2] || ... || dp[i + array[i]]

        boolean[] dp = new boolean[array.length];       // error: new boolean[array.length - 1]
        dp[array.length - 1] = true;

        for (int i = array.length - 2; i >= 0; i--) {
            // dp[i] default false
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < array.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        ArrayHopperI obj = new ArrayHopperI();

        int[] array = {1,0,1,0,0,0,0,0,1,100,0};
        System.out.println(obj.canJump(array));
    }
}

// TC: O(n ^ 2)
// SC: O(n)