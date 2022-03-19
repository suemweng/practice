/**
 * Laicode 398. All Anagrams
 *
 * Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
 *
 * Assumptions
 *
 * sh is not null or empty.
 * lo is not null.
 * Examples
 *
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */

package Class2.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    public List<Integer> allAnagrams(String sh, String lo) {

        // Key insight:
        // use sliding windows and map<char, count> to check how many chars matched

        // TC: O(n)
        // SC: O(d) d is number of chars in input string alphabet - map size

        List<Integer> result = new ArrayList<>();
        if (lo.length() == 0) {
            return result;
        }

        if (sh.length() > lo.length()) {
            return result;
        }

        Map<Character, Integer> shMap = countMap(sh);
        int match = 0;

        for (int i = 0; i < lo.length(); i++) {
            char ch = lo.charAt(i);
            Integer count = shMap.get(ch);
            if (count != null) {
                shMap.put(ch, count - 1);
                if (count == 1) {
                    match++;
                }
            }

            if (i >= sh.length()) {
                ch = lo.charAt(i - sh.length());
                count = shMap.get(ch);
                if (count != null) {
                    shMap.put(ch, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            // important: compare math with map size, not sh size, as there could be duplicate chars
            if (match == shMap.size()) {
                result.add(i - sh.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        AllAnagrams obj = new AllAnagrams();

        String l = "ababacbbaac";
        String s = "aab";
        System.out.println(obj.allAnagrams(s, l));

    }
}
