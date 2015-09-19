package lintcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SingleNumberII {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public static int singleNumberII(int[] A) {
    	if(A.length == 1){
			return A[0];
		}
		
		//put every element into map, if contains the same key then change its value to 1
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<A.length;i++){
			if(!map.containsKey(A[i])){
				map.put(A[i], 0);
			}
			else{
				map.put(A[i], map.get(A[i])+1);
			}
		}
	
		//NOTE: Remember this! PLZ!
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			if((Integer)entry.getValue()==0){
				return (Integer)entry.getKey();
			}
		}
		
		return 0;
    	
    }
    
    public static void main(String args[]){
    	int[] test = {1,1,2,3,3,3,2,2,4,1};
    	System.out.println(singleNumberII(test));
    }
}
