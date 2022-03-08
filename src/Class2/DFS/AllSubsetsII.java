/** hard
 * Laicode 63. All Subsets II
 *
 * Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.
 *
 * Assumptions
 *
 * There could be duplicate characters in the original set.
 * ​Examples
 *
 * Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
 * Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {

    // TC: O(2 ^ n * n + nlogn) - * n is the time of .toString(); nlogn to sort the array
    // SC: O(n)

    public List<String> subSets(String set) {

        List<String> result = new ArrayList<>();
        // corner case
        if (set == null ) {                     // error: put "" as corner case
            return result;
        }

        char[] array = set.toCharArray();
        // make sure the array is sorted so that we can dedup
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        findSubset(0, array, sb, result);
        return result;
    }

    private void findSubset(int index, char[] array, StringBuilder sb, List<String> result) {
        // base case
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }

        // add
        sb.append(array[index]);
        findSubset(index + 1, array, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        // not add
        // skip all the consecutive and duplicate elements
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        findSubset(index + 1, array, sb, result);
    }

    public static void main(String[] args) {
        AllSubsetsII obj = new AllSubsetsII();

        String input = "abab";
        System.out.println(obj.subSets(input));
    }
}
