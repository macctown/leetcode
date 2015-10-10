package leetcode;

import java.util.Arrays;

public class ZigZagArray {
	
	public static int[] ZigZag(int[] arr){
		int[] result = new int[arr.length];
		if(arr == null || arr.length == 0){
			return result;
		}
		Arrays.sort(arr);
		//get mid, then reverse the part after mid
		//merge head->mid, and mid->end
		int countE = 1;
		int countS = 0;
 		for(int i=0;i<arr.length;i++){
			if(i%2!=0){
				result[i] = arr[countS];
				countS ++;
			}
			else{
				result[i] = arr[arr.length-countE];
				countE++;
			}
		}
		return result;		
	}
	public static void main(String args[]){
		int[] test = {3,6,7,9,-3};
		int[] test2 = {};
		int[] res = ZigZag(test2);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
