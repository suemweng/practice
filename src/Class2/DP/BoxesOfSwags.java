/**
 * Final Exam
 *
 * Q3. Packing Up the Swags （25分值，20分钟）
 *
 *
 *
 * Our company is going to distribute swags at the recruiting event. We will put the swags into square-shaped boxes. Each box has to be completely filled so that the swags wouldn’t break during transportation. For example, a box can contain 1 swag, 4 swags, 9 swags, etc. (The boxes can be sufficiently large.)
 *
 *
 *
 *
 *
 *
 *
 * However, if there are 10 swags, we have to put them into multiple boxes. For example, we could split them into four boxes:
 *
 *
 *
 *
 *
 *
 *
 * Or maybe just two boxes are enough:
 *
 *
 *
 *
 *
 *
 *
 * Given the number of swags, what is the minimum number of boxes to pack them up?
 *
 *
 *
 * Example #1
 *
 * Input: 4
 *
 * Output: 1 (just one 2x2 box)
 *
 *
 *
 * Example #2
 *
 * Input: 10
 *
 * Output: 2 (one 3x3 box and one 1x1 box)
 */

package Class2.DP;

import java.util.Arrays;

public class BoxesOfSwags {

    // dp[i] stores the minimum number of boxes to pack i swags
    // TC: O(n ^ 2)
    // SC: O(n)

    public int minBoxesI(int number) {
        // corner case
        if (number == 0) {
            return 0;
        }

        // dp[i] represents the minimum boxes for number i
        int[] dp = new int[number + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            if (validBoxSize(i)) {
                dp[i] = 1;
                continue;
            }

            // initialize with maximum i boxes
            dp[i] = i;
            for (int j = i - 1; j >= i / 2; j--) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        return dp[number];
    }

    private boolean validBoxSize(int num) {
        for (int i = 1; i * i <= num; i++){
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    // TC: O(n ^ 1.5)
    // SC: O(n)

    public int minBoxesII(int number) {

        // dp[i] represents the minimum boxes for number i
        int[] dp = new int[number + 1];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= number; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1) ;
            }
        }

        return dp[number];
    }

    public static void main(String[] args) {
        BoxesOfSwags obj = new BoxesOfSwags();

        System.out.println(obj.minBoxesII(99));
    }
}
