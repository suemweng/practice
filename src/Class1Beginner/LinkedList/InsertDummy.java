package Class1Beginner.LinkedList;

public class InsertDummy {

    public static ListNode insertDummy(ListNode head, int target) {
        ListNode newNode = new ListNode(target);
        //sanity check
        if (head == null) return newNode;

        ListNode dummy = new ListNode(-100);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.value < target) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = newNode;
        newNode.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = insertDummy(node1, 0);
        ListNode newNode = FindKIndex.findKIndex(head,0);
        System.out.println(newNode.value);

    }
}
