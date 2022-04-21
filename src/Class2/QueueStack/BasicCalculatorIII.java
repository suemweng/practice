/**
 * Leetcode 772. Basic Calculator III
 *
 * Description
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators, open ( and closing parentheses ) and empty spaces ` `. The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 *
 * Some examples:
 *
 * "1 + 1" = 2
 *
 * " 6-4 / 2 " = 4
 *
 * "2*(5+5*2)/3+(6/2+8)" = 21
 *
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * Note: Do not use the eval built-in library function.
 */

package Class2.QueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorIII {

    // Key insight:
    // use recursion for ()
    // only calculate * /
    // push +, - as number

    public int calculate(String s) {

        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] i = new int[1];
        return dfs(s, i);
    }


    private int dfs(String s, int[] i){
        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0;
        char op = '+';
        for (; i[0] < s.length(); i[0]++) {
            char ch = s.charAt(i[0]);

            if (ch == '(') {
                i[0]++;
                num = dfs(s, i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }


            if (!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                num = 0;
                op = ch;
            }

            if(ch == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        BasicCalculatorIII obj = new BasicCalculatorIII();

        String s = "(1 + 3) * ( 4 - 1)";
        System.out.println(obj.calculate(s));
    }
}
