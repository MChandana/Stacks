//stack-1 from index 0 and stack-2 from index len-1
public class TwoStacksArray {
    static int[] ary=new int[7];
    static int len=ary.length;
    static int top1=-1,top2=-1;

    public static void main(String[] args) {
        push(1,1);
        push(1,2);
        push(1,3);
        push(2,1);
        push(2,2);
        push(2,3);
        pop(2);
        push(1,4);
        push(2,5);
        pop(2);
        pop(2);
        pop(2);
/*
        if(top1!=-1) {
            for (int i = 0; i <= top1; i++) {
                System.out.println(ary[i]);
            }
        }
        if(top2!=-1) {
            for (int i = len - 1; i >= top2; i--) {
                System.out.println(ary[i]);
            }
        }
        System.out.println(isEmpty(2));
*/
        System.out.println("ArrayWithTwoStacks");
        ArrayWithTwoStacks array=new ArrayWithTwoStacks(6);
        array.push(1,1);
        array.push(1,2);
        array.push(1,3);
        array.push(2,1);
        array.push(2,2);
        array.push(2,3);
        System.out.println(array);
        array.pop(2);
        System.out.println(array);
        array.push(1,4);
        System.out.println(array);
        System.out.println(array.top(2));
        System.out.println(array.top(1));
        array.pop(2);
        array.pop(2);
        System.out.println(array.isEmpty(2));
        System.out.println(array);

    }

    public static void push(int stackId,int data){
        int i;
        if(stackId==1){
            if(top1+1==top2){
                System.out.println("Stack1 overflow");
                return;
            }else{

                ary[++top1]=data;
            }
        }else{
            if(top2-1==top1){
                System.out.println("Stack2 overflow");
                return;
            }else{
                if(top2==-1){
                    top2=len-1;
                    ary[top2]=data;
                }else{
                    ary[--top2]=data;

                }
            }
        }

    }

    public static int pop(int stackId){
        int data;
        if(stackId==1){
            if(top1==-1){
                System.out.println("Stack1 underflow");
                return Integer.MIN_VALUE;
            }else{
                 data=ary[top1--];
            }
        }else{
            if(top2==-1){
                System.out.println("Stack2 underflow");
                return Integer.MIN_VALUE;
            }else{
                data=ary[top2++];
                if(top2==len){
                    top2=-1;
                }
            }
        }
        return data;

    }

    public static boolean isEmpty(int stackId){
        if(stackId==1){
            if(top1==-1){
                return true;
            }else
                return false;
        }else{
            if(top2==-1){
                return true;
            }else
                return false;
        }
    }
}
