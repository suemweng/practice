package Class2.QueueStack;

import java.util.*;

public class SortWithTwoStacks {

    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();

        while (!s1.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int count = 1;
            // count
            while (!s1.isEmpty()) {
                int value = s1.pop();
                s2.push(value);
                if (value == min) {
                    count++;
                } else if (value < min) {
                    min = value;
                    count = 1;
                }
            }
            //pop
            while (s2.peek() != null && s2.peek() >= min) {
                if (s2.peek() == min) {
                    s2.pop();
                } else {
                    s1.push(s2.pop());
                }
            }

            //save min as result

            while (count > 0) {
                s2.push(min);
                count--;
            }


        }


        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        SortWithTwoStacks solution = new SortWithTwoStacks();

        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(4);
        s1.push(1);
        s1.push(3);
        s1.push(2);
        s1.push(2);
        System.out.println(s1);

        solution.sort(s1);
        System.out.println(s1);
    }
}
