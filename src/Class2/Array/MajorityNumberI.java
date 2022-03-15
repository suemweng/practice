/**
 * Laicode 206. Majority Number I
 *
 * Given an integer array of length L, find the number that occurs more than 0.5 * L times.
 *
 * Assumptions
 *
 * The given array is not null or empty
 * It is guaranteed there exists such a majority number
 * Examples
 *
 * A = {1, 2, 1, 2, 1}, return 1
 */

package Class2.Array;

public class MajorityNumberI {

    // Key insight:
    // Removing two different elements does not change the result 互相抵消
    // candidate maintains current majority

    // TC: O(n)
    // SC: O(1)

    public int majority(int[] array) {

        int candidate = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i];
                count++;
            } else if (array[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityNumberI obj = new MajorityNumberI();

        int[] array =  {1, 2, 1, 2, 1};
        System.out.println(obj.majority(array));

    }
}
