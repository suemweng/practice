/*
Q 236. Search Insert Position 35

Given a sorted array and a target value, return the index where it would be if it were inserted in order.

Assumptions
If there are multiple elements with value same as target, we should insert the target before the first existing element.

Examples

[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,3,3,5,6], 3 → 1

[1,3,5,6], 0 → 0

 */

package Class2.BinarySearch;

public class InsertPosition236 {
    public int searchInsert(int[] input, int target) {
        // Write your solution here
        if (input == null || input.length == 0) return 0;

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        int target = 0;
        InsertPosition236 solution = new InsertPosition236();
        int index = solution.searchInsert(array, target);
        System.out.println(index);
    }
}

// TC: O(log n)
// SC: O(1)
