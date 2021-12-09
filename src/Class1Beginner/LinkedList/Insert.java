package Class1Beginner.LinkedList;

public class Insert {

    public static ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // corner case
        if (head == null) return newNode;

        if (head.value > value) {
            newNode.next = head;
            return newNode;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.value < value) {
            cur = cur.next;
        }

        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(4);
        ListNode Node4 = new ListNode(5);
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        ListNode Head = insert(Node1, 7);
        ListNode NewNode = FindKIndex.findKIndex(Head,4);
        System.out.println(NewNode.value);
    }
}
