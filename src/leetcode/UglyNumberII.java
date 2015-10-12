package leetcode;

import java.util.List;
import java.util.ArrayList;

public class UglyNumberII {
	
	//three lists of ugly number, two is 2,4,8,16... three is 3,9,27... five is 5,25....
	//pick the min of three and add it to res_list, then 
	public int nthUglyNumber(int n) {
        if(n==0){
        	return 0;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int two=0, three=0, five=0;
        
        while(list.size()<n){
        	int next = Math.min(Math.min(list.get(two)*2, list.get(three)*3),list.get(five)*5);
        	list.add(next);
        	
        	if(list.get(two)*2 == next){
        		two++;
        	}
        	
        	if(list.get(three)*3== next){
        		three++;
        	}
        	
        	if(list.get(five)*5 == next){
        		five++;
        	}
        }
        
        return list.get(list.size()-1);
    }
}
