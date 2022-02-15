/**
 * Laicode 643. All Permutations of Subsets
 *
 * Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.
 *
 *
 * Examples
 * Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].
 * Set = “”, all permutations are [“”].
 * Set = null, all permutations are [].
 */

package Class2.DFS;

import java.util.List;
import java.util.ArrayList;

public class AllPermutationsOfSubsets {

    public List<String> allPermutationsOfSubsets(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }


        char[] array = set.toCharArray();
        helper(0, array, result);
        return result;
    }

    private void helper(int index, char[] array, List<String> result) {

        // base case
        result.add(new String(array, 0, index));

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(index + 1, array, result);
            swap(array, index, i);
        }

    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        AllPermutationsOfSubsets obj = new AllPermutationsOfSubsets();
        String input = "abc";
        List<String> result = obj.allPermutationsOfSubsets(input);
        System.out.println(result);
    }
}
// TC: O(n!)
// SC: O(n)