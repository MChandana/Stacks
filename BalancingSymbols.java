import java.util.Stack;

public class BalancingSymbols {

    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        String s="()(()[()])";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                char c=stack.pop();
                char a=s.charAt(i);
                if(a==')'){
                    if(c=='('){
                        continue;
                    }else
                    {
                        System.out.println("Unbalanced");
                        break;
                    }
                }else{
                    if(a==']'){
                        if(c=='['){
                            continue;
                        }else{
                            System.out.println("Unbalanced");
                            break;
                        }
                    }
                }
            }

            }
            if(!stack.empty()){
                System.out.println("Unbalanced");
            }



    }

    //optimized
   public static boolean balance(String s){
        if(s.length()==0 || s.equals(null)){
            return true;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char read=s.charAt(i);
            if(read==')'){
                if(!stack.empty() && stack.peek()=='('){
                    stack.pop();
                }else
                    return false;
            }
            else if(read==']'){
                if(!stack.empty() && stack.peek()=='['){
                    stack.pop();
                }else
                    return false;
            }
            else if(read=='}'){
                if(!stack.empty() && stack.peek()=='{'){
                    stack.pop();
                }else
                    return false;
            }
            else{
                stack.push(read);
            }
        }

        if(stack.isEmpty()){
            return true;
        }else
            return false;
    }
}
