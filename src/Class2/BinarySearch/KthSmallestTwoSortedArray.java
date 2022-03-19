/**
 * Laicode 202. Kth Smallest In Two Sorted Arrays
 *
 * Given two sorted arrays of integers, find the Kth smallest number.
 *
 * Assumptions
 *
 * The two given arrays are not null and at least one of them is not empty
 * K >= 1, K <= total lengths of the two sorted arrays
 * Examples
 *
 * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
 * A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */

package Class2.BinarySearch;

public class KthSmallestTwoSortedArray {

    // Key insight:
    // compare array[k / 2], the elements ahead of smaller one can be taken off

    public int kth(int[] a, int[] b, int k) {
        return helper(a, 0, b, 0, k);
    }

    private int helper(int[] a, int aleft, int[] b, int bleft, int k) {

        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }

        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }

        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }

        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

        if (aval < bval) {
            return helper(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return helper(a, aleft, b, bmid + 1, k - k / 2);
        }
    }

    public static void main(String[] args) {
        KthSmallestTwoSortedArray obj = new KthSmallestTwoSortedArray();

        int[] a = {1,4,6};
        int[] b = {2,3};
        int k = 3;
        System.out.println(obj.kth(a, b, k));
    }
}
