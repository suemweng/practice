/** hard
 * Laicode 106. Largest SubMatrix Sum
 *
 * Given a matrix that contains integers, find the submatrix with the largest sum.
 *
 * Return the sum of the submatrix.
 *
 * Assumptions
 *
 * The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
 * Examples
 *
 * { {1, -2, -1, 4},
 *
 *   {1, -1,  1, 1},
 *
 *   {0, -1, -1, 1},
 *
 *   {0,  0,  1, 1} }
 *
 * the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 */

package Class2.DP;

public class LargestSubMatrixSum {

    public int largest(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] PrefixSum = new int[rows][cols];
        int[] colSum = new int[cols];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    PrefixSum[i][j] = matrix[i][j];
                } else {
                    PrefixSum[i][j] = PrefixSum[i - 1][j] + matrix[i][j];
                }
            }
        }

        for (int top = 0; top < rows; top++) {
            for (int end = top; end < rows; end++) {
                int curMax = Integer.MIN_VALUE;
                for (int j = 0; j < cols; j++) {
                    colSum[j] = PrefixSum[end][j] - PrefixSum[top][j] + matrix[top][j];
                    curMax = Math.max(colSum[j], colSum[j] + curMax);
                    maxSum = Math.max(maxSum, curMax);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LargestSubMatrixSum obj = new LargestSubMatrixSum();
        int[][] matrix = {{1,-2,-1,4},{1,-1,1,1},{0,-1,-1,1},{0,0,1,1}};
        System.out.println(obj.largest(matrix));
    }
}
// TC: O(M * M * N) -- M is rows, N is cols
// SC: O(M * N)