package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MajorityElement {
	/*
	 * Given an array of size n, find the majority element. 
	 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 */
	
	public static void main(String[] args){
		int[] testArray = {2,2};
		int result = findMajority(testArray);
		
		System.out.println("The majority number is: "+result);
	}
	
	public static int findMajority(int[] num){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<num.length;i++){
			int count = 0 ;
			if(map.containsKey(num[i])){
				count = (int)map.get(num[i])+1;
				map.put(num[i], count);
			}
			else{
				map.put(num[i], count);
			}
		}
		
		Iterator iter = map.entrySet().iterator();
		int result = -1;
		int length = num.length/2;
		if(length < 1){
			return num[0];
		}
		while(iter.hasNext()){
			Entry entry = (Entry)iter.next();
			if(((int)entry.getValue()+1)>length)
			{
				return (int)entry.getKey();
			}
		}
		return result;
	}
}
