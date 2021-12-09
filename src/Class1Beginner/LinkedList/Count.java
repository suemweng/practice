package Class1Beginner.LinkedList;

public class Count {

    public static int count(ListNode head) {
        // corner case
        if (head == null) return 0;

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    public static void main(String[] args) {
        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);
        Node1.next = Node2;
        Node2.next = Node3;
        ListNode Head = Node1;
        int length = count(Head);
        System.out.println(length);
    }
}
