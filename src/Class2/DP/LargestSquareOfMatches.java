/**
 * Laicode 638. Largest Square Of Matches
 *
 * Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.
 * The input is a matrix of points. Each point has one of the following values:
 * 0 - there is no match to its right or bottom.
 * 1 - there is a match to its right.
 * 2 - there is a match to its bottom.
 * 3 - there is a match to its right, and a match to its bottom.
 *
 *
 * Assumptions
 * The given matrix is guaranteed to be of size M * N, where M, N >= 0
 *
 *
 * Examples
 * {{3, 1, 1, 3, 0, 1, 1, 0},
 *  {2, 0, 0, 2, 0, 0, 0, 0},
 *  {3, 1, 3, 0, 0, 0, 0, 0},
 *  {2, 0, 2, 0, 0, 0, 0, 0},
 *  {1, 1, 0, 0, 0, 0, 0, 0}}
 *
 *
 * This matrix represents the following bunch of matches:
 *
 * The largest square has length of 2.
 */

package Class2.DP;

public class LargestSquareOfMatches {

    public int largestSquareOfMatches(int[][] matrix) {
        // key insight
        // 2D DP, starting from bottom right corner

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] right = new int[rows + 1][cols + 1];
        int[][] down = new int[rows + 1][cols + 1];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >=0; j--) {

                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                }

                if (matrix[i][j] == 2) {
                    down[i][j] = down[i + 1][j] + 1;
                }

                if (matrix[i][j] == 3) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;


                    for (int length = Math.min(right[i][j], down[i][j]); length >= 1; length--) {
                        if (down[i][j + length] >= length && right[i + length][j] >= length) {
                            result = Math.max(result, length);
                            break;
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSquareOfMatches obj = new LargestSquareOfMatches();

        int[][] matrix = {{3, 1, 1, 3, 0, 1, 1, 0},{2, 0, 0, 2, 0, 0, 0, 0}, {3, 1, 3, 0, 0, 0, 0, 0}, {2, 0, 2, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(obj.largestSquareOfMatches(matrix));
    }
}
