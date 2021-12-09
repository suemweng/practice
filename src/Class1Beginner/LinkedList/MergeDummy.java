package Class1Beginner.LinkedList;

public class MergeDummy {

    public static ListNode mergeDummy(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode dummy = new ListNode(-1);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if (cur1 == null) cur.next = cur2;
        if (cur2 == null) cur.next = cur1;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,5};
        int[] array2 = new int[]{2,4,6};

        ListNode list1 = ListNode.createList(array1);
        ListNode list2 = ListNode.createList(array2);
        ListNode newList = mergeDummy(list1, list2);
        newList.printList();
    }
}
