/**
 * Laicode 147. Restore IP Addresses
 *
 *
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public List<String> Restore(String ip) {
        // Write your solution here
        List<String> result = new ArrayList<>();

        if (ip == null) {
            return result;
        }

        char[] array = ip.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(0, array, sb, result);
        return result;
    }

    private void helper(int index, char[] array, StringBuilder sb, List<String> result) {
        // base case
        if (index == 4) {
            if (sb.length() == array.length + 4) {
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
            }
            return;
        }

        int sbLength = sb.length();
        int num = 0;
        int i = 0;
        while (i < 3 && sbLength - index + i < array.length) {
            char ch = array[sbLength - index + i];
            sb.append(ch);
            num = num * 10 + (ch - '0');
            if (num < 256) {
                sb.append('.');
                helper (index + 1, array, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (num == 0) {
                break;
            }
            i++;
        }

        sb.delete(sbLength,sb.length());

    }

    public static void main(String[] args) {
        RestoreIPAddress obj = new RestoreIPAddress();

        String input = "25525511135";
        System.out.println(obj.Restore(input));
    }
}
