
import java.util.*;
import java.lang.Math;


class Test {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(0);
        System.out.println(sb);
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