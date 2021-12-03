package Class1Beginner;

import org.w3c.dom.ls.LSOutput;

public class GoldBach {
    public static void main(String[] args) {
        int n = 55;
        boolean found = isCase(n);
        System.out.println(found);
    }

    public static boolean isCase(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println(i + " + " + (n - i));
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

