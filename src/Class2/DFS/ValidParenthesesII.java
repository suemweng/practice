package Class2.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParenthesesII {

    // TC: O(2n ^ 2m) -- n types, m pairs
    // SC: O(2m)

    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        char[] pairs = {'(',')','<','>','{','}'};
        int[] remain = {l,l,m,m,n,n};
        char[] cur = new char[(l + m + n) * 2];
        Deque<Character> stack = new ArrayDeque<>();
        findPermutation(0, cur, pairs, remain, result, stack);
        return result;
    }

    private void findPermutation(int index, char[] cur, char[] pairs, int[] remain, List<String> result, Deque<Character> stack) {
        // base case
        if (index == cur.length) {
            result.add(new String(cur));
            return;
        }

        for (int i = 0; i < pairs.length; i++) {
            if (i % 2 == 0) { // left brackets
                if (remain[i] > 0) {
                    stack.offerFirst(pairs[i]);
                    remain[i]--;
                    cur[index] = pairs[i];

                    findPermutation(index + 1, cur, pairs, remain, result, stack);

                    stack.pollFirst();
                    remain[i]++;

                }
            } else { // right brackets
                if (!stack.isEmpty() && stack.peek() == pairs[i - 1]) {
                    stack.pollFirst();
                    remain[i]--;
                    cur[index] = pairs[i];

                    findPermutation(index + 1, cur, pairs, remain, result, stack);

                    stack.offerFirst(pairs[i - 1]);
                    remain[i]++;
                }

            }
        }
    }

    public static void main(String[] args) {
        ValidParenthesesII obj = new ValidParenthesesII();

        System.out.println(obj.validParentheses(1,1,0));
    }
}
