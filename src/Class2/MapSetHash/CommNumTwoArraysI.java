/**
 * LaiCode 650. Common Numbers Of Two Arrays I(Array version)
 *
 * Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
 *
 * Assumptions
 *
 * Both arrays are not null.
 * There are no duplicate numbers in each of the two arrays respectively.
 * Exmaples
 *
 * A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 * A = {}, B = {3, 1, 4}, return []
 */

package Class2.MapSetHash;

import java.util.*;


public class CommNumTwoArraysI {
    // Assumptions:
    // 1. Both arrays are not null
    // 2. no duplicate numbers in each of the arrays
    // TC: O(m + n + n logn) -- two loops + sort (shorter array)
    // SC: O(n) -- set
    public List<Integer> common(int[] a, int[] b) {
        // Write your solution here

        if (a.length < b.length) {
            return common(b, a);
        }

        List<Integer> result = new ArrayList<>();

        // corner case
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return result;
        }


        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }

        Arrays.sort(b);
        for (int num : b) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

}
