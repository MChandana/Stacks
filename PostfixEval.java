import java.util.Stack;

public class PostfixEval {
    public static void main(String[] args) {
        String postfix="423*+5-";
        Stack<Integer> stack=new Stack<>();
        char read;
        int op1,op2;
        int result=0;
        for(int i=0;i<postfix.length();i++){
            read=postfix.charAt(i);
            if(Character.isDigit(read)){
                stack.push(read-'0');   //stack.push(Characer.getNumericValue(read))
            }else{
                op2=stack.pop();
                op1=stack.pop();
                switch (read){
                    case '+':
                        result=op1+op2;
                        break;
                    case '-':
                        result=op1-op2;
                        break;
                    case '*':
                        result=op1*op2;
                        break;
                    case '/':
                        result=op1/op2;
                        break;
                }
                stack.push(result);
            }
        }
        while(!stack.empty()){
            result=stack.pop();
        }
        System.out.println("RES "+result);
    }
}
