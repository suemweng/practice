/**
 * Laicode 199. Max Water Trapped I
 *
 * Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
 *
 */

package Class2.Array;

public class MaxWaterTrappedI {

    public int maxTrapped(int[] array) {

        // Key insight:
        // min(leftMax, rightMax) - i

        // TC: O(n)
        // SC: O(1)

        if (array.length == 0) {
            return 0;
        }

        int i = 0;
        int j = array.length - 1;
        int leftMax = array[i];
        int rightMax = array[j];
        int sum = 0;

        while (i < j) {
            leftMax = Math.max(leftMax, array[i]);
            rightMax = Math.max(rightMax, array[j]);

            if (leftMax < rightMax) {
                sum = sum + (leftMax - array[i]);
                i++;
            } else {
                sum = sum + (rightMax - array[j]);
                j--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MaxWaterTrappedI obj = new MaxWaterTrappedI();

        int[] array = {2,1,3,2,4};
        System.out.println(obj.maxTrapped(array));
    }
}
