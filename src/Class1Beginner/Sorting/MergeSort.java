package Class1Beginner.Sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        // corner case
        if (array == null || array.length == 0) return array;

        return mergeSort(array,0,array.length - 1);

    }

    private static int[] mergeSort(int[] array, int left, int right) {
        // base case
        if (left == right) return new int[]{array[left]};

        // sub-problem
        int mid = left + (right - left) / 2;
        int[] arrayLeft = mergeSort(array, left, mid);
        int[] arrayRight = mergeSort(array, mid + 1, right);


        // recursion rule

        return merge(arrayLeft, arrayRight);

    }

    private static int[] merge(int[] arrA, int[] arrB) {
        int[] newArray = new int[arrA.length + arrB.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arrA.length && j < arrB.length) {
            if (arrA[i] < arrB[j]) {
                newArray[k] = arrA[i];
                i++;
            } else {
                newArray[k] = arrB[j];
                j++;
            }
            k++;
        }

        while (i < arrA.length) {
            newArray[k] = arrA[i];
            i++;
            k++;
        }

        while (j < arrB.length) {
            newArray[k] = arrB[j];
            j++;
            k++;
        }

        return newArray;

    }

    public static void main(String[] args) {
        int[] array = {5,2,7,4,1,3,8,6};
        int[] sortedArray = mergeSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
