//modified to dynamic size stack by including expand()and shrink() functions
// also has getMinimum element of stack
public class FixedArraySizeStack {

    private final int DEFAULT=10; //default capacity
    private int capacity;
    protected int[] stack;
    private int top=-1;

    public FixedArraySizeStack(){
        this.capacity=DEFAULT;
        stack=new int[capacity];
    }

    public FixedArraySizeStack(int cap){
        this.capacity=cap;
        stack=new int[capacity];
    }

    public int getDefaultCAPACITY() {
        return DEFAULT;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top<0;
    }

    public boolean isFull(){
        return size()==capacity;
    }

    public void push(int n) throws Exception{
        if(isFull()){  //if(size()==capacity)
            //throw new Exception("Stack overflow");
            expand();
        }
            stack[++top]=n;

    }

    public void expand() {
        capacity=capacity<<1;
        int[] newstack=new int[capacity];
        System.out.println(capacity);
        System.arraycopy(stack,0,newstack,0,size());
        stack=newstack;
    }

    //shrink to 1/2 if more than 3/4 of stack is empty
    public void shrink(){
        float threshhold=(1/2)*capacity;
        if(capacity-size()<threshhold){
            capacity=capacity>>1;
            int[] newstack=new int[capacity];
            System.out.println(capacity);
            System.arraycopy(stack,0,newstack,0,size());
            stack=newstack;
        }
    }

    public int top() throws Exception{
        if(top<0){
            throw new Exception("Stack empty");
        }else{
            return stack[top];
        }
    }

    public int pop() throws Exception{
        int data;
        if(top<0){
            throw new Exception("Stack underflow");
        }else{
            data=stack[top];
            stack[top--]=Integer.MIN_VALUE;
            shrink();
            return data;
        }
    }

    public String toString(){
        String stackStr="[";
        int i;
        if(!isEmpty()) {
            for (i = 0; i < size() - 1; i++) {
                stackStr += stack[i] + ", ";
            }
            stackStr += stack[i];
        }
        return stackStr+"]";
    }

    public static void main(String[] args) {
        FixedArraySizeStack AryStack=new FixedArraySizeStack(4);
        try {
            AryStack.push(1);
            AryStack.push(3);
            AryStack.push(5);
            System.out.println(AryStack);
            AryStack.push(4);
            AryStack.push(6);
            System.out.println(AryStack);
            AryStack.pop();
            AryStack.pop();
            AryStack.pop();
            AryStack.pop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
