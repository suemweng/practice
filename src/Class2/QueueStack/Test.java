package Class2.QueueStack;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }

        System.out.println(queue.peek());
        System.out.println(queue.poll());


        //Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);
        // 3 2 1 4 5 6
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                System.out.println(deque.peekFirst());
                System.out.println(deque.pollFirst());
            } else {
                System.out.println(deque.peekLast());
                System.out.println(deque.pollLast());
            }

        }
        System.out.println(deque.peekFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollLast());

        //Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);
        while(!stack.isEmpty()) {
            System.out.println(stack.peekFirst());
            System.out.println(stack.pollFirst());
        }
        System.out.println(stack.peekFirst());
        System.out.println(stack.pollFirst());

        MyStack stack1 = new MyStack();
        stack1.push(1);
        System.out.println(stack1.peek());
    }
}
