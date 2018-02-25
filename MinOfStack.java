import java.util.Stack;

public class MinOfStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<>();

    public  void push(int n){
        stack.push(n);
        if(min.empty()){
            min.push(n);
        }else{
            if(n<min.peek()){
                min.push(n);
            }
        }

    }

    public int pop(){
        int data=stack.pop();
        if(min.peek()==data){
            min.pop();
        }
        return data;
    }

    public int getMin(){
        return min.pop(); //should be min.peek();
    }

    public static void main(String[] args) {
        MinOfStack ms=new MinOfStack();
        ms.push(9);
        ms.push(5);
        ms.push(7);
        ms.push(3);
        System.out.println("min is "+ms.min.peek());
            System.out.println(ms.min);

    }
}
