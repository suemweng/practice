/**
 * Leet 451. Sort Characters By Frequency
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */

package Class2.String;

import java.util.*;

public class FrequencySort {

    // Key insight:
    // 1. build up ch-count relationship
    // map, int[][]

    // 2. sort count and build result
    // List<Character / Map.Entry> sorted,  List<Character>[] Buckets,  PQ<Map.Entry>

    // TC: O (n + klogk + k + n)
    // SC: O (n + k)

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Integer.compare(map.get(b), map.get(a)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            for (int j = 0; j < map.get(ch); j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort obj = new FrequencySort();

        String s = "tree";
        System.out.println(obj.frequencySort(s));
    }
}
