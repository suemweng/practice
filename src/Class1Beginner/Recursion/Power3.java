package Class1Beginner.Recursion;

public class Power3 {

    public static int power3(int a, int b) {
        // Assumption: b >= 0
        if (b == 0) {
            return 1;
        }

        int half = power3(a, b / 2);
        if (b % 2 == 1) {
            return half * half * a;
        } else {
            return half * half;
        }
    }

    public static void main(String[] args) {
        int res = power3(0,3);
        System.out.println(res);
    }
}

// TC: O(log b)
// SC: O(log b)