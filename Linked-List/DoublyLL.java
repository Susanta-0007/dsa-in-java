public class DoublyLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //! Print
    
    public void print(Node head){
        Node temp=head;

        while (temp!=null) {
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println();
    }

    //! Add : addFirst()
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;

    }

    //! Add : addLast()
    public void addLast(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
       
    }


    //! Remove : removeFirst()
    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }

        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    //! Remove : removeLast()
    public int removeLast(){
        if(head==null){
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }

    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
    
        dll.print(head);
        System.out.println(dll.removeLast());

        dll.print(head);
    }
    
}
