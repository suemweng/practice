/*
Q 21 Search In Shifted Sorted Array I  -- LeetCode 33

Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.

For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There are no duplicate elements in the array.
Examples

A = {3, 4, 5, 1, 2}, T = 4, return 1
A = {1, 2, 3, 4, 5}, T = 4, return 3
A = {3, 5, 6, 1, 2}, T = 4, return -1
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
 */

package Class2.BinarySearch;

public class Shifted21 {

    public int shifted(int[] array, int target) {

        // corner case
        if (array == null || array.length == 0) return -1;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;

            // same idea as classical binary search, to decide target is NOT in which side
            // determine which side is sorted, and decide if target in the sorted side
            if (array[left] <= array[mid]) {
                // target in sorted area or not
                if (array[left] <= target && target < array[mid]) right = mid - 1;
                else left = mid + 1;

            } else {
                if (array[mid] < target && target <= array[right]) left = mid + 1;
                else right = mid - 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Shifted21 solution = new Shifted21();
        int[] array = {1};
        int target = 1;
        int index = solution.shifted(array,target);
        System.out.println(index);

    }
}

// TC: O (log n)
// SC: O (1)