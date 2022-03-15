/**
 * Laicode 263. Two Subsets With Min Difference
 *
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
 *
 * Return the minimum difference(absolute value).
 *
 * Assumptions:
 *
 * The given integer array is not null and it has length of >= 2.
 * Examples:
 *
 * {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */

package Class2.DFS;

public class MinDifference {

    public int minDifference(int[] array) {
        // Write your solution here

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int[] min = {Integer.MAX_VALUE};
        dfs(0, 0, sum, min, array);
        return min[0];
    }

    private void dfs(int start, int curSum, int sum, int[] min, int[] array) {
        min[0] = Math.min(min[0], Math.abs(curSum * 2 - sum));

        // base case

        for (int i = start; i < array.length; i++) {
            dfs(i + 1, curSum + array[i], sum, min, array);
        }
    }

    public static void main(String[] args) {
        MinDifference obj = new MinDifference();

        int[] array = {-2, -9, -3, -1, -1};
        System.out.println(obj.minDifference(array));
    }
}
