import java.util.LinkedList;

public class LLCollection {

    public static void main(String[] args) {
        //! Create
        LinkedList<Integer> ll=new LinkedList<>();

        //! add
        ll.add(1);
        ll.add(2);
        ll.addFirst(0);

        System.out.println(ll);

        //! remove
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);

        //!


    }
}
