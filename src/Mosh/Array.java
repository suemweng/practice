package Mosh;
import java.util.Arrays;

public class Array {
    private int[] array;
    private int count;

    public Array(int length) {
        array = new int[length];

    }

    public void insert(int item) {
        if (count < array.length) {
            array[count] = item;
            count++;
        } else {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++ ) {
                newArray[i] = array[i];

            }
            newArray[count] = item;
            count++;
            array = newArray;
        }
    }

    public void removeAt(int index) {
        if (index <0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for(int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;

    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

}
