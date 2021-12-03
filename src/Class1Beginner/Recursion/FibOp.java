package Class1Beginner.Recursion;

public class FibOp {

    public static int FibOp(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int res = FibOp(2);
        System.out.println(res);
    }
}
