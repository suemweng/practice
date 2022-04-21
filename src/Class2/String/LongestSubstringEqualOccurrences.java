/**
 * You are giving a string S consisting of N lowercase letters of the English alphabet.
 * Find the length of the longest substring of S in which the number of occurranes of
 * each letter is equal.
 *
 * For example, given S = "ababbcba", substrings in which every letter occurs the same number
 * of times are: "a", "b", "c", "ab", "ba", "bb", "bc", "cb", "abab" and "bcbc". The longest
 * among them are "abab" and "bcb" and their length equals 4.
 *
 * W
 */

package Class2.String;

import java.util.*;

public class LongestSubstringEqualOccurrences {
    // Method 1:
    // starting search from the maximum length
    // k denotes length of substring
    // i denotes the starting point of substring

    public int longestSubstringI(String str) {
        for (int k = str.length(); k > 0; k--) {
            for (int i = 0; i + k <= str.length(); i++) {
                if (isSameOccurrenceI(str.substring(i, i + k))) {
                    return k;
                }
            }
        }
        return -1;
    }

    private boolean isSameOccurrenceI(String str) {
        Map<Character, Integer> map = countMap(str);
        Set<Integer> set = new HashSet<>();
        for (char ch : map.keySet()) {
            set.add(map.get(ch));
        }
        return set.size() == 1;
    }

    private Map<Character, Integer> countMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        return map;
    }

    // Method 2:
    //
    public int longestSubstringII(String str) {
        int strLen = str.length();
        // use countMap<Integer i, int[] countArray> to save total occurrence (prefixSum) of characters in substring ending at index i
        Map<Integer, int[]> countMap = new HashMap<>();

        // initialize the countArray at index -1 (empty string) and strLen - 1 (whole input string)
        countMap.put(-1, new int[26]);
        countMap.put(strLen - 1, new int[26]);
        int[] countArray = countMap.get(strLen - 1);
        for (char ch : str.toCharArray()) {
            countArray[ch - 'a']++;
        }

        // starting search from the maximum length
        // k denotes length of substring
        // i denotes the starting point of substring
        // j denotes the ending point of substring
        for (int k = strLen; k > 0; k--) {
            for (int i = 0; i + k <= strLen; i++) {
                int j = i + k - 1;
                if (isSameOccurrenceII(i, j, countMap, str)) {
                    return k;
                }
            }
        }
        return -1;
    }

    private boolean isSameOccurrenceII(int start, int end, Map<Integer, int[]> countMap, String str) {
        if (countMap.get(start - 1) == null) {
            buildCountArray(start - 1, countMap, str);
        }

        if (countMap.get(end) == null) {
            buildCountArray(end, countMap, str);
        }

        int[] x = countMap.get(start - 1);
        int[] y = countMap.get(end);
        Set<Integer> diff = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) {
                diff.add(x[i]- y[i]);
            }
        }
        return diff.size() == 1;
    }

    private void buildCountArray(int index, Map<Integer, int[]> countMap, String str) {
        int[] curArray = null;
        if (countMap.get(index - 1) == null) {
           curArray =  Arrays.copyOf(countMap.get(index + 1), 26);
           char ch = str.charAt(index + 1);
           curArray[ ch - 'a']--;

        } else {
            curArray =  Arrays.copyOf(countMap.get(index - 1), 26);
            char ch = str.charAt(index);
            curArray[ch - 'a']++;
        }
        countMap.put(index, curArray);
    }


    public static void main(String[] args) {
        LongestSubstringEqualOccurrences obj = new LongestSubstringEqualOccurrences();

        String str = "daababbdd";
        System.out.println(obj.longestSubstringII(str));

    }
}
