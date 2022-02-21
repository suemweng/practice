package Class2;

import java.util.EmptyStackException;

public class Practice17_2 {


    public static void main(String[] args) {
        // test-1
        System.out.println();
        System.out.println("Test 1 -------------");
        OriginalPeople Nate = new OriginalPeople();
        System.out.print("Nate");
        Nate.eat();

        RichPeople Anna = new RichPeople();
        System.out.print("Anna");
        Anna.eat();

        OriginalPeople Sun = new RichPeople();
        System.out.print("Sun");
        Sun.eat();

        // test-2
        System.out.println();
        System.out.println("Test 2 -------------");
        Employee e = new Employee("John", "Amazon");
        String name1 = e.name;
        String name2 = e.getName();
        //int age1 = e.age;  //WRONG
        int age2 = e.getAge();
        String company = e.getCompany();

        Person p = new Employee("Jack", "Google");
        p.age = 30;
        int a3 = p.age;
        System.out.println(a3);
        // String company = p.getCompany();   // WRONG

        // test-3
        System.out.println();
        System.out.println("Test 3 -------------");
        Person p1 = new Person("Jack");
        System.out.println(p1.getNameCard());

        Person p2 = new Employee("Jim", "Amazon");
        System.out.println(p2.getNameCard());

        Employee e1 = new Employee("John", "Google");
        System.out.println(e1.getNameCard());

        //test-4
        System.out.println();
        System.out.println("Test 4 -------------");
        // A <- B <- C, D
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }

    static class OriginalPeople{
        Person p;

        public void eat() {
            p = new Person("Jone");
            p.age = 20;
            System.out.println(p.age);
            System.out.println("吃土。。。");
        }

        public void shuati() {
            System.out.println("Laicode 300 ?");
        }
    }

    static class RichPeople extends OriginalPeople {
        @Override
        public void eat() {
            eatBetter();
        }

        public void eatBetter() {
            System.out.println("吃龙虾");
        }
    }

    static class Person {
        public final String name;
        private int age;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getNameCard() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Employee extends Person {
        public String company;

        public Employee(String name, String company) {
            super(name);
            this.company = company;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        @Override
        public String getNameCard() {
            return name + ", employee in" + company;
        }
    }

    static class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }
    }

    static class B extends A {
        public String show(B obj) {
            return ("B and B");
        }

        public String show(A obj) {
            return ("B and A");
        }
    }

    static class C extends B {}

    static class D extends B {}
}
