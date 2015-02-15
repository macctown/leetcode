package leetcode;

public class RemoveElement {
	/*
	 * Given an array and a value, 
	 * remove all instances of that value in place and return the new length.
	 * The order of elements can be changed. 
	 * It doesn't matter what you leave beyond the new length.
	 */
	
	public static void main(String[] args){
		int[] testArray = {4,5,6,5};
		int res = removeElement(testArray,5);
		System.out.println(res);
		
	}
	
	public static int removeElement(int[] A, int elem){
		int res = 0; 
		for(int i=0;i<A.length;i++){
			if(A[i] == elem){
				res++;
			}
		}
		
		return res;
	}
}
