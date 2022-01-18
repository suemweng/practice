/*
Q 612. Design Linked List 707

Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
Example:

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.
 */

package Class2.LinkedList;

public class MyLinkedList {

    MyListNode head;
    MyListNode tail;
    int size;

    class MyListNode{
        int val;
        MyListNode prev;
        MyListNode next;
		public MyListNode(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new MyListNode(0);
        tail = new MyListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        MyListNode curr;
        if (index <= size - 1 - index) {
            // index is closer to head node, traverse from head;
            curr = head;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
        } else {
            // index is closer to tail node, traverse from tail;
            curr = tail;
            for (int i = size; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        MyListNode curr;
        if (index <= size - 1 - index) {
            // index is closer to head node, traverse from head;
            curr = head;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
        } else {
            // index is closer to tail node, traverse from tail;
            curr = tail;
            for (int i = size; i > index; i--) {
                curr = curr.prev;
            }
        }

        // insert new node
        MyListNode newNode = new MyListNode(val);
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }


        // locate insert location (index)
        MyListNode curr;
        if (index <= size - 1 - index) {
            // index is closer to head node, traverse from head;
            curr = head.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            // index is closer to tail node, traverse from tail;
            curr = tail.prev;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        // delete current node
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
}



