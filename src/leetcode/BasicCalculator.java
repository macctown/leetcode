package leetcode;

import java.util.Stack;

public class BasicCalculator {
	//put number in
	//at the same time. put operator in and calculate at the same time
	public static int calculate(String s) {
		 if(s == null || s.length() == 0)
	            return 0;
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> number = new Stack<Integer>();
        s = "("+s+")";
        int num = 0;
        int res = 0;
        boolean isNum = false;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == ' '){
        		continue;
        	}
        	if(s.charAt(i)>=48 && s.charAt(i)<=57){
        		num = num*10 + s.charAt(i)-'0';
        		isNum = true;
        		continue;
        	}
        	else if(isNum==true){
        		number.push(num);
        		num = 0;
        		isNum = false;
        	}
        	
        	if(s.charAt(i)=='+' || s.charAt(i)=='(' || s.charAt(i)=='-'){
        		operator.push(s.charAt(i));
        	}
        	else if(s.charAt(i) == ')'){
        		int tmpNum = 0;
        		while(operator.peek() != '('){
            		char opr = operator.pop();
        			int tmp = number.pop();
            		if(opr == '+'){
            			tmpNum += tmp;
            		}
            		if(opr == '-'){
            			tmpNum -= tmp;
            		}
        		}
        		tmpNum += number.pop();	//add the one on the left of (
        		number.push(tmpNum);	//push new sum into stack
        		operator.pop();			//pop the ( after calculate
        	}
        		
        }

    	return number.pop();
        
	}
	
	
	public static void main(String args[]){
		String test = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(test));
	}
}
