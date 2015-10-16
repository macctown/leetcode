package leetcode;

import java.util.Stack;

public class BasicCalculatorII {
	//add operator and number
	//when counter * and / , calculate the sum directly
	//after loop, calculate * and / once more
	// calculate + and - 
	public static int calculate(String s) {
		if(s == null || s.length() == 0)
            return 0;
	    Stack<Character> operator = new Stack<Character>();
	    Stack<Integer> number = new Stack<Integer>();
	    
	    int num = 0;
	    boolean isNum = false;
	    for(int i=0;i<s.length();i++){
	    	if(s.charAt(i) == ' '){
	    		continue;
	    	}
	    	if(Character.isDigit(s.charAt(i))){
	    		num = num*10 + s.charAt(i) - '0';
	    		isNum = true;
	    	}
	    	else if(isNum){
	    		
	    			//encounter operator
		    		number.push(num);
		    		isNum = false;
		    		num = 0;
		    		
		    		//when found * or /, calculate directly and push it back to number
		    		if(!operator.isEmpty() && (operator.peek()=='*'||operator.peek()=='/')){
		    			int num1 = number.pop();
		    			int num2 = number.pop();
		    			char opr = operator.pop();
		    			if(opr == '*'){
	            			number.push(num1*num2);
	            		}
	            		if(opr == '/'){
	            			number.push(num2/num1);
	            		}
		    		}
	    		}
	    		
	    		if(!Character.isDigit(s.charAt(i))){
		    		operator.push(s.charAt(i));
		    	}
	    		
	    	}
	    	
	    	if(isNum){
	            number.push(num);
	            if(!operator.isEmpty() && (operator.peek()=='*'||operator.peek()=='/')){
	    			int num1 = number.pop();
	    			int num2 = number.pop();
	    			char opr = operator.pop();
	    			if(opr == '*'){
            			number.push(num1*num2);
            		}
            		if(opr == '/'){
            			number.push(num2/num1);
            		}
	    		}
	        }
	    	
	    	if(!operator.isEmpty()){
		    		int tmp = 0;
		    		while(!operator.isEmpty()){
		    			char opr = operator.pop();
		    			int tmpNum = number.pop();
		    			if(opr == '+'){
	            			tmp += tmpNum;
	            		}
	            		if(opr == '-'){
	            			tmp -= tmpNum;
	            		}
		    		}
		    		number.push(tmp+number.pop());
		    }
	    return number.pop();
    }
	
	public static void main(String args[]){
		String test = "3+5/2";
		System.out.println(calculate(test));
	}
}
