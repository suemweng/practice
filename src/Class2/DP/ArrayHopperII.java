/**
 * Laicdoe 89. Array Hopper II
 *
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 1.
 * Examples
 *
 * {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 */

package Class2.DP;

public class ArrayHopperII {

    // Base cae M[n - 1]
    // Inductions rule:
    // dp[i] =  min(opt 1, opt 2, ... opt k)
    //       =
    public int minJump(int[] array) {

        // dp[i] represent from the current index i minimum number of jumps to reach the target index
        int[] dp = new int[array.length];
        dp[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            dp[i] = -1;
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < array.length && dp[i + j] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i + j] + 1) {
                        dp[i] = dp[i + j] + 1;
                    }
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        ArrayHopperII obj = new ArrayHopperII();

        int[] array = {3,3,1,0,4};
        System.out.println(obj.minJump(array));
    }
}
// TC: O(n ^ 2)
// SC: O(n)