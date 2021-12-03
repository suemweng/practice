/* 539. Find Minimum

Given an array, return its minimum value


Example:
array = [7, 3, 2], return 2

[5730,5614,5610,5380,5140,9431,1825,7166,4453,5782,1669,3921,3782,2477,4194,5405]

Note: if the array is null or empty, return 0.

 */


public class Minimum {

    public static int minimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int min = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {5730,5614,5610,5380,5140,9431,1825,7166,4453,5782,1669,3921,3782,2477,4194,5405};
        int min = minimum(array);
        System.out.println(min);
    }

}
