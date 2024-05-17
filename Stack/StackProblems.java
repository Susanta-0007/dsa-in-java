import java.util.Stack;

public class StackProblems {

    // ! Push at the Bottom of the Stack : (Recursion-> Linear Time -> O(n) )

    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);

    }

    // ! Reverse a String using Stack:

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();

        }

        return sb.toString();

    }

    // ! Reverse a Stack :

    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        // ! it takes extra space (using a stack )
        Stack<Integer> revStack = new Stack<>();

        while (!stack.isEmpty()) {
            revStack.push(stack.peek());
            stack.pop();
        }

        return revStack;

    }

    // ! Reverse a Stack : using Recursion

    public static void reverseStackRec(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        reverseStackRec(stack);
        pushAtBottom(stack, top);
    }

    // ! Stock span Problems :

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(1);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (stack.isEmpty() && currPrice >= stocks[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }
            stack.push(i);
        }
    }

    // ! Valid Paranthesis :

    public static boolean validParanthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Opening
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // Closing
                if (stack.isEmpty()) {
                    return false;
                }
                if ((stack.peek() == '(' && ch == ')')
                        || (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    //! Duplicate Paranthesis :

    public static boolean duplicateParanthesis(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            // Closeing 
            if(ch==')'){
                int count=0;
                while (s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop(); // opening pair
                }
            }
            else{
               s.push(ch); // Opening 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
         * Stack<Integer> stack=new Stack<>();
         * stack.push(1);
         * stack.push(2);
         * stack.push(3);
         * 
         * pushAtBottom(stack, 4);
         * 
         * while (!stack.isEmpty()) {
         * System.out.println(stack.peek());
         * stack.pop();
         * }
         */

        /*
         * 
         * String str="abc";
         * System.out.println(reverseString(str));
         * 
         */
        /*
         * 
         * Stack<Integer> stack = new Stack<>();
         * stack.push(1);
         * stack.push(2);
         * stack.push(3);
         * stack.push(4);
         * 
         * reverseStackRec(stack);
         * while (!stack.isEmpty()) {
         * System.out.println(stack.peek());
         * stack.pop();
         * }
         */
        /*
         * 
         * int stocks[]={100,80,60,70,60,85,100};
         * int[] span=new int [stocks.length];
         * stockSpan(stocks, span);
         * 
         * for(int i=0;i<span.length;i++){
         * System.out.println(span[i]);
         * }
         */

        /*
         * String str = "({})[])";
         * System.out.println(validParanthesis(str));
         */

         String str="(a+b)";
         System.out.println(duplicateParanthesis(str));
    }

}
