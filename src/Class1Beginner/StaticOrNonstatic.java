package Class1Beginner;

public class StaticOrNonstatic {
    public static void main(String[] args) {
        Car bmwx3 = new Car(45000);
        Car bmwx5 = new Car(85000);
//        System.out.println(bmwx3.haveDoor);
//        bmwx3.haveDoor = false;
//        System.out.println(bmwx5.haveDoor);
        printNumberStatic();
        StaticOrNonstatic.printNumberStatic();
        StaticOrNonstatic a = new StaticOrNonstatic();
        a.printNumberNonStatic();
        System.out.println(a.getClass());

    }

    public static void printNumberStatic() {

        System.out.println(1);
    }

    public void printNumberNonStatic() {
        System.out.println(2);
        printNumberStatic();
    }

}

class Car {
    public int price;
    public static boolean haveDoor;

    public Car(int pr) {
        price = pr;
        haveDoor = true;
    }
    public static void run() {
        System.out.println("running");
    }

    public int getPrice() {
        return this.price;
    }
}
