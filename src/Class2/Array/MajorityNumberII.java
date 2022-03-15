/**
 * Laicode 207. Majority Number II
 *
 * Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * A = {1, 2, 1, 2, 1}, return [1, 2]
 * A = {1, 2, 1, 2, 3, 3, 1}, return [1]
 * A = {1, 2, 2, 3, 1, 3}, return []
 *
 */

package Class2.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityNumberII {
    // Method 1: Boyer Moore Algo
    // Key insight: can1 and can2 maintains the top 2 majority
    //              need 2nd iteration to verify the count requirement > 1/3

    // TC: O(n)
    // SC: O(1)

    public List<Integer> majority(int[] array) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        int can1 = array[0];
        int can2 = array[0];
        int count1 = 0;
        int count2 = 0;

        for (int num : array) {
            if (num == can1) {
                count1++;
            } else if (num == can2) {
                count2++;
            } else if (count1 == 0) {
                can1 = num;
                count1++;
            } else if (count2 == 0) {
                can2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : array) {
            if (num == can1) {
                count1++;
            } else if (num == can2) {
                count2++;
            }
        }

        if (count1 > array.length / 3) {
            result.add(can1);
        }
        if (count2 > array.length / 3) {
            result.add(can2);
        }

        return result;
    }


    // Method 2: HashMap
    // Key insight: use map to record the count during iteration

    // TC: O(n)
    // SC: O(n)

    public List<Integer> majorityMap(int[] array) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : array) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
            }
        }

        for (int key : count.keySet()) {
            if (count.get(key) > array.length / 3) {
                result.add(key);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityNumberII obj = new MajorityNumberII();

        int[] array = {1,2,2,3,2,2,3,3,3};
        System.out.println(obj.majority(array));
    }

}
