/** medium
 * Laicode 68. Missing Number I
 *
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 *
 * Assumptions
 *
 * The given array is not null, and N >= 1
 * Examples
 *
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */

package Class2.Array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumberI {

    // Method 1: HashSet / boolean array
    // iterate twice, one on array, one on 1-N to find the missing one

    // TC: O(n)
    // SC: O(n)

    public int missingI(int[] array) {
        // Write your solution here
        // hashset
        Set<Integer> set = new HashSet<>();

        for (int i : array) {
            set.add(i);
        }

        for (int i = 1; i <= array.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return array.length + 1;
    }

    // Method 2: Sum
    // use the difference of targetSum and actualSum

    // TC: O(n)
    // SC: O(1)

    public int missingII(int[] array) {

        int targetSum = (array.length + 1) * (array.length + 2) / 2;

        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }

        return targetSum - actualSum;
    }

    // Method 3: bit operation
    // 0 ^ a = a
    // a ^ a = 0
    // a ^ b = b ^ a
    // a ^ b ^ c = a ^ (b ^ c) 类似加法运算的交换律和结合律
    // so use the above rules, XOR(0 ~ N) ^ XOR(array) = missing number

    // TC: O(n)
    // SC: O(1)

    public int missingIII(int[] array) {
        // Write your solution here

        int xor = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            xor ^= i;

        }

        for (int num : array) {
            xor ^= num;
        }

        return xor;
    }

    // Method 4: swap position
    // in place swap to sort the array, except the missing number and number N

    public int missingIV(int[] array) {


        for (int i = 0; i < array.length; i++) {
            // important: use while, instead of if, to make sure each index has been placed in the correct number
            while (array[i] - 1 != i && array[i] - 1 != array.length) {
                swap(array, i, array[i] - 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] - i != 1) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        MissingNumberI obj = new MissingNumberI();

        int[] array = {12,11,10,9,4,5,6,7,2,3,1};
        System.out.println(obj.missingIV(array));
    }
}
