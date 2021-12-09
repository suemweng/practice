package Class1Beginner.LinkedList;

public class FindMiddleNode {

    public static ListNode findMiddleNode(ListNode head) {
        // corner case
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);
        ListNode Node4 = new ListNode(4);
        ListNode Node5 = new ListNode(5);
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        Node4.next = Node5;
        ListNode Middle = findMiddleNode(Node1);
        System.out.println(Middle.value);
    }
}
