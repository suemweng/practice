package Class1Beginner.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        // corner case
        if (array == null || array.length == 0) return;

        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) minIndex = j;
            }
            swap(array,i,minIndex);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {-1, -3, 7, 5};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

}

// TC : O(n^2)
// SC : O(1)