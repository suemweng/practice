/**
 * Leet 401. Binary Watch
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 *
 * For example, the below binary watch reads "4:51".
 *
 *
 * Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in any order.
 *
 * The hour must not contain a leading zero.
 *
 * For example, "01:00" is not valid. It should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero.
 *
 * For example, "10:2" is not valid. It should be "10:02".
 *
 *
 * Example 1:
 *
 * Input: turnedOn = 1
 * Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * Example 2:
 *
 * Input: turnedOn = 9
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= turnedOn <= 10
 */

package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    int[] digits = {8, 4, 2, 1, 32, 16, 8 ,4, 2, 1};

    // Key insight: combination
    // to valid hours / minutes range

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> result = new ArrayList<>();
        dfs(0, 0, turnedOn, 0, 0, result);
        return result;
    }

    private void dfs(int index, int start, int k, int hours, int mins, List<String> result) {
        // base case
        if (index == k) {
            result.add(output(hours, mins));
            //result.add(hours + ":" + (mins < 10 ? "0" + mins : mins)); // slower
            return;
        }

        for (int i = start; i < digits.length; i++) {
            if (i <= 3 && hours + digits[i] < 12) {
                dfs(index + 1, i + 1, k, hours + digits[i], mins, result);

            } else if (i >3 && mins + digits[i] < 60) {
                dfs(index + 1, i + 1, k, hours, mins + digits[i], result);
            }
        }
    }

    private String output(int hours, int mins) {
        StringBuilder sb = new StringBuilder();
        sb.append(hours);
        sb.append(':');
        if(mins < 10) {
            sb.append('0');
        }
        sb.append(mins);
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryWatch obj = new BinaryWatch();

        System.out.println(obj.readBinaryWatch(9));
    }
}
