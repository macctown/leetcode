package lintcode;

import java.util.Stack;

public class MinStack {
		//stack for normal
		public Stack<Integer> stack;
		//stack for min element search
		public Stack<Integer> minStack;
	
	    MinStack() {
	        // do initialization if necessary
	    	//set a new empty stack
	    	stack = new Stack<Integer>();
	    	minStack = new Stack<Integer>();
	    }

	    void push(int number) {
	        // write your code here
	    	stack.push(number);
	    	
	    	if(minStack == null || minStack.empty())
	    	{
	    		//insert directly when the minStack is empty or null
	    		minStack.push(number);
	    	}
	    	else{
	    		//insert only when the number less and !EQUAL! than minStack's peek(save space)
	    		if(number<=minStack.peek()){
	    			minStack.push(number);
	    		}
	    	}
	    }

	    int pop() {
	        // important! Don't forget! Consider pop the minStack at same time
	    	if(stack.peek().equals(minStack.peek()))
	    		minStack.pop();
	    	return stack.pop();
	    }

	    int min() {
	        // write your code here
	    	//peek: get the top element but not remove it
	    	return minStack.peek();
	    }
	    
	    public static void main(String args[]){
	    	MinStack test = new MinStack();
	    	test.push(1);
	    	test.push(2);
	    	test.push(1);
	    	System.out.println(test.min());
	    	test.pop();
	    	test.push(2);
	    	System.out.println(test.min());
	    }
	    
}
