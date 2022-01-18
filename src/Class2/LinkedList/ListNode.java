package Class2.LinkedList;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static ListNode createList(int[] array) {
        if (array==null || array.length == 0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }

    public void printList() {
        System.out.println(this.value);
        ListNode cur = next;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public int length() {
        int length = 1;
        ListNode cur = next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public ListNode get(int index) {
        if (index == 0) return this;
        ListNode cur = next;
        while (index > 1 && cur != null) {
            index--;
            cur = cur.next;
        }
        return cur;
    }

    public ListNode appendHead(int value) {
        ListNode newNode = new ListNode(value);

        newNode.next = this;
        return newNode;
    }

    public void appendTail(int value) {
        ListNode newNode = new ListNode(value);
        ListNode pre = this;
        while(pre.next != null) {
            pre = pre.next;
        }
        pre.next = newNode;
    }
}
