package Class2.DFS;

import java.util.*;

public class CoinsCombinations {

    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> coinsList = new ArrayList<Integer>();
        helper(target, coins, 0, list, coinsList);
        return list;
    }

    private void helper(int moneyLeft, int[] coins, int index, List<List<Integer>> list,
                        List<Integer> coinsList) {
        // base case
        if (index == coins.length) {
            if (moneyLeft == 0) {
                list.add(new ArrayList<Integer>(coinsList));
            }
            return;
        }

        // recursive
        for (int i = 0; i < moneyLeft / coins[index] + 1; i++) {
            coinsList.add(i);
            helper(moneyLeft - i * coins[index], coins, index + 1, list, coinsList);
            coinsList.remove(index);
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