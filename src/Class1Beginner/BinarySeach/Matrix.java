/**
 *  Search in sorted matrix, each row of the matrix is sorted in ascending order,
 *  and the first element of the row is equals to or larger than the last element
 *  of the previous row.
 *
 *  Return the position if the target is found, otherwise return {-1, -1};
 */

package Class1Beginner.BinarySeach;
import java.util.Arrays;

public class Matrix {
    // Assumption: the matrix is not null, and has size N * M where N >= 0 and M >= 0.
    // return {-1, -1} if not found.
    // convert the 2D array to 1D array and do binary search

    public static int[] findTarget(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return new int[]{-1,-1};
        }

        int row = arr.length;
        int col = arr[0].length;
        int left = 0;
        // convert the 2D array to 1D array with rows * cols elements
        int right = row * col - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // convert the position in 1D back to row and col to 2Da array;
            int r = mid / col;
            int c = mid % col;
            if (arr[r][c] == target) {
                return new int[]{r,c};
            } else if (arr[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,7},{8,9,10}};
        int target = 10;
        int[] index = findTarget(array,target);
        System.out.println(Arrays.toString(index));

    }
}

// TC: O(log (m * n))
// SC: O(1)