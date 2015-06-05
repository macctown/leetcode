package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
	/*
	 * Given an index k, return the kth row of the Pascal's triangle.
		
		For example, given k = 3,
		Return [1,3,3,1].
		
		Note:
		Could you optimize your algorithm to use only O(k) extra space?
	 */
	public static List<Integer> getRow(int rowIndex) {
		rowIndex++;
		Integer a[ ][ ] = new Integer[rowIndex][ ];
		for(int i=0;i<rowIndex;i++){
			a[i] = new Integer[i+1];
			for(int j=0;j<=i;j++){
				if(j==0){
					a[i][j]=1;
				}
				else if(j==i){
					a[i][j]=1;
				}
				else{
					a[i][j]=a[i-1][j-1]+a[i-1][j];
				}
			}
        }
		List<Integer> list = Arrays.asList(a[rowIndex-1]);
		return list;
    }
	
	public static void main(String[] args){
		List<Integer> list = getRow(0);
		System.out.println(list);
	}
	
}
