/** easy
 * Laicode 259. Move 0s To The End II
 *
 * Given an array of integers, move all the 0s to the right end of the array.
 *
 * The relative order of the elements in the original array need to be maintained.
 *
 * Assumptions:
 *
 * The given array is not null.
 * Examples:
 *
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */

package Class2.Array;

import java.util.Arrays;

public class MoveZeroII {

    public int[] moveZero(int[] array) {

        if (array.length <= 1) {
            return array;
        }
        int i = 0;
        int j = 0;

        while (j < array.length) {
            if (array[j] != 0) {
                array[i++] = array[j++];
            } else {
                j++;
            }
        }

        // fill in the right part with 0.
        while (i < array.length) {
            array[i++] = 0;
        }
        return array;
    }


    public static void main(String[] args) {
        MoveZeroII obj = new MoveZeroII();

        int[] array = {1, 0, 3, 0, 1};
        System.out.println(Arrays.toString(obj.moveZero(array)));
    }
}

// TC: O(n)
// SC: O(1)