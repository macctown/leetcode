package leetcode;

import java.util.Stack;

public class SimplifyPath {
	//1.delete duplicate '/' and get all element use split
	//2.check different situation
	// . and / do nothing
	//  .. pop
	// use equals to compare strings
	public static String simplifyPath(String path) {
       	StringBuilder res = new StringBuilder();
		if(path == null || path.length()==0){
        	return res.toString();
        }
		
		String[] arr = path.split("/");
	
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(".") || arr[i].length()==0){
				continue;
			}
			
			if(arr[i].equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
			else{
				stack.push(arr[i]);
			}
		}
		
		Stack<String> tmp = new Stack<String>();
		while(!stack.isEmpty()){
			tmp.push(stack.pop());
		}
		
		while(!tmp.isEmpty()){
			res.append("/"+tmp.pop());
		}
		
		if(res.length() == 0){
			res.append("/");
		}
		
		return res.toString();
    }
	
	
	public static void main(String args[]){
		String test = "//a/./b/../..//";
		System.out.println(simplifyPath(test));
	}
}
