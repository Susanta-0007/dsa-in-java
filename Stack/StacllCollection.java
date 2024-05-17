import java.util.Stack;

public class StacllCollection {


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
            
        }
    }
    
}
