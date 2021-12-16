package Class1Beginner;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Wrapper Class
        // byte --> Byte
        // short --> Short
        // int --> Integer
        // long --> Long
        // float --> Float
        // double --> Double
        // char --> Character
        // boolean --> Boolean

        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(9);
        int element = newList.get(1);
        System.out.println(element);
        System.out.println(newList.get(0));
        System.out.println(newList.size());



    }


}
