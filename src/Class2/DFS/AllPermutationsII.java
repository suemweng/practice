/**
 * Laicode 65. All Permutations II
 *
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "aba", all permutations are ["aab", "aba", "baa"]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

package Class2.DFS;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class AllPermutationsII {

    public List<String> permutations(String input) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        // corner case
        if (input == null) {
            return result;
        }

        // call helper function
        char[] array = input.toCharArray();
        helper(0, array, result);

        // return list
        return result;
    }

    private void helper(int index, char[] array, List<String> result) {
        // base case
        // index == n - 1, no more option
        if (index == array.length) {
            result.add(new String(array));
            return;                             // error: forgot to return, bad habit
        }

        // sub-problem
        // for loop of all the possibility
        // use a set to cut the duplicate branches
        Set<Character> existed = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!existed.contains(array[i])){
                existed.add(array[i]);
                swap(array, index, i);
                helper(index + 1, array, result);
                swap(array, index, i);
            }

        }
    }


    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsII obj = new AllPermutationsII();

        String input = "";
        System.out.println(obj.permutations(input));
    }
}

// TC: O(n! * n) -- set.add() O(n)
// SC: O(n ^ 2)  -- new a set on each level
