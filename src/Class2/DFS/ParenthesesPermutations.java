package Class2.DFS;

import java.util.*;

public class ParenthesesPermutations {
    // n stores the total number of "pairs of () " need to add, so total levels == 2 * n
    // left stores the number of left parenthesis "(" added so far
    // right stores the number of right parenthesis ")" added so far
    // prefix: solution so far

    public List<String> validParentheses(int n) {

        List<String> list = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        helper(n, 0, 0, prefix, list);
        return list;
    }

    private void helper(int pairs, int left, int right, StringBuilder prefix, List<String> list) {
        if (right == pairs) {
            list.add(prefix.toString());
            return;
        }

        // case 1: add "(" at this level
        if (left < pairs) {
            prefix.append("(");
            helper(pairs, left + 1, right, prefix, list);
            prefix.deleteCharAt(prefix.length() - 1);
        }

        // case 2: add ")" at this level
        if (left > right) {
            prefix.append(")");
            helper(pairs, left, right + 1, prefix, list);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        ParenthesesPermutations solution = new ParenthesesPermutations();
        int n = 3;
        List<String> result = solution.validParentheses(n);
        System.out.println(result);
    }
}
// TC: 2 ^ 2n * n -- time for .toString
// SC: 2n