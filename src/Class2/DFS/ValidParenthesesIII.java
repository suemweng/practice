/** medium
 * Laicode 642. All Valid Permutations Of Parentheses III
 *
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}, subject to the priority restriction: {} higher than <> higher than ().
 *
 *
 * Assumptions
 *     l, m, n >= 0
 *     l + m + n >= 0
 *
 *
 * Examples
 *     l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].
 *     l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].
 */

package Class2.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParenthesesIII {

    // TC : O(2n ^ 2m)  -- n type, m pairs
    // SC : O(2m)

    public List<String> validParenthesesIII(int l, int m, int n) {

        char[] pairs = {'(',')','<','>','{','}'};
        int[] remains = {l,l,m,m,n,n};
        char[] cur = new char[(l + m + n) * 2];
        List<String> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        findValidParentheses(pairs, remains, cur, 0, stack, result);
        return result;
    }

    private void findValidParentheses(char[] pairs, int[] remains, char[] cur, int index, Deque<Integer> stack, List<String> result) {
        // base case
        if (index == cur.length) {
            result.add(new String(cur));
            return;
        }

        // recursive rule on each level

        for (int i = 0; i < pairs.length; i++) {
            if (i % 2 == 0) { // left brackets
                if (remains[i] > 0 && (stack.isEmpty() || stack.peek() >= i)) {
                    stack.offerFirst(i);
                    remains[i]--;
                    cur[index] = pairs[i];

                    findValidParentheses(pairs, remains, cur, index + 1, stack, result);

                    stack.pollFirst();
                    remains[i]++;
                }
            } else { // right brackets
                if (!stack.isEmpty() && i == stack.peek() + 1) {
                    stack.pollFirst();
                    remains[i]--;
                    cur[index] = pairs[i];

                    findValidParentheses(pairs, remains, cur, index + 1, stack, result);

                    stack.offerFirst(i - 1);
                    remains[i]++;
                }

            }
        }
    }

    public static void main(String[] args) {
        ValidParenthesesIII obj = new ValidParenthesesIII();

        List<String> result = obj.validParenthesesIII(1,1,0);
        System.out.println(result);

    }
}
