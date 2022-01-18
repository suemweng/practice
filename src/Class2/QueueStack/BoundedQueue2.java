package Class2.QueueStack;

// not size field, need a dummyHead

public class BoundedQueue2 {

    private int[] array;
    private int head;  // dummyHead
    private int tail; // tail is the first empty cell


    public BoundedQueue2(int cap) {
        array = new int[cap + 1];
        tail = 1;
    }

    public Integer poll() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }
        head = (head + 1) % array.length;
        return array[head];
    }

    public Integer peek() {
        // return false if empty
        if (isEmpty()) {
            return null;
        }

        return array[(head + 1) % array.length];
    }

    public boolean offer(int element) {
        // return false if full
        if (isFull()) {
            return false;
        }
        array[tail] = element;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        return true;
    }

    public int size() {
        int size = tail - head - 1;
        return size < 0 ? size + array.length : size;
    }

    public boolean isEmpty() {
        return tail == (head + 1) % array.length;
    }

    public boolean isFull() {
        return head == tail;

    }
}
