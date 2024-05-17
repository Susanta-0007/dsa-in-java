public class CircularQueue {

    static class  Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        //! Add 
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }

            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        //! Remove
        public static int remove(){
            if(isFull()){
                System.out.println("Queue is Full");
                return -1;
            }

            int result=arr[front];

            // last element delete
            if(rear==front){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }

            return result;
        }

        //! Peek
        public static int peek(){
            if(isFull()){
                System.out.println("Queue is Full");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q=new Queue(5);
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
