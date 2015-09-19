package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
	
	//method: hashmap
    public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
    	if(nums == null || nums.size()==0){
    		return -1;
    	}
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int count = 1;
    	for(int i=0;i<nums.size();i++){
    		if(map.containsKey(nums.get(i))){
        		map.put(nums.get(i), map.get(nums.get(i))+1);
    		}
    		else{
        		map.put(nums.get(i), count);
    		}
    	}
    	
    	int mid = nums.size()/2+1;
    	Iterator it = map.entrySet().iterator();
    	while(it.hasNext()){
    		Entry entry = (Entry)it.next();
    		if((Integer)entry.getValue() >= mid){
    			return (Integer)entry.getKey();
    		}
    	}
    	
    	return -1;
    }
    
    //method: space O(1)
    public static int majorityNumber2(ArrayList<Integer> nums) {
        // write your code
    	if(nums == null || nums.size()==0){
    		return -1;
    	}
    	
    	int length = nums.size();
    	int count = 0;
    	int candidate = 0;
    	for(int i=0;i<length;i++){
    		if(count == 0){
    			candidate = nums.get(i);
    			count++;
    		}
    		else if(nums.get(i) == candidate){
    			count++;
    		}
    		else if(nums.get(i) != candidate){
    			count--;
    		}
    	}
    	
    	return candidate;
    }
    
    public static void main(String args[]){
    	ArrayList<Integer> test = new ArrayList<Integer>();
    	test.add(1);test.add(1);
    	test.add(1);test.add(1);
    	test.add(2);test.add(2);
    	test.add(2);
    	System.out.println(majorityNumber2(test));
    }
}
