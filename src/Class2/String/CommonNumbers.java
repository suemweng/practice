/**
 * Laicode 652. Common Numbers Of Two Sorted Arrays(Array version)
 *
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 *
 * Assumptions
 *
 * In each of the two sorted arrays, there could be duplicate numbers.
 * Both two arrays are not null.
 * Examples
 *
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */

package Class2.String;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbers {
    // Assumptions: there could be duplicated elements in the given arrays

    // Method 1: two pointers
    // TC: O(m + n)
    // SC: O(min(m, n))
    public List<Integer> common(int[] A, int[] B) {
        // Assumption: A, B is not  null

        List<Integer> list = new ArrayList<>();
        // corner case
        if (A.length == 0 || B.length == 0) {
            return list;
        }

        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                list.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {  // A[i] > B[j]
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        CommonNumbers obj = new CommonNumbers();

        int[] A = {1,1,2,2,3};
        int[] B = {1,1,2,5,6};
        List<Integer> result = obj.common(A, B);
        System.out.println(result);
    }
}
