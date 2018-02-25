import java.util.EmptyStackException;

public class ArrayWithTwoStacks {
    private int[] ary;
    private int size,top1,top2;
    public ArrayWithTwoStacks(int size){
        if(size<2){
            throw new IllegalStateException("Size cannot be less than 2");
        }
        this.size=size;
        ary=new int[size];
        top1=-1;
        top2=size;
    }

    public void push(int stackId,int data){
        if(top1+1==top2){
            throw new StackOverflowError("Stacks are full/Array is full");
        }
        if(stackId==1){
            ary[++top1]=data;
        }else if(stackId==2){
            ary[--top2]=data;
        }else{
            return;
        }
    }

    public int pop(int stackId){
        int data;
        if(stackId==1){
            if(top1==-1){
                throw new EmptyStackException();
            }
             data=ary[top1];
            ary[top1]=Integer.MIN_VALUE;
            top1--;
        }else{
            if(top2==size){
                throw new EmptyStackException();
            }
            data=ary[top2];
            ary[top2]=Integer.MIN_VALUE;
            top2++;
        }
        return data;
    }

    public int top(int stackId){
        if(stackId==1 && top1!=-1){
            return ary[top1];
        }else if(stackId==2 && top2!=size){
            return ary[top2];
        }else{
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(int stackId){
        if(stackId==1){
            return top1==-1;
        }else if(stackId==2){
            return top2==size;
        }else{
            return true;
        }
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder("[");
        res.append(ary[0]);
        for(int i=1;i<size;i++){
            res.append(", "+ary[i]);
        }
        res.append("]");
        return res.toString();
    }
}
