package Class1Beginner.LinkedList;

public class Merge {

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode newHead = null;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = null;

        if (head1.value <= head2.value) {
            newHead = head1;
            cur1 = cur1.next;
        }
        else {
            newHead = head2;
            cur2 = cur2.next;
        }
        cur = newHead;

        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
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
        return newHead;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,5};
        int[] array2 = new int[]{2,4,6};

        ListNode list1 = ListNode.createList(array1);
        ListNode list2 = ListNode.createList(array2);
        ListNode newList = merge(list1, list2);
        newList.printList();
    }
}
