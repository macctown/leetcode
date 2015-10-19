package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	//NOTE: cmp string use equals please
	public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length==0){
        	return 0;
        }
        

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i]==" "){
        		continue;
        	}
        	else if((!tokens[i].equals("+"))&&(!tokens[i].equals("-"))&&(!tokens[i].equals("*"))&&(!tokens[i].equals("/"))){
        		stack.push(Integer.valueOf(tokens[i]));
        	}
        	else{
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		if(tokens[i].equals("+"))
        			stack.push(num1+num2);
        		if(tokens[i].equals("-"))
        			stack.push(num1-num2);
        		if(tokens[i].equals("*"))
        			stack.push(num1*num2);
        		if(tokens[i].equals("/"))
        			stack.push(num1/num2);
        	}
        }
        
        return stack.pop();
    }
	
	
	public static void main(String args[]){
		String[] test = {"0", "3", "/"};
		System.out.println(evalRPN(test));
	}
} 
