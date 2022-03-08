/** medium
 * Laicode 117. Array Deduplication III
 *
 * Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1}
 */

package Class2.Array;

import java.util.Arrays;

public class ArrayDeduplicationIII {

    // TC: O(n)
    // SC: O(1)

    public int[] dedup(int[] array) {

        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        int slow = 1;
        int fast = 1;

        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast++];
                continue;
            }

            while (fast < array.length && array[fast] == array[slow - 1]){
                fast++;
            }
            slow--;
        }
        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        ArrayDeduplicationIII obj = new ArrayDeduplicationIII();

        int[] array = {1, 2, 2, 3, 3, 3};
        array = obj.dedup(array);
        System.out.println(Arrays.toString(array));

    }
}
