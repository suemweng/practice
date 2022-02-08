/**
 * Laicode 122. Spiral Order Traverse II
 *
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 *
 * Assumptions
 *
 * The 2D array is not null and has size of M * N where M, N >= 0
 * Examples
 *
 * { {1,  2,  3,  4},
 *
 *   {5,  6,  7,  8},
 *
 *   {9, 10, 11, 12} }
 *
 * the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */

package Class2.Recursion;

import java.util.List;
import java.util.ArrayList;

public class SpiralOrderTraverseII {

    public List<Integer> spiral(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        spiralHelper(matrix, 0, result);
        return result;
    }

    private void spiralHelper(int[][] matrix, int offset, List<Integer> result) {
        int rowSize = matrix.length - offset * 2;
        int colSize = matrix[0].length - offset * 2;

        if (rowSize == 0 || colSize == 0) {
            return;
        }

        if (rowSize == 1) {
            for (int i = 0; i < colSize; i++) {
                result.add(matrix[offset][offset + i]);
            }
            return;
        }

        if (colSize == 1) {
            for (int i = 0; i < rowSize; i++) {
                result.add(matrix[offset + i][offset]);
            }
            return;
        }

        for (int i = 0; i < colSize - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }

        for (int i = 0; i < rowSize - 1; i++) {
            result.add(matrix[offset + i][offset + colSize - 1]);
        }

        for (int i = colSize - 1; i > 0; i--) {
            result.add(matrix[offset + rowSize - 1][offset + i]);
        }

        for (int i = rowSize - 1; i > 0; i--) {
            result.add(matrix[offset + i][offset]);
        }

        spiralHelper(matrix, offset + 1, result);

    }

    public static void main(String[] args) {
        SpiralOrderTraverseII obj = new SpiralOrderTraverseII();

        int[][] matrix = { {1,  2,  3,  4},{5,  6,  7,  8}, {9, 10, 11, 12} };
        List<Integer> result = obj.spiral(matrix);
        System.out.println(result);
    }
}

// TC: O(M * N)
// SC: O(min(M, N))