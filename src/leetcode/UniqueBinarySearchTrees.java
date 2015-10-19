package leetcode;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        if(n==0){
        	return 0;
        }
        
        //how many unique BST there is when we have i elements 
        int[] res = new int[n+1];
        res[0] = 1;	//empty tree
        res[1] = 1;	// single node tree
        
        for(int i=2;i<=n;i++){
        	for(int j=0;j<i;j++){
        		res[i] += res[j] * res[i-j-1]; 
        	}
        }
        
        return res[n];
    }
}
