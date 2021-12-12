package Class1Beginner.QueueStack;

import java.util.*;

public class QueueStack {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        int frontElement = queue.peek();
        int queueSize = queue.size();
        boolean isEmptyQueue = queue.isEmpty();
        System.out.println("Queue First:" + frontElement + " -- Size:" + queueSize + " -- Empty? " + isEmptyQueue);

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        int topElement = stack.peek();
        int stackSize = stack.size();
        boolean isEmptyStack = stack.isEmpty();
        System.out.println("Stack First:" + topElement + " -- Size:" + stackSize + " -- Empty? " + isEmptyStack);

    }
}
