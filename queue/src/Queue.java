import java.util.NoSuchElementException;

public class Queue<T> {
    private ListNode<T> front;
    private ListNode<T> rear;
    private int length;

    private class ListNode<U> {
        private U value;
        private ListNode<U> next;

        public ListNode(U value)    {
            this.value = value;
            this.next = null;
        }
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void display() {
        ListNode<T> current = front;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        T result = front.value;
        front = front.next;
        if (front == null) rear = null;
        length--;
        return result;
    }
}
