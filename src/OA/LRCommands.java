package OA;

import java.util.ArrayDeque;
import java.util.Deque;

public class LRCommands {
    public String solution (String commands) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : commands.toCharArray()) {
            if (stack.isEmpty() || stack.peek() == ch) {
                stack.offerFirst(ch);
            } else {
                stack.pollFirst();
            }
        }


        return stack.isEmpty() ? "" : stack.peek().toString();
    }

    public static void main(String[] args) {
        LRCommands obj = new LRCommands();

        String commands = "RLLRLLLRRR";
        System.out.println(obj.solution(commands));
    }
}
