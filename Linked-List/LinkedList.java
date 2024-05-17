public class LinkedList {

    //! Craete Node Class 
    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //! Methods :  addFirst()

    public void addFirst(int data){
        //! Step-01: Create a New Node :
        Node newNode=new Node(data);
        size++;
        //! if the Linkedlist is Empty :
        if(head==null){
            head=tail=newNode;
            return;
        }
        //! Step-02: newNode next=head :
        newNode.next=head;
        //! Step-03: head=newNode :
        head=newNode;
    }

    //! Methods : addLast()

    public void addLast(int data){
        //! Step-01 : Create a New Node :
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //!
        tail.next=newNode;
        tail=newNode;
    }

    //! Methods : printLL()

    public void printLL(){
        if(head==null){
            return;
        }
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

    //! Methods : addMiddle(index,data) 
    
    public void addMiddle(int index,int data){
        if(head==null){
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
        //! i=index-1 ; temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    //! Methods : Size of LL

    public int sizeOfLL(){
        int size=0;
        while (head!=null) {
            size++;
            head=head.next;
        } 
        return size;
    }

    //! Methods : Remove First Node
    
    public int removeFirst(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        }

        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;
        return val;
    }


    //! Methods : Remove Last Node 

    public int removeLast(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
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

    //! Problems : Iteration Search 

    public int iterationSearch(int key){
        Node temp=head;
        int i=0;
        while (temp!=null) {
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    //! Problems :  Recursive Search 

    public int recursiveSearch(int key){
        return helper(head,key);
    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);

        if(idx==-1){
            return -1;
        }

        return idx+1;
    }

    //! Problems : Reverse a LL 

    public void reverseLL(Node head){
        if(head==null){
            return;
        }
        reverseLL(head.next);
        System.out.print(head.data+" -> ");
    }

    //! Problems : Reverse a LL (Iterative Approach)

    public void reverseLLIterative(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        head=prev;

    }

    //! Find & Remove Nth node from End :

    public void deleteNthFromEmd(int n){
        //  calculate size()
        int sz=0;
        Node temp=head;
        while (temp!=null) {
            temp=temp.next;
            sz++;
        }

        // corner case 
        if(n==sz){
            head=head.next ; // removeFirst
            return;
        }

        // sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;

        while (i<iToFind) {
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
        return;

    }

    //! Problems : Find the Mid of an LL :

    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //! Problem : Palindrome Check

    public boolean checkPalindrome(Node head){
        // Base case or Corner case
        if(head==null || head.next==null){
            return true;
        }
        // Step-01 : find mid
        Node midNode=findMid(head);

        // Step-02 : reverse 2nd Hald
        Node prev=null;
        Node curr=midNode;
        Node next;

        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev; // right half end :
        Node left=head;


        // Step-03 : check left half & right half :
        while (right!=null) {
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;


    }


    //! Problems : Cycle Detection in LL
    
    public boolean isCycle(Node head){
        Node slow=head;
        Node fast=head;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow== fast){
                return true;
            }
            
        }
        return false;
    }

    //! Problems : Cycle Remove in LL 

    public static void removeCycle(){
        // Detect Cycle :
        Node slow=head;
        Node fast=head;

        boolean cycle=false;

        while (fast!=null & fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }

        if(cycle==false){
            return;
        }

        // find meeting poibt :
        slow=head;
        Node prev=null;

        while (slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //  remove cycle -> last.next = null 
        prev.next=null;
    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        
        // System.out.println(ll.sizeOfLL());
        // System.out.println(ll.recursiveSearch(4));

        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addMiddle(1,10);
        // ll.printLL();                                               
        // System.out.println(ll.size);        
        // ll.removeFirst();
        // ll.printLL();
        // ll.reverseLLIterative();
        // ll.deleteNthFromEmd(2);
    //    System.out.println(ll.findMid(head));
    //    System.out.println(ll.checkPalindrome(head));

        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;

        System.out.println(ll.isCycle(head));
        removeCycle();;
        System.out.println(ll.isCycle(head));
    }
    
}
