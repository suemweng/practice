/**
 * Final Exam
 *
 * Q1. Find all possible decode ways.
 *
 *
 *
 * The decoding scheme is:
 *
 * 1 -> A
 *
 * 2 -> B
 *
 * …
 *
 * 10 -> J
 *
 * 11 -> K
 *
 * 12 -> L
 *
 * …
 *
 * 21 -> U
 *
 * 22 -> V
 *
 * ...
 *
 * 26 -> Z
 *
 *
 *
 * e.g. Given input String  "1121"
 *
 * It can be decoded as
 *
 * [ "AABA",
 *
 *   "AAU",
 *
 *   "ALA",
 *
 *   "KBA",
 *
 *   "KU"
 *
 * ]
 *
 * return all the possible decode ways, or just print out all decodes ways
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {

    // TC: O(2 ^ n * n)
    // SC: O(n)

    public List<String> decode(String input) {

        List<String> result = new ArrayList<>();
        // corner case
        if (input == null || input.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        helper(0, sb, input, result);
        return result;
    }

    private void helper(int index, StringBuilder sb, String code, List<String> result) {

        // base case
        if (index == code.length()) {
            result.add(sb.toString());
            return;
        }

        // branches
        int sbLen = sb.length();

        // add one char
        if (code.charAt(index) - '0' > 0) {
            char ch = (char) (code.charAt(index) - '0' - 1 + 'A');
            sb.append(ch);
            helper(index + 1, sb, code, result);
            sb.setLength(sbLen);
        }

        // add two chars
        if (index + 1 < code.length()) {
            int number = (code.charAt(index) - '0') * 10 + (code.charAt(index + 1) - '0');
            if (number >= 10 && number <= 26) {
                char ch = (char) (number - 1 + 'A');
                sb.append(ch);
                helper(index + 2, sb, code, result);
                sb.setLength(sbLen);
            }
        }
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();

        String input = "1021";
        System.out.println(obj.decode(input));
    }
}
