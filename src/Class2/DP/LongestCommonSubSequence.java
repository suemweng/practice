/**
 * Laicode 177. Longest Common Subsequence
 *
 * Find the length of longest common subsequence of two given strings.
 *
 * Assumptions
 *
 * The two given strings are not null
 * Examples
 *
 * S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
 */

package Class2.DP;

public class LongestCommonSubSequence {

    // TC: O (s * t)
    // SC: O (s * t)
    public int longest(String source, String target) {

        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();

        int[][] dp = new int[sa.length + 1][ta.length + 1];

        for (int i = 1; i <= sa.length; i++) {
            for (int j = 1; j <= ta.length; j++) {
                if (sa[i - 1] == ta[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[sa.length][ta.length];
    }

    public static void main(String[] args) {
        LongestCommonSubSequence obj = new LongestCommonSubSequence();

        String source = "abcde";
        String target = "cbabdfe";

        System.out.println(obj.longest(source, target));
    }
}
