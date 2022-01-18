/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

package Class2.LinkedList;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtIndex(0,10);
        obj.addAtIndex(1,20);
        obj.addAtIndex(1,15);
        obj.deleteAtIndex(0);
        int param_1 = obj.get(1);
        System.out.println(param_1);
    }



}
