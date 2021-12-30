package Class2.BinarySearch;

import java.util.*;

public class ClosestKOptimal {
    public int[] KClosest(int[] array, int target, int k) {
        // corner case
        if (array == null || array.length == 0) return array;

        // find the closest one
        int left = Closest(array, target);
        if (left == array.length - 1) left = left - k;
        else {
            int right = Math.min(left + 1, array.length - 1);
            int j = k;
            while (j > 1) {
                int L = left - j / 2;
                int R = right + j / 2;
                if (R <= array.length - 1 && L >= 0) {
                    if (Math.abs(array[L] - target) <= Math.abs(array[R] - target)) left = Math.max(L - 1, 0);
                    else right = Math.min(R + 1, array.length - 1);
                } else break;
                j = j / 2;
            }

            for (int i = 0; i < j; i++) {
                if (right > array.length - 1 || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target))
                    left--;
                else right++;

            }
        }

        int[] newArray = new int[k];
        for(int i = 0; i < k; i++) {
            newArray[i] = array[left + 1 + i];
        }
        return newArray;
    }

    public int Closest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {  // array[mid] > target
                right = mid;
            }
        }

        // post-processing
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) return left;
        else return right;
    }

    public static void main(String[] args) {
        ClosestKOptimal solution = new ClosestKOptimal();
        int[] array = {1,2,3};
        int target = 2;
        int k = 3;
        int[] newArray = solution.KClosest(array,target,k);
        System.out.println(Arrays.toString(newArray));
    }
}
