/**
 * Laicode 66. All Valid Permutations Of Parentheses I
 *
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 *
 * Assumptions
 *
 * N > 0
 * Examples
 *
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */

package Class2.DFS;

import java.util.*;

public class ParenthesesPermutations {
    // n stores the total number of "pairs of () " need to add, so total levels == 2 * n
    // left: the number of left parenthesis "(" added so far
    // right: the number of right parenthesis ")" added so far
    // index: the current position in array we want to fill in with either '(' or ')'

    public List<String> validParentheses(int n) {

        List<String> list = new ArrayList<>();
        // the final string contains 2n characters
        char[] array = new char[n * 2];

        helper(array, 0, 0, 0, list);
        return list;
    }

    private void helper(char[] array, int index, int left, int right, List<String> list) {
        if (index == array.length - 1) {
            array[index] = ')';
            list.add(new String(array));
            return;
        }

        // case 1: add "(" at this level
        if (left < array.length / 2) {
            array[index] = '(';
            helper(array, index + 1, left + 1, right, list);
        }

        // case 2: add ")" at this level
        if (left > right) {
            array[index] = ')';
            helper(array, index + 1, left, right + 1, list);
        }
    }

    public static void main(String[] args) {
        ParenthesesPermutations solution = new ParenthesesPermutations();
        int n = 3;
        List<String> result = solution.validParentheses(n);
        System.out.println(result);
    }
}
// TC: O(2 ^ 2n)
// SC: O(2n)  -- call stack and array