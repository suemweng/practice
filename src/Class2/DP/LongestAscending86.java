/*
Q 86. Longest Ascending SubArray
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.

 */

package Class2.DP;

public class LongestAscending86 {

    public int longest(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length ==0) return 0;
        if (array.length == 1) return 1;

        int i = 1;
        int max = 0;
        int count = 1;

        while (i < array.length) {
            if ( array[i - 1] < array[i]) {
                count++;
                if (count > max) max = count;
            }
            else {
                count = 1;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args){
        LongestAscending86 solution = new LongestAscending86();
        int[] array = {455,1011};
        int max = solution.longest(array);
        System.out.println(max);

    }
}
