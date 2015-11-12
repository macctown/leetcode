package lcAgain;

import java.util.Stack;

public class MinStack {
	public static Stack<Integer> stack = new Stack<Integer>();
    public static Stack<Integer> minStack = new Stack<Integer>();
    public static void push(int x) {
        stack.push(x);
        if(minStack==null || minStack.isEmpty()){
           minStack.push(x); 
        }
        else{
            if(x <= minStack.peek())
            minStack.push(x);
        }
    }

    public static void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        
        stack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }
    
    public static void main(String args[]){
    	MinStack min = new MinStack();
    	min.push(512);
    	min.push(-1024);
    	min.push(-1024);
    	min.push(512);
    	min.pop();
    	System.out.println(min.getMin());
    	min.pop();
    	System.out.println(min.getMin());
    	min.pop();
    	System.out.println(min.getMin());
    }
}
