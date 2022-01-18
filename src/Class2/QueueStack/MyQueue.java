package Class2.QueueStack;


// implemented by singly linked list

import Class2.LinkedList.ListNode;

public class MyQueue {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        result.next = null;
        size--;
        return result.value;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public boolean offer(Integer element) {

        if (head == null) {
            tail = new ListNode(element);
            head = tail;
        } else {
            tail.next = new ListNode(element);
            tail = tail.next;
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
