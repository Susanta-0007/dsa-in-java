import java.util.Stack;

public class QueueUsingStack {

    static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //! Add
        public static void add(int data){
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //! Remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front=s1.peek();
            s1.pop();
            return front;
        }

        //! Peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Full");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
