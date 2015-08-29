package lintcode;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {
	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	boolean flag = false;
    	int poi = 0;
    	int size = nums.size();
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	for(int i=0;i<nums.size()-1;i++){
    		if((nums.get(i)-nums.get(i+1))>0){
    			poi = i;	//find the rotated position 
    			flag = true;
    		}
    		if(flag == true){
    			tmp.add(nums.get(i+1));	//get the elements after rotated position
    		}
    	}
    	
    	if(flag != false){//not run if the array is already in order
    		//add elements from back to start
	    	for(int j=size;j>0;j--){
	    		if(poi>=0){
	        		nums.set(j-1, nums.get(poi));	//add elements in origin array first(bigger)
	    			poi--;
	    		}
	    		else{
	    			nums.set(j-1, tmp.get(j-1));	//add elements from tmp array later(smaller)
	    		}
	    	}
    	}
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> test = new ArrayList<Integer>();
    	test.add(3);
    	test.add(4);
    	test.add(0);
    	test.add(1);
    	test.add(2);
    	recoverRotatedSortedArray(test);
    	for(int i=0;i<test.size();i++){
    		System.out.println(test.get(i));
    	}
    }
}
