package Class1Beginner.Recursion;

public class Power {

    public static int power(int a, int b) {
        if (b == 0) return 1;
        return power(a, b - 1) * a;
    }

    public static void main(String[] args) {
        int res = power(2,3);
        System.out.println(res);
    }
}

// O(b), O(b)