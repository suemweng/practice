/**
 * Laicode 233. N Queens
 *
 *
 */

package Class2.Recursion;

import java.util.List;
import java.util.ArrayList;

public class NQueens {

    public List<List<Integer>> nQueens(int n) {
        // Write your solution here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        nQueensHelper(0, n, curList, list);
        return list;
    }

    private void nQueensHelper(int index, int n, List<Integer> curList, List<List<Integer>> list) {
        // base case
        if (index == n) {
            list.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (validCheck(i, curList)) {
                curList.add(i);
                nQueensHelper(index + 1, n, curList, list);
                curList.remove(Integer.valueOf(i));
            }
        }
    }

    private boolean validCheck(int i, List<Integer> curList) {
        // check col
        if (curList.contains(i)) {
            return false;
        }

        // check diagonals
        int diff = i - curList.size();
        int sum = i + curList.size();
        for (int j = 0; j < curList.size(); j++) {
            int val = curList.get(j);
            if (val - j == diff || val + j == sum) {
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
