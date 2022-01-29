package Class2.QueueStack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array cannot be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        int index = size / 2 - 1;
        while (index >= 0) {        // missed "="
            percolateDown(index);
            index--;
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity cannot be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[index] < array[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1 ) {
            // smallest one among leftchild and rightchild
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smaller = left;

            // update smaller if rightchild exists and its is smaller than leftchild
            if (right < size && array[right] < array[left]) {
                smaller = right;
            }

            // swap if necessary
            if (array[smaller] < array[index]) {
                swap(index, smaller);
                index = smaller;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {                                       // missed the size check
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;                     // size needs to be updated before calling percolateDown()
        percolateDown(0);     // because the size will be used in percolateDown();
        return result;
    }

    public void offer(int element) {
        if (isFull()) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));  // ok to use methods in Arrays class
        }
        array[size] = element;
        size++;                      // size needs to be updated before calling percolateUp()
        percolateUp(size - 1); // because the size will be used in percolateUp();
    }

    public int update(int index, int element) {
        // return the original value
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index range");
        }
        int result = array[index];
        array[index] = element;
        if (element > result) {     // missed the whole process of heapify
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return result;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
