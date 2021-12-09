
import java.util.*;
import java.lang.Math;


class Test {


    public static void main(String[] args) {

        int[] numbers = {1,4};

        int target = 2;
        System.out.println(binarySearch(numbers, target));
    }

    public static int binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else {
                if (numbers[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            // check if left/right are neighbouring
            if (right - left == 1) {
                if (numbers[right] - target < target - numbers[left]) {
                    return right;
                } else {
                    return left;
                }
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