import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxOfStack {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int max=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> maxStack=new Stack<>();

        Scanner s=new Scanner(System.in);

        int n=s.nextInt();

        int i=1;
        while(i<=n){
            int choice=s.nextInt();
            switch(choice){
                case 1:

                    int value=s.nextInt();
                    stack.push(value);
                    if(maxStack.empty() || maxStack.peek()<value){
                        maxStack.push(value);
                    }
                    break;
                case 2:
                    int data=stack.pop();
                    // System.out.println(+data);
                    if(maxStack.peek()==data){
                        maxStack.pop();
                    }
                    break;
                case 3:
                    System.out.println(+maxStack.peek());
                    break;
                default:
                    // System.out.println("Enter choices between 1 and 3 only");
                    break;
            }
        }

    }
}