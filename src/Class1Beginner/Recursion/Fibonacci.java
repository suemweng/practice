package Class1Beginner.Recursion;

public class Fibonacci {
    public static int fib(int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // recursion rule
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int res = fib(10);
        System.out.println(res);
    }
}

// Time : O(2^n)
// Space : O(n)