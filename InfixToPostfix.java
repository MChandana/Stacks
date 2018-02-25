import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        String string="A*B-(C+D)+E";
        StringBuilder sb=new StringBuilder();
        String postfix="";
        char out,read;
        for(int i=0;i<string.length();i++){
            read=string.charAt(i);
            if(Character.isLetterOrDigit(read)){
                sb.append(read);
            }else if(read==')'){
                while((stack.peek())!='(' && !stack.empty()  ){
                    sb.append(stack.pop());
                }
                if(!stack.empty() && stack.peek()!='('){
                    sb=new StringBuilder("Invalid exprs");
                    break;
                }else{
                    stack.pop();
                }
            }else{

                if(read=='('){
                    stack.push(read);
                }else {
/*
3.1If the precedence of the scanned operator is greater than the precedence of the operator
in the stack(or the stack is empty), push it.
3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal
 to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
 */
                    while (!stack.empty() && precedence(read) <= precedence(stack.peek())){
                        char ch=stack.pop();
                        sb=sb.append(ch);
                    }
                    stack.push(read);
                }
            }
        }

        while (!stack.empty()){
            sb=sb.append(stack.pop());
        }
        System.out.println("postfix is "+sb);
    }

    public static int precedence(char c){
        int precedence=0;
        switch (c){
            case '+':
            case '-':
              precedence=1;
              break;
            case '*':
            case '/':
                precedence=2;
                break;
                      }
                      return precedence;
    }
}
