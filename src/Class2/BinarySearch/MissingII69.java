/*
Q 69. Missing Number II

Given an integer array of size N - 1 sorted by ascending order, containing all the numbers from 1 to N except one, find the missing number.

Assumptions

The given array is not null, and N >= 1
Examples

A = {1, 2, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1

 */

package Class2.BinarySearch;

public class MissingII69 {

    public int missing(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length == 0 || array[0] != 1) return 1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] - mid == 1) left = mid + 1;
            else right = mid - 1;
        }

        return array[right] + 1;

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,5,6};
        MissingII69 solution = new MissingII69();
        int missing = solution.missing(array);
        System.out.println(missing);
    }
}
