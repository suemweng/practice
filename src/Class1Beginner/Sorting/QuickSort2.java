package Class1Beginner.Sorting;

// improved by applying rainbow sort to deal with lots of duplicate situation

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    public void quickSort2(int[] array) {
        // corner case -- check null first
        if (array == null || array.length == 0) return;

        quickSort2(array,0,array.length - 1);

    }

    private void quickSort2(int[] array, int left, int right) {
        // base case
        if (left >= right) return;

        // define a pivot and use the pivot to partition the array
        // pivot is already at its position, when we do our recursive call on the two partitions
        // pivot should not be included in any of them
        // this is one of the ways to define the pivot, pick random element in the range of [left, right]
        int pivotIndex = left + (int) Math.random() * (right - left + 1);
        int pivotValue = array[pivotIndex];


        // partition with rainbow sort
        int i = left; // head of group, equal to pivotValue
        int j = left; // head of range to be partitioned
        int k = right; // end of range to be partitioned

        while (j <= k) {
            if (array[j] == pivotValue) {
                j++;
            } else if (array[j] < pivotValue) {
                swap(array, i, j);
                i++;
                j++;
            } else {  // array[j] > pivotValue
                 swap(array, j, k);
                 k--;
            }
        }

        //recursive rule
        quickSort2(array,left,i - 1);
        quickSort2(array, j, right);

    }

    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort2 solution = new QuickSort2();
        int[] array = {1,4,5,3,6,4,2,4,9,4,3};
        solution.quickSort2(array);
        System.out.println(Arrays.toString(array));

    }
}
