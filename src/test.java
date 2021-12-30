
import java.util.*;
import java.lang.Math;


class Test {


    public static void main(String[] args) {
        Test solution = new Test();
        Dictionary<Integer,Integer> dict = new Hashtable<Integer,Integer>();
        dict.put(0,1);
        dict.put(1,3);
        dict.put(2,4);
        dict.put(3,4);
        dict.put(4,6);
        dict.put(5,10);
        dict.put(6,11);
        dict.put(7,12);
        dict.put(8,15);
        dict.put(9,15);

        int T = 6;
        int i = solution.search(dict, T);
        System.out.println(i);
    }

    public int search(Dictionary dict, int target) {
        // Write your solution here
        // corner case
        if(dict == null) return -1;

        // jump out
        int right = 1;
        while (dict.get(right) != null && (int)dict.get(right) < target) {
            right *= 10;
        }

        //jump in
        int left = right / 10;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null) {
                right = mid - 1;
            } else if ((int)dict.get(mid) == target) {
                return mid;
            } else if ((int)dict.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;


    }



}

class Student {
    String name;
    int age;
    private double gpa;
    boolean enrolled;
}