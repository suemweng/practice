package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    // Key insight:
    // 1. 一直吃，最后统一吐，还原初始状态
    // 2. how to clear part of a list

    public List<List<Integer>> combinations(int target) {

        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if (target <= 1) {
            return result;
        }
        List<Integer> factors = getFactors(target);
        List<Integer> curList = new ArrayList<>();

        helper(0, target, factors, curList, result);
        return result;

    }

    private void helper(int index, int remainder, List<Integer> factors, List<Integer> curList, List<List<Integer>> result ) {
        // base case
        // remainder == 1
        // save result, return
        if (remainder == 1) {
            result.add(new ArrayList<>(curList));
            return;
        }

        // factor[] index == factor.length
        // return
        if (index == factors.size()) {
            return;
        }

        // branches
        helper(index + 1, remainder, factors, curList, result);

        int pathLen = curList.size();
        int factor = factors.get(index);
        while (remainder % factor == 0) {
            curList.add(factor);
            remainder = remainder / factor;
            helper(index + 1, remainder, factors, curList, result);
        }
        curList.subList(pathLen, curList.size()).clear();;

    }

    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for (int i = target / 2; i > 1; i--) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        FactorCombinations obj = new FactorCombinations();

        int target = 6;
        System.out.println(obj.combinations(target));
    }
}
