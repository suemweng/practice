package Class2.QueueStack;

import java.util.*;

public class PQTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(4);
        minHeap.offer(3);
        minHeap.offer(2);
        minHeap.offer(1);
        System.out.println("minHeap values: ");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        minHeap.offer(4);
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(3);
        minHeap.offer(1);
        System.out.println("poll a element: ");
        System.out.println(minHeap.poll());
        System.out.println("minHeap values after calling poll: ");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        minHeap.offer(4);
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(3);
        minHeap.offer(1);
        System.out.println("call remove");
        System.out.println(minHeap.remove());
        System.out.println("minHeap values after calling remove: ");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        minHeap.offer(4);
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(3);
        minHeap.offer(1);
        System.out.println("call remove a exist element: ");
        System.out.println(minHeap.remove(5));
        System.out.println("minHeap values after calling remove a exist element: ");
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        Integer one = 1;
        Integer two = 2;
        System.out.println(one.compareTo(two));

        PriorityQueue<MyInteger> myMaxHeap = new PriorityQueue<MyInteger>(new MyInteger.MyComparator());
        MyInteger myOne = new MyInteger(1);
        MyInteger myTwo = new MyInteger(2);
        myMaxHeap.offer(myOne);
        myMaxHeap.offer(myTwo);
        System.out.println(myOne.compareTo(myTwo)); // Natural Ordering
        System.out.println(myMaxHeap.peek().value);


        MyInteger.MyComparator maxComp = new MyInteger.MyComparator();
        int result = maxComp.compare(myOne,myTwo);
        System.out.println("maxComparator: " + result);

        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(myOne);
        maxHeap.offer(myTwo);
        System.out.println("maxHeap: " + maxHeap.peek().value);
    }
}
