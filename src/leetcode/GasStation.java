package leetcode;

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0 || cost.length==0){
        	return 0;
        }
        
        int start = 0;
        int total = 0;
        int startIndex = -1;
        
        for(int i=0;i<gas.length;i++){
        	start = gas[i] - cost[i];
        	total += gas[i] - cost[i];
        	if(start < 0){
        		//means gas[i] is not good to start
        		start = 0;
        		startIndex = i+1;
        	}
        }
        
        if(total < 0){
        	return -1;
        }
        else{
        	return startIndex;
        }
    }
}
