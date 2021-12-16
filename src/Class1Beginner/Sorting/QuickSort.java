package Class1Beginner.Sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private Random random = new Random();

    public void quickSort(int[] array) {
        // corner case
        if (array == null || array.length == 0) return;

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        // base case
        if (left >= right) return;

        // choose a random pivot
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(array, pivotIndex,right);
        // partition
        int i = left; // left border of range to be partition
        int j = right - 1; // right border of range to be partition
        while (i <= j) {
            if (array[i] < array[right]) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        // swap
        swap(array, i, right);

        // recursive rule
        quickSort(array,left,i - 1);
        quickSort(array,i + 1, right);

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] arr = {1,9,3,8,5};
        solution.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
