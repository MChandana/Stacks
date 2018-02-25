import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();
        String str="1+(4-2)*3-2";
        int op1,op2, result=0;
        char opr,read;
        for(int i=0;i<str.length();i++){
            read=str.charAt(i);
            if(Character.isDigit(read)){
                operand.push(Character.getNumericValue(read));

            }else if(read=='('){
                operator.push(read);
            }else if(read==')'){
                while(operator.peek()!='('){
                    opr=operator.pop();
                    op2=operand.pop();
                    op1=operand.pop();
                    result=calculation(op1,op2,opr);
                    operand.push(result);

                }
                if(!operator.empty() && operator.peek()=='('){
                    operator.pop();
                }else{
                    System.out.println("Invalid");
                    return;
                }
            }else{

                while(!operator.empty() && precedence(read)<=precedence(operator.peek()) ){
                    opr=operator.pop();
                    op2=operand.pop();
                    op1=operand.pop();
                   result=calculation(op1,op2,opr);
                    operand.push(result);

                }
               /* if(!operator.empty()){
                }*/
                operator.push(read);
            }
        }

        while (!operator.empty() && !operand.empty()){
            opr=operator.pop();
            op2=operand.pop();
            op1=operand.pop();
            result=calculation(op1,op2,opr);
            operand.push(result);

        }
        System.out.println("res "+operand.peek());
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

    public static int calculation(int op1, int op2, char opr){
        int result=0;
        switch (opr){
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
        return result;
    }
}
