package Class2.LinkedList;

import java.util.*;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("size = " + list.size());
        System.out.println(list);

        list.add(1);
        System.out.print("size = " + list.size());
        System.out.println(list);

        list.add(2);
        System.out.print("size = " + list.size());
        System.out.println(list);

        list.add(1, 3);
        System.out.print("size = " + list.size());
        System.out.println(list);

        list.remove();
        System.out.print("size = " + list.size());
        System.out.println(list);

        int value = list.set(0, 1);
        System.out.print("size = " + list.size());
        System.out.println(list);

    }
}
