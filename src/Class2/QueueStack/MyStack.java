package Class2.QueueStack;


import Class2.LinkedList.ListNode;

// Singly linked list
public class MyStack {
    private ListNode head;
    private int size;

    public MyStack() {
        this.head = null;
        this.size = 0;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        head = head.next;
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

    public boolean push(int element) {
        ListNode newNode = new ListNode(element);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
