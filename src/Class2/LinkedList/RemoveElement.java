package Class2.LinkedList;

public class RemoveElement {

    public ListNode removeElement(ListNode head, int target) {
        // corner case
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (head != null) {
            if (head.value == target) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        int[] array = {1,2,3,4,4,3,2,1};
        ListNode head = ListNode.createList(array);
        head.printList();

        int target = 4;
        head = solution.removeElement(head, target);
        head.printList();
    }
}
