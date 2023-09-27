public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.print("null\n");
    }

    public int length() {
        if (head == null) return  0;
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
         if (head == null) {
             head = newNode;
             return;
         }
         ListNode current = head;
         while (current.next != null) {
             current = current.next;
         }
         current.next = newNode;
    }

    public void insert(int value, int index) {
        ListNode newNode = new ListNode(value);
        if (index == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int headIndex = 0;
            ListNode previous = head;
            while (headIndex < index - 1) {
                previous = previous.next;
                headIndex++;
            }
            ListNode current = previous.next;
            previous.next = newNode;
            newNode.next = current;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) return null;
        ListNode tempNode = head;
        head = head.next;
        tempNode.next = null;
        return tempNode;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) return head;
        ListNode current = head, previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void delete(int index) {
        if (index == 0) head = head.next;
        ListNode previous = head;
        int headIndex = 0;
        while (headIndex < index - 1) {
            previous = previous.next;
            headIndex++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

    public void deleteByValue(int value) {
        ListNode temp = null;
        ListNode current = head;
        while (current != null && current.value != value) {
            temp = current;
            current = current.next;
        }
        if (current == null) return;
        temp.next = current.next;
    }

    public void insertToSortedLinkedList(ListNode newNode) {
        ListNode temp = null;
        ListNode current = head;
        while (current != null && current.value < newNode.value) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
    }

    public void removeDuplicateFromSortedArray() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public boolean searchByValue(int value) {
        ListNode current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    public ListNode reverse() {
        ListNode curr = head, prev = null, next_node;
        while (curr != null) {
            // lưu con trỏ trỏ vào node tiếp theo vào node next_node
            next_node = curr.next;
            // trỏ con trỏ next của node hiện tại vào node previous (giá trị ban đầu = null)
            curr.next = prev;
            // cho node previous trỏ vào node hiện tại
            prev = curr;
            // cho node current trỏ vào node next_node
            curr = next_node;
        }
        return head = prev;
    }

    public ListNode findMiddleNode() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode findNthNode(int position) {
        ListNode current = head;
        int headPosition = this.length();
        while (headPosition != position) {
            current = current.next;
            headPosition--;
        }
        return current;
    }

    public boolean isContainsLoop() {
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) return true;
        }
        return false;
    }

    public ListNode findStartLoop() {
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (slowPtr == fastPtr) {
                return getStartNode(slowPtr);
            }
        }
        return  null;
    }

    public ListNode getStartNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoop() {
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    public void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = new ListNode(1);
        for (int i = 2; i < 6; i++) {
            linkedList.insertLast(i);
        }
        linkedList.display();
//        System.out.println(linkedList.deleteFirst().value);
//        System.out.println(linkedList.deleteLast().value);
//        linkedList.delete(3);
//        linkedList.deleteByValue(57);
//        linkedList.insertToSortedLinkedList(new ListNode(8));
//        linkedList.removeDuplicateFromSortedArray();
//        System.out.println(linkedList.searchByValue(5));
//        linkedList.reverse();
//        ListNode node = linkedList.findMiddleNode();
        System.out.println(linkedList.findNthNode(2).value);
        linkedList.display();
//        System.out.println("\n" + linkedList.length());
    }
}
