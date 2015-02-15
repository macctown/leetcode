package leetcode;

import java.util.*;
import java.util.Map.Entry;

public class singleNumber {
	/*
	 * Single Number I
	 * Given an array of integers, every element appears twice except for one. 
	 * Find that single one.
	 * 
	 * Single Number II
	 * Given an array of integers, every element appears three times except for one. 
	 * Find that single one.
	 * 
	 * Note:
	 * Your algorithm should have a linear runtime complexity.
	 * Could you implement it without using extra memory?	 
	 */
	
	public static void main(String args[]){
	
		int[] testArray = {5,2,3,4,3,2,5};
		
		int single1 = findSingle1(testArray);	
		System.out.println("The Single NumberI-1 is: "+single1);
		
		int single2 = findSingle2(testArray);	
		System.out.println("The Single NumberI-2 is: "+single2);
		
		int single3 = findSingle3(testArray);	
		System.out.println("The Single NumberI-3 is: "+single3);
		
		int[] testArray2 = {0,0,0,5};
		
		int single6 = findSingle3(testArray2);	
		System.out.println("The Single NumberII-3 is: "+single6);
	}
	
	public static int findSingle1(int[] givenArray){
		for(int i=0;i<givenArray.length;i++)
		{
			boolean sameSign = false;
			for(int j=i+1;j<givenArray.length;j++)
			{
				if(givenArray[i]==givenArray[j])
				{
					sameSign = true;
					continue;
				}
			}
			if(sameSign == false)
			{
				return givenArray[i];
			}
		}
		return -1;
	}
	
	public static int findSingle2(int[] givenArray){
		int x=0;
		 
        for(int a: givenArray){
            x = x ^ a;
        }
        return x;
	}
	
	public static int findSingle3(int[] givenArray){
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		int count =0;
		
		for(int i=0;i<givenArray.length;i++)
		{
			count = 0;
			if(map.containsKey(givenArray[i])){
				count = (int)map.get(givenArray[i]);
				map.put(givenArray[i], count+1);
			}
			else{
				map.put(givenArray[i],count);
			}
		}
		Iterator i = map.entrySet().iterator();
		int result = 0;
		while (i.hasNext()) {
			Entry entry = (Entry)i.next();
			if((int)entry.getValue()==0)
			{
				result = (int)entry.getKey();
				break;
			}
		}
		return result;
	}
	
	
}
