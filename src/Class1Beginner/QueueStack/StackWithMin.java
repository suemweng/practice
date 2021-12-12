package Class1Beginner.QueueStack;

import java.util.*;

public class StackWithMin {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public StackWithMin() {
        // write your solution here
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        if (stack.peekFirst().equals(minStack.peekFirst())) minStack.pollFirst();
        return stack.pollFirst();

    }

    public void push(int element) {
        stack.offerFirst(element);
        if (minStack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
        ;  }

    public int top() {
        return stack.isEmpty()? -1 : stack.peekFirst();
    }

    public int min() {

        return minStack.isEmpty()? -1 : minStack.peekFirst();
    }

    public static void main(String[] args) {
        StackWithMin stack1 = new StackWithMin();
        stack1.push(136);
        stack1.push(135);
        stack1.pop();
        System.out.println(stack1.min());
    }
}

