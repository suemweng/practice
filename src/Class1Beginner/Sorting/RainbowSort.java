package Class1Beginner.Sorting;

import java.util.Arrays;

public class RainbowSort {

    public void rainbowSort(int[] array, int target) {
        if (array == null || array.length == 0 ) return;

        int i = 0; // to divide group 1 & 2
        int j = 0; // head of range to be sorted
        int k = array.length - 1; // end of range to be sorted;
        while ( j <= k) {
            if (array[j] < target) {
                swap(array,i,j);
                i++;
                j++;
            } else if (array[j] == target) {
                j++;

            } else {  // array[j] > target
                swap(array,j,k);
                k--;
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        RainbowSort solution = new RainbowSort();
        int[] array = { 1,3,2,2,3,1,1};
        int target = 2;
        solution.rainbowSort(array, 2);
        System.out.println(Arrays.toString(array));

    }
}
