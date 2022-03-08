/** easy
 * Laicode  180. 2 Sum
 *
 * Determine if there exist two elements in a given array, the sum of which is the given target number.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 2
 * ​Examples
 *
 * A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
 * A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
 * A = {2, 4, 1}, target = 4, return false
 */

package Class2.Array;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class TwoSum {

    // Method 1: use HashSet to record the previous traversed values
    // TC: O(n)
    // SC: O(n)
    public boolean existSum_Set(int[] array, int target) {

        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    // Method 2: sort the array first, then use two pointers
    // TC: O(n logn + n) -- sort array
    // SC: O(1)
    public boolean existSum_TwoPointers(int[] array, int target) {

        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] array = {1, 2, 3, 4};
        int target = 5;
        System.out.println(obj.existSum_TwoPointers(array, target));
    }
}
