/**
 * Laicode 100. Edit Distance
 *
 * Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
 *
 * Assumptions
 *
 * Both strings are not null
 * Examples
 *
 * string one: “sigh”, string two : “asith”
 *
 * the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 */

package Class2.DP;

public class EditDistance {

    public int editDistance(String one, String two) {

        int[][] dp = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++){
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[one.length()][two.length()];
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();

        String one = "sigh";
        String two = "asith";
        System.out.println(obj.editDistance(one, two));


    }
}

// TC: O(n * m)
// SC: O(n * m)