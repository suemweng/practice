/**
 * Laicode 233. N Queens
 *
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 *
 * Assumptions
 *
 * N > 0
 * Return
 *
 * A list of ways of putting the N Queens
 * Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
 * Example
 *
 * N = 4, there are two ways of putting 4 queens:
 *
 * [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.
 *
 * [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
 */

package Class2.Recursion;

import java.util.List;
import java.util.ArrayList;

public class NQueens {

    // Method 1: validate the queen position in O(n) each time
    // TC: O(n! * n)
    // SC: O(n)
    public List<List<Integer>> nQueens(int n) {
        // Assumption: n > 0
        List<List<Integer>> list = new ArrayList<>();
        // cur will be a list of size n, and cur[i] is the column number
        // where the queen on row i positioned
        List<Integer> curList = new ArrayList<>();
        nQueensHelper(n, curList, list);
        return list;
    }

    // use cur.size() denotes index
    private void nQueensHelper(int n, List<Integer> curList, List<List<Integer>> list) {
        // base case
        // when all the rows we know where the queens are positioned
        if (curList.size() == n) {
            list.add(new ArrayList<>(curList));    // error: forgot to add and how to add
            return;
        }

        for (int i = 0; i < n; i++) {
            // check if putting a queen at column i at the current row is valid
            if (validCheck(i, curList)) {
                curList.add(i);
                nQueensHelper(n, curList, list);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean validCheck(int col, List<Integer> curList) {
        int row = curList.size();
        for (int i = 0; i < row; i++) {
            // same column || same diagonal -- distance of col same as distance of row
            if (curList.get(i) == col || Math.abs(curList.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();

        int n = 4;
        List<List<Integer>> list = obj.nQueens(n);
        System.out.println(list);
    }
}

// TC: O(n! * n)
// SC: O(n)
