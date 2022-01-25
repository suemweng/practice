package Class2.DFS;

import java.util.*;
public class AllSubsets {


    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> list = new ArrayList<>();
        // corner case
        if (set == null) {
            return list;
        }


        char[] input = set.toCharArray();
        StringBuilder prefix = new StringBuilder();
        findSubset(input, 0, prefix, list);
        return list;
    }

    private void findSubset(char[] input, int index, StringBuilder prefix, List<String> list) {
        // base cae
        if (index == input.length) {
            list.add(prefix.toString());
            return;
        }

        prefix.append(input[index]);
        findSubset(input, index + 1, prefix, list);
        prefix.deleteCharAt(prefix.length() - 1);
        findSubset(input, index + 1, prefix, list);

    }

    public static void main(String[] args) {
        AllSubsets solution = new AllSubsets();
        String set = "abc";
        List<String> result = solution.subSets(set);
        System.out.println(result);
    }
}
// TC O(2^n * n)  ?? * n is the time of .toString
// Sc O(n)