import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.print("null");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public int deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    public int deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp.data;
    }
}
