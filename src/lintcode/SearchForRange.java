package lintcode;

import java.util.ArrayList;

public class SearchForRange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
    	//note: else...if in while-loop
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(A.size()==0){
    		res.add(-1);
    		res.add(-1);
    		return res;
    	}
    	
    	int lowerLimit = 0;
    	int higherLimit = A.size()-1;
    	
    	while(lowerLimit+1<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit) / 2;
    		if(A.get(mid)<target){
    			lowerLimit = mid;
    		}
    		else if(A.get(mid)>target){
    			higherLimit = mid;
    		}
    		else if(A.get(mid)==target){
    			higherLimit = mid;
    		}
    	}
    	
    	if(A.get(lowerLimit)==target){
    		res.add(0,lowerLimit);
    	}
    	else if(A.get(higherLimit)==target){
    		res.add(0,higherLimit);
    	}
    	else{
    		res.add(-1);
    		res.add(-1);
    		return res;
    	}
    	
    	lowerLimit = 0;
    	higherLimit = A.size()-1;
    	
    	while(lowerLimit+1<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit) / 2;
    		if(A.get(mid)<target){
    			lowerLimit = mid;
    		}
    		else if(A.get(mid)>target){
    			higherLimit = mid;
    		}
    		else if(A.get(mid)==target){
    			lowerLimit = mid;
    		}
    	}
    	
    	if(A.get(higherLimit)==target){
    		res.add(1,higherLimit);
    	}
    	else if(A.get(lowerLimit)==target){
    		res.add(1,lowerLimit);
    	}
    	else{
    		res.add(-1);
    		res.add(-1);
    		return res;
    	}
    	
    	return res;
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> test = new ArrayList<Integer>();
    	test.add(9);
    	test.add(10);
    	test.add(100);
    	test.add(101);
    	test.add(1002);
    	test.add(10203);
    	System.out.println(searchRange(test, 10203));
    }
}
