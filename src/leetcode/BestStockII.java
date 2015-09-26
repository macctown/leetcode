package leetcode;

public class BestStockII {
	public static int maxProfit(int[] prices) {
		if(prices.length==0||prices==null){
			return 0;
		}
		
		int res = 0;
		//collect all the positive profit
		for(int i=1;i<prices.length;i++){
			if(prices[i]-prices[i-1]>0){
				res += prices[i]-prices[i-1];
			}
		}
		
		return res;
    }
	
	
}
