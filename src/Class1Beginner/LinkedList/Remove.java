package Class1Beginner.LinkedList;

public class Remove {

    public static ListNode removeElements(ListNode head, int target) {
        // corner case
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.value == target) {
                pre.next = cur.next;

            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,6,3,3,5,6};
        int target = 3;
        ListNode list = ListNode.createList(array);
        ListNode newList = removeElements(list,target);
        newList.printList();
    }
}
