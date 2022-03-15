package Class2.DP;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class DictionaryWord {

    // highlight: dp[i] + calculation
    //            break loop after one possibility is found

    public boolean canBreak(String input, String[] dict) {
        // Assumptions:
        // input is not null or empty
        // dict is not null or empty
        // all the strings in dict are not null or empty

        Set<String> dictSet = new HashSet<>();
        Collections.addAll(dictSet, dict);

        boolean[] dp = new boolean[input.length() + 1];
        dp[0] = true;

        // Outer loop: calculate dp[i]
        // Inner loop: i cases of cutting position
        for (int i = 1; i < dp.length; i++ ) {
            for (int j = 0; j < i; j++) {
                // first j letter to check dp[]
                if (dp[j] && dictSet.contains(input.substring(j, i))) {
                    // substring begins at index j and extends to index i - 1
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[input.length()];
    }

    public static void main(String[] args) {
        DictionaryWord obj = new DictionaryWord();

        String input = "rob";
        String[] dict = {"rob", "cat", "d"};

        System.out.println(obj.canBreak(input, dict));
    }
}
// TC: O(n ^ 3) -- n ^ 2 for two loops and n * 2 for contains() + substring()
// SC: O(n)  -- n is length of the input