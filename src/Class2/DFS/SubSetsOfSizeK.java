/**
 * Laicode 640. All Subsets of Size K
 *
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.
 *
 * Assumptions
 *
 * There are no duplicate characters in the original set.
 *
 * ​Examples
 *
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 *
 * Set = "", K = 0, all the subsets are [""].
 *
 * Set = "", K = 1, all the subsets are [].
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class SubSetsOfSizeK {

    // TC: O(2 ^ n * n)
    // SC: O(n)

    public List<String> subSetsOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<>();

        // corner case
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        findSubSets(0, array, k, sb, result);
        return result;

    }

    private void findSubSets(int index, char[] array, int k, StringBuilder sb, List<String> result) {
        // base case
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }

        if (index == array.length) {
            return;
        }

        // append the array[index]
        sb.append(array[index]);
        findSubSets(index + 1, array, k, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // append nothing
        findSubSets(index + 1, array, k, sb, result);
    }
}
