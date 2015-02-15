package leetcode;

import java.util.*;

public class TwoSum {
	    public static int[] twoSum(int[] numbers, int target) {
	        int[] a = {0,0};
	        for(int i=0;i<numbers.length;i++){
	            for(int j=1;j<numbers.length;j++){
	                if(numbers[i]+numbers[j]==target&&i<j){
	                    a[0]=i+1;
	                    a[1]=j+1;
	                    return a;
	                }
	            }
	        }
	        return a;
	    }
	    
	    public static int[] twoSum2(int[] numbers, int target){
	    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	int[] a = {0,0};
	    	
	    	for(int i=0;i<numbers.length;i++)
	    	{
	    		if(map.containsKey(numbers[i]))
	    		{
	    			int index = map.get(numbers[i]);
	    			a[0] = index+1;
	    			a[1] = i+1;
	    			break;
	    		}
	    		else{
	    			map.put(target-numbers[i], i);
	    		}
	    		System.out.println(map); 
	    	}
	    	return a;
	    }
	    
	    public static void main(String args[]){
	    	int[] test ={2,7,11,15};
	    	int tar = 17;
	    	int[] res = new int[2];
	    	int[] res2 = new int[2];
	    	res = twoSum(test, tar);
	    	res2 = twoSum2(test, tar);
	    	
	    	System.out.println(res[0]+" "+res[1]);
	    	System.out.println(res2[0]+" "+res2[1]);
	    }
	
	
}
