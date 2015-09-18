package lintcode;

import java.util.Stack;

public class QueueTwoStacks {
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueTwoStacks() {
    	//stack 1 is the back of queue
    	stack1 = new Stack<Integer>();
    	//stack 2 is the tail of queue
    	stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
    	stack1.push(element);
    }

    public int pop() {
        // pop elements from stack1 to stack2 for reverse and then pop
    	if(!stack2.empty()){
    		return stack2.pop();
    	}
    	else{
    		while(!stack1.empty()){
        		stack2.push(stack1.pop());
        	}
    	}
    	
    	return stack2.pop();
    }

    public int top() {
        // write your code here
    	if(!stack2.empty()){
    		return stack2.peek();
    	}
    	else{
    		while(!stack1.empty()){
        		stack2.push(stack1.pop());
        	}
    	}
    	return stack2.peek();
    }
}
