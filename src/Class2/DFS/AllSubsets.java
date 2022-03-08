/**
 * Laicode 62. All Subsets I
 *
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 *
 * Assumptions
 *
 * There are no duplicate characters in the original set.
 * ​Examples
 *
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */

package Class2.DFS;

import java.util.*;
public class AllSubsets {
    // Assumptions:
    // 1. There are no duplicate characters in the given string

    // TC O(2^n * n)  --  * n is the time of .toString()
    // Sc O(n) -- O(n) on heap and O(n) on call stack
    public List<String> subSets(String set) {

        List<String> list = new ArrayList<>();
        // corner case
        if (set == null) {
            return list;
        }


        char[] input = set.toCharArray();
        // record the current subset
        StringBuilder prefix = new StringBuilder();
        findSubsetII(input, 0, prefix, list);
        return list;
    }

    // at each level, decide the character on the position "index" to be picked or not
    private void findSubset(char[] input, int index, StringBuilder prefix, List<String> list) {
        // terminate condition:
        // when we finish determining all the characters picked or not
        // we have a complete subset

        // base cae
        if (index == input.length) {
            list.add(prefix.toString());
            return;
        }

        // 1. pick the character at index
        prefix.append(input[index]);
        findSubset(input, index + 1, prefix, list);
        // remember to remove the added character when back tracking to the previous level
        prefix.deleteCharAt(prefix.length() - 1);
        // 2. not pick the character at index
        findSubset(input, index + 1, prefix, list);

    }

    // Method 2: input[i]


    private void findSubsetII(char[] input, int start, StringBuilder prefix, List<String> result) {

        result.add(prefix.toString());

        // base case
        if (start == input.length) {
            return;
        }

        for (int i = start; i < input.length; i++) {
            prefix.append(input[i]);
            findSubsetII(input, i + 1, prefix, result);
            prefix.deleteCharAt(prefix.length() - 1);
        }

    }

    public static void main(String[] args) {
        AllSubsets solution = new AllSubsets();
        String set = "abc";
        List<String> result = solution.subSets(set);
        System.out.println(result);
    }
}
