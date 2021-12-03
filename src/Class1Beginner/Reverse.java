/*  542. Reverse an array

Given an array, reverse all its elements.


Example:
array = [2, 3, 5, 7, 11]
result: [11, 7, 5, 3, 2]
Assumption: The array is not null or empty.



 */

import java.util.Arrays;


public class Reverse {

    public static void reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }
    }

    public static void main(String[] args) {

        int[] arr = {123,1,3123,1023,344,31};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

}
