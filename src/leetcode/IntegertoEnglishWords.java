package leetcode;

import java.util.HashMap;

public class IntegertoEnglishWords {
	public static String numberToWords(int num) {
        String res = "";
        if(num == 0){
        	return "Zero";
        }
        HashMap<Integer, String> map = new HashMap<Integer, String> ();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");     
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
        
        //divide number into xxx,xxx,xxx
        int[] division = {1000000000, 1000000, 1000, 1};
        for(int d : division){
        	if(num/d > 0){
        		res += helper(map, num/d);
        		if(d > 1)
        			res += map.get(d)+" ";
        	}
        	num = num % d;
        }
        
        return res.trim();
        
    }

	private static String helper(HashMap<Integer, String> map, int i) {
		// TODO Auto-generated method stub
		String res = "";
		if(i/100>0){
			res += map.get(i/100)+" ";
			res += map.get(100)+" ";
			i = i %100;
		}
		if(i/20 > 0){
			res += map.get(i-i%10)+" ";
			i = i %10;
		}
		if(i>0){
			res += map.get(i)+" ";
		}
		return res;
	}
	
	public static void main(String args[]){
		System.out.println("'"+numberToWords(12345)+"'");
	}
	
}
