package Class2.QueueStack;

import java.util.*;

public class KthSmallest {

    // minHeap
    // TC: O(nlogn + klogn)
    // SC: O(n)
    public int[] kthSmallestMin(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // maxHeap
    // TC: klogk + (n-k)logk + klogk
    // SC: O(k)

    public int[] kthSmallestMax(int[] array, int k) {

        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }

        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;

    }

    // Quick Select
    // TC: Best O(n) Worst O(n^2)
    // SC: O(logn)

    public int[] kthSmallestQS(int[] array, int k) {
        // Write your solution here
        // corner case
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }

        quickSelect(array, 0, array.length - 1, k - 1);
        int[] result = new int[k];
        result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    // return k smallest element, unsorted
    private void quickSelect(int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);

        if (mid == target) {
            return;
        } else if (target < mid) {
            quickSelect(array, left, mid - 1, target);
        } else {
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotValue = array[right];

        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivotValue) {
                i++;
            } else if (array[j] >= pivotValue) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        KthSmallest solution = new KthSmallest();
        int[] array = {3,4,1,2,5};
        int k = 3;
        array = solution.kthSmallestQS(array, k);
        System.out.println(Arrays.toString(array));
    }
}
