/**
 * Laicode 637. Largest Square Surrounded By One
 *
 * Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
 *
 *
 * Assumptions
 * The given matrix is guaranteed to be of size M * N, where M, N >= 0
 *
 *
 * Examples
 * {{1, 0, 1, 1, 1},
 *  {1, 1, 1, 1, 1},
 *  {1, 1, 0, 1, 0},
 *  {1, 1, 1, 1, 1},
 *  {1, 1, 1, 0, 0}}
 *
 *
 * The largest square surrounded by 1s has length of 3.
 */

package Class2.DP;

public class LargestSquareSurroundedOne {

    // Key insight:
    // build two prefixSum[][] of two directions

    // TC: O(M * N * min(M, N))
    // SC: O(M * N)

    public int largestSquareSurroundedByOne(int[][] matrix) {

        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] up = new int[rows + 1][cols + 1];
        int[][] left = new int[rows + 1][cols + 1];
        int result = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                    left[i + 1][j + 1] = left[i + 1][j] + 1;

                    for (int maxLen = Math.min(up[i + 1][j + 1], left[i + 1][j + 1]); maxLen >= 1; maxLen--) {
                        if (left[i - maxLen + 2][j + 1] >= maxLen && up[i + 1][j - maxLen + 2] >= maxLen) {
                            result = Math.max(result, maxLen);
                            break;
                        }
                    }
                }
            }
        }
        return result;

    }
}
