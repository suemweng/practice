package Class2.QueueStack;

import java.util.Arrays;

public class Heapify {
    public int[] heapify(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i);
        }
        return array;
    }

    private void percolateDown(int[] array, int index) {
        while (index <= array.length / 2 - 1) {    // only goes down to the last parent node
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smaller = left;

            if (right < array.length && array[right] < array[left]) {
                smaller = right;
            }

            if (array[smaller] < array[index]) {
                swap(array, smaller, index);
                index = smaller;
            } else {
                break;
            }

        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Heapify solution = new Heapify();

        int[] array = {5,4, 3,2,1};
        int[] newArray = solution.heapify(array);
        System.out.println(Arrays.toString(newArray));
    }
}
