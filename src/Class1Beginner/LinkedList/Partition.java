package Class1Beginner.LinkedList;

public class Partition {


    public static ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) return head;

        ListNode dummyH = new ListNode(-1);
        dummyH.next = head;
        ListNode dummyA = new ListNode(0);
        ListNode curH = dummyH;
        ListNode curA = dummyA;
        ListNode temp;

        while (curH.next != null) {
            if (curH.next.value < target) {
                temp = curH.next;
                curH.next = curH.next.next;
                curA.next = temp;
                curA = curA.next;

            } else {
                curH = curH.next;
            }

        }
        curA.next = dummyH.next;
        return dummyA.next;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int target = 5;
        ListNode list = ListNode.createList(array);
        ListNode newList = partition(list, target);
        newList.printList();
    }
}
