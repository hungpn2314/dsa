public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void display() {
        if (last == null) return;
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data + " ");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) last = newNode;
        else newNode.next = last.next;
        last.next = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public static void main(String[] args) {
    }
}
