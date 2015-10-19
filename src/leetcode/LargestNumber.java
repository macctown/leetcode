package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	//use customized comparator
	//which combine have larger number, it means large and put it in the front
	public static String largestNumber(int[] num) {  
		int len = num.length;
		String[] arr = new String[len];
		for(int i=0;i<len;i++){
			arr[i] = String.valueOf(num[i]);
		}
		
		Arrays.sort(arr, new MySort());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++){
			sb.append(arr[i]);
		}
		
		String res = sb.toString();
		if ("".equals(res.replace("0",""))) {  
            return "0";  
        }  
		
		return res;
	}
	
	public static class MySort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
	
	public static void main(String args[]){
		int[] num = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(num));
	}
}
