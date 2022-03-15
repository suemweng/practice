/**
 * Laicode 641. All Subsets II of Size K
 *
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.
 *
 *
 *
 * Assumptions
 *
 * There could be duplicate characters in the original set.
 *
 * ​
 *
 * Examples
 *
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 *
 * Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
 *
 * Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
 *
 * Set = "", K = 0, all the subsets are [""].
 *
 * Set = "", K = 1, all the subsets are [].
 *
 * Set = null, K = 0, all the subsets are [].
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIK {

    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] input = set.toCharArray();
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();
        dfs(k, 0, input, sb, result);
        return result;
    }

    private void dfs(int k, int start, char[] input, StringBuilder sb, List<String> result) {
        int sbLen = sb.length();

        // base case
        if (sbLen == k) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < input.length; i++) {
            sb.append(input[i]);
            dfs(k, i + 1, input, sb, result);
            sb.setLength(sbLen);

            while (i + 1 < input.length && input[i + 1] == input[i]) {
                i++;
            }
        }
    }
}
