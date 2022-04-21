/**
 * Leet 833. Find And Replace in String
 *
 * You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
 *
 * To complete the ith replacement operation:
 *
 * Check if the substring sources[i] occurs at index indices[i] in the original string s.
 * If it does not occur, do nothing.
 * Otherwise if it does occur, replace that substring with targets[i].
 * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
 *
 * All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
 *
 * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
 * Return the resulting string after performing all replacement operations on s.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation:
 * "a" occurs at index 0 in s, so we replace it with "eee".
 * "cd" occurs at index 2 in s, so we replace it with "ffff".
 * Example 2:
 *
 *
 * Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation:
 * "ab" occurs at index 0 in s, so we replace it with "eee".
 * "ec" does not occur at index 2 in s, so we do nothing.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * k == indices.length == sources.length == targets.length
 * 1 <= k <= 100
 * 0 <= indexes[i] < s.length
 * 1 <= sources[i].length, targets[i].length <= 50
 * s consists of only lowercase English letters.
 * sources[i] and targets[i] consist of only lowercase English letters.
 */

package Class2.String;

import java.util.*;

public class FindReplaceString {

    // Key insight:
    // indices[] not sorted
    // how to match from string index to souces/targets index -- match[] / map / List<int[]>
    // how to construct string -- StringBuilder / concatenate string

    // TC: O(NQ) N -- length of s; Q -- replacement
    // SC: O(N)  -- using map could save space to O(L) -- indices.length


    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // corner case
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int[] match = new int[s.length()];
        Arrays.fill(match, -1);

        // build up match[] and verify the sources string
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (s.substring(index, index + sources[i].length()).equals(sources[i])) {
                match[index] = i;
            }
        }

        // iterate s.length
        for (int i = 0; i < match.length; i++) {
            if (match[i] != -1) {
                result.append(targets[match[i]]);
                i += sources[match[i]].length() - 1;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public String findReplaceStringII(String S, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> indList = new ArrayList<>();
        int n = indices.length;
        for (int i = 0; i < n; i++) {
            map.put(indices[i], i);
            indList.add(indices[i]);
        }

        Collections.sort(indList);

        // iterate from right to left -- indices.length
        for (int i = n - 1; i >= 0; i--) {
            int pos = indList.get(i);
            int curInd = map.get(pos);
            if (S.indexOf(sources[curInd], pos) == pos) {
                S = S.substring(0, pos) + targets[curInd] + S.substring(pos + sources[curInd].length());
            }
        }
        return S;

    }

    public static void main(String[] args) {
        FindReplaceString obj = new FindReplaceString();

        String s = "abcd";
        int[] indices = {0,2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(obj.findReplaceString(s,indices, sources, targets));
    }
}
