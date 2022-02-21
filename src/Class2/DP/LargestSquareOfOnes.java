/** hard
 * Laicode 101. Largest Square Of 1s
 *
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
 *
 * Assumptions
 *
 * The given matrix is not null and guaranteed to be of size N * N, N >= 0
 * Examples
 *
 * { {0, 0, 0, 0},
 *
 *   {1, 1, 1, 1},
 *
 *   {0, 1, 1, 1},
 *
 *   {1, 0, 1, 1}}
 *
 * the largest square of 1s has length of 2
 *
 *
 */

package Class2.DP;

public class LargestSquareOfOnes {

    public int largest(int[][] matrix) {

        // base case:
        // sq[i][0] = matrix[i][0]
        // sq[0][j] = matrix[0][j]
        // induction rule:
        // if (matrix[i][j] == 1)
        //     sq[i][j] = min(sq[i - 1][j], sq[i][j - 1], sq[i - 1][j - 1]) + 1
        // else sq[i][j] = 0 default

        int len = matrix.length;
        int[][] sq = new int[len][len];
        int sqMax = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 0 || j == 0) {
                    sq[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    sq[i][j] = Math.min(sq[i - 1][j - 1], Math.min(sq[i - 1][j], sq[i][j - 1])) + 1;
                }
                sqMax = Math.max(sqMax, sq[i][j]);
            }
        }
        return sqMax;
    }

    public static void main(String[] args) {
        LargestSquareOfOnes obj = new LargestSquareOfOnes();

        int[][] matrix = {{0,0,0,0},{1,1,1,1},{0,1,1,1},{1,0,1,1}};
        System.out.println(obj.largest(matrix));
    }

}

// TC O(n ^ 2)
// SC O(n ^ 2)
