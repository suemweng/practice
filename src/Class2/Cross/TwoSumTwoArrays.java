/*
Q 185. 2 Sum 2 Arrays

Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.

Assumptions

The two given arrays are not null and have length of at least 1
Examples

A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)
A = {1, 3, 5}, B = {2, 8}, target = 6, return false

 */

package Class2.Cross;

public class TwoSumTwoArrays {

    // sort the shorter array
    // iteratively traverse the unsorted array, to see if a paired number (sum of two equals to the target) can be found from the sorted array by using binary search

    public boolean existSum(int[] a, int[] b, int target) {
        // compare the length of two arrays, to sort the shorter one for better time complexity
        if (a.length <= b.length) {
            quickSort(a, 0, a.length - 1);
            return helper(a, b, target);
        } else {
            quickSort(b, 0, b.length - 1);
            return helper(b, a, target);
        }
    }

    private boolean helper(int[] sorted, int[] unsorted, int target) {
        for (int i = 0; i < unsorted.length; i++) {
            int num = target - unsorted[i];
            boolean found = binarySearch(sorted, num);
            if (found) {
                return true;
            }
        }
        return false;
    }

    private void quickSort(int[] array, int left, int right) {
        // base case
        if (left >= right) return;

        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivotValue = array[pivotIndex];

        // rainbow sort
        int i = left;
        int j = left;
        int k = right;

        while (j <= k) {
            if (array[j] < pivotValue) {
                swap(array, i++, j++);
            } else if (array[j] == pivotValue) {
                j++;
            } else {
                swap(array, j, k--);
            }
        }

        quickSort(array, left, i - 1);
        quickSort(array, k + 1, right);

    }

    private boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        TwoSumTwoArrays solution = new TwoSumTwoArrays();

        int[] a = {3,1,5};
        int[] b = {2,8};
        int target = 7;
        boolean found = solution.existSum(a,b,target);
        System.out.println(found);
    }
}

// TC: O(nlogn + mlogn) ==> O((m+n)logn) n - length of the shorter array
// SC: O(logn) - quickSort stack space

