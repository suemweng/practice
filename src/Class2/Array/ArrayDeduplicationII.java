/** medium
 * Laicode 116. Array Deduplication II
 *
 * Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 */

package Class2.Array;

import java.util.Arrays;

public class ArrayDeduplicationII {

    // TC: O(n)
    // SC: O(1)

    public int[] dedup(int[] array) {
        // corner case
        if (array == null || array.length <= 2) {
            return array;
        }

        int slow = 2;
        int fast = 2;


        while (fast < array.length) {
            if (array[fast] != array[slow - 2]) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        ArrayDeduplicationII obj = new ArrayDeduplicationII();

        int[] array = {1, 2, 2, 3, 3, 3};
        array = obj.dedup(array);
        System.out.println(Arrays.toString(array));
    }
}
