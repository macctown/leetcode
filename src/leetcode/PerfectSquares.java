package leetcode;

import java.util.Arrays;

public class PerfectSquares {
	public static int numSquares1(int n) {  
		
		//how many square number could consist of number i
		int[] res = new int[n+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		
		for(int i=0;i<n;i++){
			//loop each number
			for(int j=1; i+j*j<=n;j++){
				//j is the square number we can try, we try each one and to see which one could get the min res
				//we cmp the answer we calculate before(use Integer.MAX when no answer before) and the new one(res[i]+1, 1 means the j we add this time)
				//but the sum cannot exceed n
				int restmp = res[i+j*j];
				res[i+j*j] = Math.min(res[i+j*j], res[i]+1);
				System.out.println("res["+i+"]: "+res[i]+"   j:"+j+"  res["+(i+j*j)+"]:"+restmp+" res["+(i)+"]+1:"+(res[i]+1)+"  res["+(i+j*j)+"]:"+res[i+j*j]);
			}
		}
		
		return res[n];
	}
	
	public int numSquares2(int n) {  
		
	}
	
	public static void main(String args[]){
		System.out.println(numSquares1(12));
	}
}
