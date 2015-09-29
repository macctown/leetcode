package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums==null||nums.length==0){
			return res;
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int count=0;
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 0);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			if((Integer)entry.getValue()>(nums.length/3)){
				res.add((Integer)entry.getKey());
			}
		}
		
		return res;
    }
}
