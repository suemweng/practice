package Class2.DFS;

import java.util.*;

public class CoinsCombinations {

    public List<List<Integer>> combinations(int target, int[] coins) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (coins == null || coins.length == 0) {
            return list;
        }
        List<Integer> solution = new ArrayList<>();
        combinations(target, coins, 0, solution, list);
        return list;
    }

    private void combinations(int moneyLeft, int[] coins, int index, List<Integer> solution,
                              List<List<Integer>> list) {
        // base case
        if (index == coins.length  - 1) {
            if (moneyLeft % coins[index] == 0) {
                solution.add (moneyLeft / coins[index]);
                list.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }

        for (int i = 0; i <= moneyLeft / coins[index]; i++) {
            solution.add(i);
            combinations(moneyLeft - i * coins[index], coins, index + 1, solution ,list);
            solution.remove(solution.size() - 1);
        }
    }

    public static void  main(String[] args) {
        CoinsCombinations solution = new CoinsCombinations();

        int[] coins = {25,10,5};
        int target = 30;
        List<List<Integer>> result = solution.combinations(target, coins);
        System.out.println(result);
    }

}
// TC: target ^ n
// SC: n