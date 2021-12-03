public class Quiz {

    public static void main(String[] args) {
        check();
    }

    public static void check() {

        for (int i = 4; i < 100; i +=2) {
            if (isCase(i)){
                System.out.println("1");
            } else {
                System.out.println("Congrats");
            }
        }

    }

    public static boolean isCase(int num) {
        for (int i = 2; i < num; i++) {
            if ( isPrime(i) && isPrime(num - i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int num) {
        for (int i=2; i < num; i++) {
            if ( num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
