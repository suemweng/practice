package Class2.DFS;

import java.util.*;

public class ParenthesesPermutations {

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

        if (left < pairs) {
            prefix.append("(");
            helper(pairs, left + 1, right, prefix, list);
            prefix.deleteCharAt(prefix.length() - 1);
        }
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
// TC: 2 ^ 2n
// SC: 2n