/** medium
 * Laicode 272. Combinations For Telephone Pad I
 *
 * Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.
 *
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
 *
 * Assumptions:
 *
 * The given number >= 0
 * Examples:
 *
 * if input number is 231, possible words which can be formed are:
 *
 * [ad, ae, af, bd, be, bf, cd, ce, cf]
 */

package Class2.DFS;

import java.util.*;

public class CombinationsTelPadI {

    public String[] combinations(int number) {

        String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};  // error: use hashmap
        char[] array = ("" + number).toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, array, sb, result, keypad);

        return result.toArray(new String[0]);
    }

    private void helper(int index, char[] array, StringBuilder sb, List<String> result, String[] keypad) {
        // base case
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }

        String str = keypad[array[index] - '0'];
        if (str == "") {
            helper(index + 1, array, sb, result, keypad);
        }

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            helper(index + 1, array, sb, result, keypad);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



    public static void main(String[] args) {
        CombinationsTelPadI obj = new CombinationsTelPadI();

        int number = 231;
        String[] result = obj.combinations(number);
        System.out.println(Arrays.toString(result));
    }

}
