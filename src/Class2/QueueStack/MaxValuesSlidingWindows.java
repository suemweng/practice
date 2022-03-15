/**
 * Laicode 204. Maximum Values Of Size K Sliding Windows
 *
 * Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.
 *
 * Assumptions
 *
 * The given array is not null and is not empty
 * K >= 1, K <= A.length
 * Examples
 *
 * A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},
 *
 * and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
 */

package Class2.QueueStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxValuesSlidingWindows {

    // Key insight:
    // Descending Deque maintains current max and max-to-be
    // store index, instead of value

    // TC: O(n)
    // SC: O(n)

    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // i points to the new element
        for (int i = 0; i < array.length; i++) {
            // current value 又新又大
            while (!maxDeque.isEmpty() && array[maxDeque.peekLast()] <= array[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(i);

            if (maxDeque.peekFirst() <= i - k){
                maxDeque.pollFirst();
            }

            if (i >= k - 1) {
                result.add(array[maxDeque.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxValuesSlidingWindows obj = new MaxValuesSlidingWindows();

        int[] array = {1, 2, 3, 2, 4, 2, 1};
        int k = 3;
        System.out.println(obj.maxWindows(array, k));

    }
}
