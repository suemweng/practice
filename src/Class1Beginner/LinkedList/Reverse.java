package Class1Beginner.LinkedList;

public class Reverse {
    // Iterative
    public static ListNode reverse(ListNode head) {
        // corner case
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur.next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        ListNode list = ListNode.createList(array);
        ListNode newList = reverse(list);
        newList.printList();

    }
}
