package Class2.QueueStack;

public class BoundedStack {

    private int[] array;
    private int head;  // head is the top (first element) of Stack

    public BoundedStack(int cap) {
        int[] array = new int[cap];
        this.head = -1;
    }

    public Integer pop() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }

        return array[head--];
    }

    public Integer top() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }

        return array[head];
    }

    public boolean push(int element) {
        // return false if full
        if (isFull()) {
            return false;
        }
        array[++head] = element;
        return true;
    }

    public int size() {
        return head + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == array.length;

    }


}
