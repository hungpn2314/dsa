import java.util.EmptyStackException;

public class Stack<T> {
    private class ListNode<U> {
        public U value;
        public ListNode<U> next;

        public ListNode(U value) {
            this.value = value;
            this.next = null;
        }
    }
    private int length;
    private ListNode<T> top;

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return this.length;
    }
    public boolean isEmpty() {
        return this.length == 0;
    }

    public void display() {
        ListNode<T> current = top;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void push(T value) {
        ListNode<T> temp = new ListNode<>(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T result = top.value;
        top = top.next;
        length--;
        return result;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public void insert(T value, int position) {
        if (position < 0 || position > this.length + 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        ListNode<T> newNode = new ListNode<>(value);
        if (position == this.length + 1) {
            newNode.next = top;
            top = newNode;
        } else {
            ListNode<T> current = top;
            int topPosition = this.length() + 1;
            while (topPosition > position) {
                current = current.next;
                topPosition--;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        this.length++;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 5; i > 0; i--) {
            stack.push(i);
        }
        stack.display();
        System.out.println(stack.length());
        stack.insert(10, 1); // error if position = 1 !!!!
        stack.display();
        System.out.println(stack.length());
    }
}
