/**
 * Laicode 176. Longest Common Substring
 *
 * Find the longest common substring of two given strings.
 *
 * Assumptions
 *
 * The two given strings are not null
 * Examples
 *
 * S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd
 */

package Class2.DP;

public class LongestCommonSubstring {

    public String longestCommon(String source, String target) {

        // Key insight:
        // 2D DP for two string comparison

        // TC: O(s * t)
        // SC: O(s * t)

        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();

        int[][] dp = new int[sa.length][ta.length];
        int max = 0;
        int start = 0;

        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i - max + 1;
                }
            }
        }
        return source.substring(start, start + max);
    }

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();

        String source = "abcde";
        String target = "cdf";

        System.out.println(obj.longestCommon(source, target));
    }
}
