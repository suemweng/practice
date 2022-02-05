package Class2.String;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deduplicate {

    // Method 1: stack

    public String deduplicate(String input) {
        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;

        while (i < input.length()) {
            char cur = input.charAt(i);
            if (!stack.isEmpty() && cur == stack.peekFirst()) {
                while (i < input.length() && cur == input.charAt(i)) {
                    i++;
                }
                stack.pollFirst();
            } else {
                stack.offerFirst(cur);
                i++;
            }

        }

        char[] array = new char[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            array[j] = stack.pollFirst();
        }

        return new String(array);
    }


    // Method 2: pointers

    public String deduplicateInPlace(String input) {

        // corner case
        if (input == null || input.length() <= 1) {
            return input;
        }

        // try to convert string to char[] and do it in-place
        char[] array = input.toCharArray();

        // instead of using an extra stack explicitly, we can actually
        // reuse the left side of the original char[] as the "stack"
        // top: is where the top of the stack is
        int top = 0;

        for (int i = 1; i < array.length; i++) {
            // if the stack is empty (top == -1) or there is no duplicate chars
            // we are able to push the character into the stack
            if (top == -1 || array[i] != array[top]) {
                array[++top] = array[i];
            } else  {
                // otherwise, we need to pop the top by top--
                // and ignore all the consecutive duplicate characters
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
                top--;
            }
        }

        return new String(array, 0, top + 1);
    }

    public static void main(String[] args) {
        Deduplicate obj = new Deduplicate();

        String input = "aabccdc";
        String result = obj.deduplicateInPlace(input);
        System.out.println(result);

    }
}
