package Class2.DFS;

import java.util.Arrays;

public class KeepDistance {

    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] result =  new int[2 * k];

        if (helper(result, k)) {
            return result;
        }
        return null;
    }

    private boolean helper(int[] result, int index) {
        // base case
        if (index == 0) {
            return true;
        }

        for (int i = 0; i < result.length - 1 - index; i++) {
            if (result[i] != 0 || result[i + index + 1] != 0) {  // occupied
                continue;
            }
            result[i] = index;
            result[i + index + 1] = index;
            if (helper(result, index - 1)) {
                return true;
            }
            result[i] = 0;
            result[i + index + 1] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        KeepDistance obj = new KeepDistance();

        System.out.println(Arrays.toString(obj.keepDistance(3)));
    }
}
