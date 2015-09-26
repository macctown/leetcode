package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MajorityElement {
	//1.hashmap store appear times and then judge
	public static int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0){
        	return -1;
        }
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], count);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			if((Integer)entry.getValue() >= nums.length/2){
				return (Integer)entry.getKey();
			}
		}
		
        return 0;
    }
	
	//2.count appear times, the one left is the one appear more than n/2
	public static int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        
        int count = 1;
        int tmp = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(count == 0){
        		tmp = nums[i];
        	}
        	if(tmp == nums[i]){
        		count++;
        	}
        	else{
        		count--;
        	}
        }
        
        return tmp;
        
    }
	
	public static void main(String args[]){
		int[] test1 = {};
		int[] test2 = {1,2,1,1,3,1,2,1};
		int[] test3 = {1};
		System.out.println(majorityElement(test1));
		System.out.println(majorityElement(test2));
		System.out.println(majorityElement(test3));
	}
}
