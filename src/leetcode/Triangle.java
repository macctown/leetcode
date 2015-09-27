package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	//bottom-up
	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0||triangle==null){
        	return 0;
        }
        int m = triangle.size();
        int[][] sum = new int[m][m];
       //initialize the last row
        for(int k=0;k<m;k++){
        	sum[m-1][k] = triangle.get(m-1).get(k);
        }
        
        for(int i=m-2;i>=0;i--){
        	for(int j=0;j<=triangle.get(i).size()-1;j++){
        		sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1])+triangle.get(i).get(j);
        	}
        }
        
        return sum[0][0];
        
    }
	
	public static void main(String args[]){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
    	ArrayList<Integer> arr1 = new ArrayList<Integer>();
    	arr1.add(2);
    	ArrayList<Integer> arr2 = new ArrayList<Integer>();
    	arr2.add(3);
    	arr2.add(4);
    	ArrayList<Integer> arr3 = new ArrayList<Integer>();
    	arr3.add(6);
    	arr3.add(5);
    	arr3.add(7);
    	
    	list.add(arr1);
    	list.add(arr2);
    	
    	System.out.println(minimumTotal(list));
	}
}
