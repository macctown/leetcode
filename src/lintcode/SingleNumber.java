package lintcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	//method: bit
	public static int singleNumber(int[] A) {
		if(A.length == 0){
			return 0;
		}
		
		int res = A[0];
		//use operator ^ (exclusive OR), same^same=0, 0^any=any
		for(int i = 1;i<A.length;i++){
			res = res^A[i];
		}
		
		return res;
	}
	
	
	//method: hashmap
	public static int singleNumber2(int[] B){
		if(B.length == 1){
			return B[0];
		}
		
		//put every element into map, if contains the same key then change its value to 1
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<B.length;i++){
			if(!map.containsKey(B[i])){
				map.put(B[i], 0);
			}
			else{
				map.put(B[i], map.get(B[i])+1);
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
		int[] test = {1,2,2,1,3,4,3};
		System.out.println(singleNumber(test));
	}
}