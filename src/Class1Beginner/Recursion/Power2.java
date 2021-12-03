package Class1Beginner.Recursion;

public class Power2 {

    public static int power2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 1) return power2(a, b / 2) * power2(a, b / 2) * a;
        else return power2(a, b / 2) * power2(a, b / 2);
    }
    public static void main(String[] args) {
        int res = power2(2,4);
        System.out.println(res);
    }
}

//O(b), O(log b)