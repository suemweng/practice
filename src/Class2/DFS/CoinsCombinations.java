/**
 * LaiCode 73. Combinations Of Coins
 *
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.
 *
 * Arguments
 *
 * coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
 * target - a non-negative integer representing the target number of cents, eg. 99
 * Assumptions
 *
 * coins is not null and is not empty, all the numbers in coins are positive
 * target >= 0
 * You have infinite number of coins for each of the denominations, you can pick any number of the coins.
 * Return
 *
 * a list of ways of combinations of coins to sum up to be target.
 * each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
 * Examples
 *
 * coins = {2, 1}, target = 4, the return should be
 *
 * [
 *
 *   [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
 *
 *   [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
 *
 *   [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
 *
 * ]
 */
package Class2.DFS;

import java.util.*;

public class CoinsCombinations {

    public List<List<Integer>> combinations(int target, int[] coins) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (coins == null || coins.length == 0 || target == 0) {
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
                list.add(new ArrayList<>(solution));
                solution.remove(solution.size() - 1);   // error: forget to remove
            }
            return;
        }

        for (int i = 0; i <= moneyLeft / coins[index]; i++) {
            solution.add(i);                                    // error: add(moneyLeft / coins[index]
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
// TC: O(target ^ n)
// SC: O(n)