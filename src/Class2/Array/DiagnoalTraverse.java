/**
 * Leetcode 498. Diagonal Traverse
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */

package Class2.Array;

import java.util.Arrays;

public class DiagnoalTraverse {

    // Key insight:
    // x + y = sum
    // boundary of x

    public int[] findDiagonalOrder(int[][] matrix) {
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows * cols];
        int index = 0;
        int sum = 0;

        while (sum <= rows + cols - 2) {
            int top = Math.max(0, sum - cols + 1); // y = max, x = sum - cols + 1
            int bottom = Math.min(rows - 1, sum); // y = 0, x = sum

            if (sum % 2 == 0) {
                for (int x = bottom; x >= top; x--) {
                    result[index++] = matrix[x][sum - x];
                }

            } else {  // sum % 2 == 1
                for (int x = top; x <= bottom; x++) {
                    result[index++] = matrix[x][sum - x];
                }

            }
            sum++;
        }
        return result;
    }

    public static void main(String[] args) {
        DiagnoalTraverse obj = new DiagnoalTraverse();

        int[][] matrix = {{1,2},{3,4},{5,6}};
        int[] result = obj.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
