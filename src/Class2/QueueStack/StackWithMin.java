/**
 * Laicode 32. Stack With min()
 *
 * Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
 *
 * push(int element) - push the element to top
 * pop() - return the top element and remove it, if the stack is empty, return -1
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 */

package Class2.QueueStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class StackWithMin {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    public StackWithMin() {
        stack = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        // when the popped value is the same as the top value of minSTack,
        // the value need to be popped from minStack as well
        int result = stack.pollFirst();     // mistake: using Integer and ==
        if (result == min.peekFirst()) {    //          if Integer, then equals()
            min.pollFirst();
        }
        return result;
    }

    public void push(int element) {
        stack.offerFirst(element);
        // when element <= current min value in stack
        // need to push the element to minStack
        if (min.isEmpty() || min.peekFirst() >= element) {
            min.offerFirst(element);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }

    public static void main(String[] args) {
        StackWithMin obj = new StackWithMin();

        obj.push(136);
        System.out.println(obj.min());
        obj.push(135);
        obj.push(139);
        System.out.println(obj.top());
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        System.out.println(obj.top());
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}
