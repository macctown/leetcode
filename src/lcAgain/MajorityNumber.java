package lcAgain;

import java.util.HashMap;

public class MajorityNumber {
	public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>(nums.length/2)){
                    return nums[i];
                }
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        return -1;
    }
	
	 public int majorityElement2(int[] nums) {
	        int count = 1;
	        int tmp = nums[0];
	        for(int i=1; i<nums.length; i++){
	            if(count == 0){
	                tmp = nums[i];
	            }
	            if(nums[i] == tmp){
	                count++;
	            }
	            else{
	                count--;
	            }
	        }
	       
	        return tmp;
	    }
}
