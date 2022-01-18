package Class2.QueueStack;

public class BoundedQueue {

    private int[] array;
    private int head;  // head is the top (first element) of Queue
    private int tail; // tail is the first empty cell
    private int size;

    public BoundedQueue(int cap) {
        array = new int[cap];
    }

    public Integer poll() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }
        int result = array[head];
        head = (head + 1 == array.length) ? 0 : head + 1;
        size--;
        return result;
    }

    public Integer peek() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }

        return array[head];
    }

    public boolean offer(int element) {
        // return false if full
        if (isFull()) {
            return false;
        }
        array[tail] = element;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;

    }
}
