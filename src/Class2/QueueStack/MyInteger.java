package Class2.QueueStack;

import java.util.Comparator;

public class MyInteger implements Comparable<MyInteger>{
    public int value;

    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger another) {
        if (this.equals(another)) {
            return 0;
        }
        return this.value < another.value ? -1 : 1;
    }

    static class MyComparator implements Comparator<MyInteger> {
        @Override
        public int compare(MyInteger one, MyInteger two) {
            if (one.value == two.value) {   // one.equals(two)
                return 0;
            }
            return one.value < two.value ? 1 : -1;
        }
    }
}

