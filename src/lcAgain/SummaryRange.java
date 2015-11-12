package lcAgain;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        
        int i=0;
        while(i<nums.length){
            int j=i+1;
            boolean flag = false;
            while(j<nums.length && nums[j]==nums[j-1]+1){
                j++;
                flag = true;
            }
            if(!flag && (j-1 == i)){
                String tmp = String.valueOf(nums[i]);
                res.add(tmp);
            }
            else{
                String tmp = String.valueOf(nums[i])+"->"+String.valueOf(nums[j-1]);
                res.add(tmp);
            }
            i=j;
            flag = false;
        }
        
        return res;
    }
	
	
	public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int pre = nums[0];
        int range = 0;
        
        for (int i = 1; i <= nums.length; i++) {
            if (i != nums.length && nums[i - 1] == nums[i] - 1) {
                range++;
            } else {
                if (range == 0) {
                    result.add(Integer.toString(pre));
                } else {
                    result.add(Integer.toString(pre) + "->" + Integer.toString(pre + range));
                }
                if (i != nums.length) {
                    pre = nums[i];
                    range = 0;
                }
            }
        }
        return result;
    }
}
