import java.util.Deque;
import java.util.LinkedList;

public class DequeBasic {

    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        // ! isEmpty
        public boolean isEmpty() {
            return dq.isEmpty();
        }

        // ! Push
        public void push(int data) {
            dq.addLast(data);
        }

        // ! Pop
        public int pop() {
            return dq.removeLast();
        }

        // ! peek
        public int peek() {
            return dq.getLast();
        }

    }

    static class Queue {
        static Deque<Integer> dq = new LinkedList<>();

        // ! isEmpty()
        public static boolean isEmpty() {
            return dq.isEmpty();
        }

        // ! Add
        public static void add(int data) {
            dq.addLast(data);
        }

        // ! Remove
        public static int remove() {
            return dq.removeFirst();
        }

        // ! Peek
        public static int peek() {
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        /*
         * Deque<Integer> dq=new LinkedList<>();
         * dq.addFirst(1);
         * dq.addFirst(2);
         * 
         * System.out.println(dq);
         * 
         * dq.removeFirst();
         * System.out.println(dq);
         */

        /*
         * Stack s=new Stack();
         * s.push(1);
         * s.push(2);
         * s.push(3);
         * s.push(4);
         * 
         * while (!s.isEmpty()) {
         * System.out.println(s.peek());
         * s.pop();
         * }
         */

         Queue q=new Queue();
         q.add(1);
         q.add(2);
         q.add(3);
         q.add(4);

         while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
         }
    }
}
