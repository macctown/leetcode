package leetcode;

import java.util.*;

public class PascalsTriangle {
	/*
	 * Given numRows, generate the first numRows of Pascal's triangle.

			For example, given numRows = 5,
			Return
			
			[
			     [1],
			    [1,1],
			   [1,2,1],
			  [1,3,3,1],
			 [1,4,6,4,1]
			]
	 */
	
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> PascalsTriangle = new ArrayList<List<Integer>>();
        Integer a[ ][ ] = new Integer[numRows][ ];
		for(int i=0;i<numRows;i++){
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
			List<Integer> list = Arrays.asList(a[i]);
			PascalsTriangle.add(list);
        }
		
		return PascalsTriangle;
    }
	
	public static void main(String[] args){
		List<List<Integer>> PascalsTriangle = generate(5);
		for(int i=0;i<5;i++){
			System.out.print(PascalsTriangle.get(i));
			System.out.println(",");
		}
	}
}
