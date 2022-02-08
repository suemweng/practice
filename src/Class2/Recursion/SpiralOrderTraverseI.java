/**
 * Laicode 121. Spiral Order Traverse I
 *
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 *
 * Assumptions
 *
 * The 2D array is not null and has size of N * N where N >= 0
 * Examples
 *
 * { {1,  2,  3},
 *
 *   {4,  5,  6},
 *
 *   {7,  8,  9} }
 *
 * the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */

package Class2.Recursion;

import java.util.List;
import java.util.ArrayList;

public class SpiralOrderTraverseI {

    // Method 1: Recursive traversal
    // TC: O(n ^ 2)
    // SC: O(n)
    public List<Integer> spiral(int[][] matrix) {
        // Assumption: matrix is N * N, N >= 0, matrix is not null
        List<Integer> result = new ArrayList<>();
        // corner case
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        spiralHelper(matrix, 0, result);
        return result;
    }

    private void spiralHelper(int[][] matrix, int offset, List<Integer> result) {
        int size = matrix.length - 2 * offset;

        // base case
        // when there is only 1 or 0 element left
        if (size == 0) {
            return;
        }

        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }


        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][i + offset]);
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[i + offset][size - 1 + offset]);
        }

        for (int i = size - 1; i > 0; i--) {                    // error: i from 0 -- size - 2
            result.add(matrix[size - 1 + offset][i + offset]);
        }
        for (int i = size - 1; i > 0; i--) {
            result.add(matrix[i + offset][offset]);
        }

        spiralHelper(matrix, offset + 1, result);   // error: forgot going to next level
    }

    public static void main(String[] args) {
        SpiralOrderTraverseI obj = new SpiralOrderTraverseI();

        int[][] matrix = { {1,  2,  3}, {4,  5,  6}, {7,  8,  9} };
        List<Integer> result = obj.spiral(matrix);
        System.out.println(result);
    }
}

// TC: O(N * N)
// SC: O(N) -- call stack N/2