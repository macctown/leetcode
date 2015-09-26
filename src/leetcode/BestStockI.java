package leetcode;

public class BestStockI {
	public static int maxProfit(int[] prices) {
        //corner case
		if(prices.length == 0|| prices==null){
        	return 0;
        }
        //initialize
        int maxPrice = prices[prices.length-1];
        int maxDiffer = 0;
        //loop from back to begin, bcz you can only sell after you buy
        //this will find maxPrice from back
        for(int i=prices.length-1;i>=0;i--){
        	maxPrice = Math.max(prices[i], maxPrice);	//find the max Price
        	maxDiffer = Math.max(maxDiffer,maxPrice-prices[i]);	//find the max Differ
        }
        
        return maxDiffer;
    }
	
	public static void main(String args[]){
		
	}
}
