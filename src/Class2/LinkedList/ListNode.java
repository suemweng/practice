package Class2.LinkedList;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static ListNode createList(int[] array) {
        if (array==null || array.length == 0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }

    public void printList() {
//        if (head == null) {
//            System.out.println("Empty List");
//            return;
//        }

        System.out.println(this.value);
        ListNode cur = next;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }


    }
}
