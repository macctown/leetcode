package lintcode;

import java.util.ArrayList;

public class Triangle {
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
	
	
	//note: path is important, bcz the min element of a row may not in the path
	//note2: all the min element cant guarantee the path sum is min, bcz some min-er element in the 
	//       path that contains bigger element, but their path sum is min-est
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle == null || triangle.size() ==0){
    		return 0;
    	}
    	
    	//set some param
    	int tsize = triangle.size();
    	int[][] sum = new int[tsize][tsize];
    	
    	//set the last row
    	for(int i=0;i<tsize;i++){
    		sum[tsize-1][i] = triangle.get(tsize-1).get(i);
    	}
    	
    	//start from last 2nd row and get sum from bottom to up
    	for(int i=tsize-2;i>=0;i--){
    		for(int j=0;j<=i;j++){
    			sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
    		}
    	}
    	
    	return sum[0][0];
    }
    
   
    
    
    public static void main(String args[]){
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> arr1 = new ArrayList<Integer>();
    	arr1.add(1);
    	ArrayList<Integer> arr2 = new ArrayList<Integer>();
    	arr2.add(2);
    	arr2.add(3);
    	ArrayList<Integer> arr3 = new ArrayList<Integer>();
    	arr3.add(1);
    	arr3.add(-1);
    	arr3.add(-3);
    	
    	list.add(arr1);
    	list.add(arr2);
    	
    	System.out.println(minimumTotal(list));
    }
    
}
