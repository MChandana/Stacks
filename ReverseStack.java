import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverseStack_Recursion(stack);
        System.out.println(stack);
    }

    //using 2 stacks
    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> temp=new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        return temp;
    }

    //using single stack and recursive calls
    public static void reverseStack_Recursion(Stack<Integer> stack){
        if(stack.isEmpty()){
         return;
        }
        int data=stack.pop();
        reverseStack_Recursion(stack);
        insertAtBottom(stack,data);
    }

    private static void insertAtBottom(Stack<Integer> stack, int data) {
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int temp=stack.pop();
        insertAtBottom(stack,data);
        stack.push(temp);

    }
}
