/**
 * Laicode 11. Rainbow Sort
 *
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
 *
 * Examples
 *
 * {0} is sorted to {0}
 * {1, 0} is sorted to {0, 1}
 * {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
 * Assumptions
 *
 * The input array is not null.
 * Corner Cases
 *
 * What if the input array is of length zero? In this case, we should not do anything as well.
 */

package Class2.Sorting;

import java.util.Arrays;

public class RainbowSort {
    // Assumptions: we have three colors denoted as -1, 0, 1
    // and all the elements in the array are valid
    public int[] rainbowSort(int[] array) {

        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        // three bounds
        // 1. [0, i)    -1
        // 2. [i, j)    0
        // 3. [j, k]    to be discovered
        // 4. (k, array.length - 1] 1

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else if (array[j] == 1 && array[k] == 1) {
                k--;
            } else {
                swap(array, j, k--);
            }

        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        RainbowSort obj = new RainbowSort();

        int[] array = {1, 0, 1, -1, 0};
        array = obj.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
}
// TC: O(log n)
// SC: O(1)
