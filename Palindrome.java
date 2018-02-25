import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String s="ababbXbbaba";
       /* boolean palindrome=true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)==s.charAt(j)){
                continue;
            }else{
                palindrome=false;
                break;
            }
        }*/
       boolean palindrome=checkPalindrome(s);
        if(palindrome){
            System.out.println("yes");
        }else
            System.out.println("no");
    }

    //using stack
    public static boolean checkPalindrome(String s){
        Stack<Character> stack=new Stack<>();
        char c,read;
        boolean palindrome=true;
        int i;
        for(i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c=='X'){
                break;
            }
            stack.push(c);
        }
        for(i=i+1;i<s.length();i++){
            c=s.charAt(i);
            read=stack.pop();
            if(c!=read){
                palindrome=false;
                break;
            }
        }

        return palindrome;
    }
}
