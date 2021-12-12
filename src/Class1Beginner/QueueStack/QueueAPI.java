package Class1Beginner.QueueStack;

import java.util.*;

public class QueueAPI {

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        // Throw Exceptions
        queue.add(1);
        int elementValue = queue.element();
        int removeValue = queue.remove();
        System.out.println("--- Throw Exceptions APIs ---");
        System.out.println("elementValue is: " + elementValue);
        System.out.println("removeValue is: " + removeValue);

        queue.offer(2);
        int peekValue = queue.peek();
        int pollValue = queue.poll();
        System.out.println("--- Return Special Value APIs ---");
        System.out.println("peekValue is: " + peekValue);
        System.out.println("pollValue is: " + pollValue);

        // Equivalent Deque Methods APIs
        // Throw Exceptions
        queue.addLast(3);
        int getFirstValue = queue.getFirst();
        int removeFirstValue = queue.removeFirst();
        System.out.println("*** Equivalent Deque Methods APIs ***");
        System.out.println("--- Throw Exceptions APIs ---");
        System.out.println("getFirstValue is: " + getFirstValue);
        System.out.println("removeFirstValue is: " + removeFirstValue);

        // Return Special Value APIs
        queue.offerLast(4);
        int peekFirstValue = queue.peekFirst();
        int pollFirstValue = queue.pollFirst();
        System.out.println("--- Return Special Value APIs ---");
        System.out.println("peekFirstValue is: " + peekFirstValue);
        System.out.println("pollFirstValue is: " + pollFirstValue);

    }
}
