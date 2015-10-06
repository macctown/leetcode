package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FrogJump {
	//INPUT: Given array for position and time info of leaf
	//       Destination position
	//       Max step the frog could jump each time
	//OUTPUT: The earliest time the frog could reach his destination
	public int solution(int[] leaf, int dest, int maxStep) {
        //corner case
		if(leaf == null || leaf.length == 0 || dest < maxStep){
			return 0;
		}
		
		//initialization
		//key: position of leaf, value: earliest reach time
		HashMap<Integer, Integer> arriveTime = new HashMap<Integer, Integer>();
		arriveTime.put(0, 0);
		arriveTime.put(dest, Integer.MIN_VALUE);
		
		for(int i=0;i<leaf.length;i++){
			if(!arriveTime.containsKey(leaf[i]))
				arriveTime.put(leaf[i], i);
		}
		
		//earliest time reach the position
		int[] res = new int[dest + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		
		//loop from start to the dest
		for(int i=1;i<=dest;i++){
			//arrive the position we stored before
			if(arriveTime.containsKey(i))
				if(i <= maxStep)
					res[i] = arriveTime.get(i);
				else
					//get min time to reach target position by j steps
					for(int j=1;j<=maxStep;j++){
						//compare time of j steps to position i and time of reach i directly
						if(res[i-j] < arriveTime.get(i))
							res[i] = Math.min(arriveTime.get(i), res[i]);
						else
							res[i] = Math.min(res[i-j], res[i]);
					}
		}
		
		
		return res[dest]==Integer.MAX_VALUE ? -1 : res[dest];	
    }
}
