package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class HIndex {
	public static int hIndex(int[] citations) {
        if(citations==null||citations.length==0){
        	return 0;
        }
        int index = citations.length-1;
        int mcount = 0;
        int cur = citations.length-1;
        while(index>=0){
        	if(citations[cur]>=index&&mcount+1<=index){
        		if(cur==0){
        			break;
        		}
        		mcount++;
        		cur--;
        	}
        	if(citations[cur]<index){
        		cur--;
        	}
        	if(mcount>index||cur<0){
        		index--;
        		cur=citations.length-1;
        		mcount=0;
        		continue;
        	}
        	
        }
        
        return index;
    }
	
	public static int hIndex2(int[] citations) {
		if(citations==null||citations.length==0){
        	return 0;
        }
		
		Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
	}
	
	public static void main(String args[]){
		int[] test = {3,0,1,5,6};
		System.out.println(hIndex2(test));
	}
}
