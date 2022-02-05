package Class2.QueueStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class QueueByTwoStacks {
    // we always insert into the in stack
    private Deque<Integer> in;
    // we always remove from out stack
    private Deque<Integer> out;

    public QueueByTwoStacks() {
        in = new ArrayDeque<Integer>();
        out = new ArrayDeque<Integer>();
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }

        // if out stack is empty,
        // need to move the elements from in stack to out stack
        move();;
        return out.pollFirst();
    }

    public void offer(int element) {
        // always push into the in stack
        in.offerFirst(element);
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        move();
        return out.peekFirst();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    // when out stack is empty,
    // move the elements from in stack to out stack
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }
}
