package Class1Beginner.LinkedList;

public class FindKIndex {

    public static ListNode findKIndex(ListNode head, int k) {
        // corner case
        if (head == null || k < 0) return null;

        ListNode cur = head;
        int index = 0;
        while (index < k && cur != null) {
            cur = cur.next;
            index++;

        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);
        Node1.next = Node2;
        Node2.next = Node3;
        ListNode NodeK = findKIndex(Node1,2);
        System.out.println(NodeK.value);
        System.out.println(NodeK.next);
    }
}
