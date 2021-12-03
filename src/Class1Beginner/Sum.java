/*  540. Compute Sum

Given an array, return sum of all elements.


Example:
array = [7, 3, 2], return 12


Note: if the array is null or empty, return 0.


 */

public class Sum {
    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {432,186,275,662,711,502,770};
        int sum = sum(arr);
        System.out.println(sum);
    }



}