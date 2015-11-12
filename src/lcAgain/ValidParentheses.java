package lcAgain;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {
	public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.size()!=0){
                    char tmp = stack.peek();
                    if(map.get(tmp)!=s.charAt(i)){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
                else{
                    return false;
                }
                
            }
        }
        
        return stack.size()==0;
    }
}
