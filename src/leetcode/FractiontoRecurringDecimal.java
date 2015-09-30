package leetcode;

import java.util.HashMap;

public class FractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
        	return "0";
        }
        if(denominator==0){
        	return "";
        }
        
        String res = "";
        
        //negative number
        //use ^, bcz only when they have differ sign, the number will be negative 
        if(numerator<0^denominator<0){
        	res+="-";
        }
        
        //avoid overflow
        long num = numerator;
        long den = denominator;
        //convert to long first, bcz up-limit of int and long is different
        num = Math.abs(num);
        den = Math.abs(den);
        
        //before dot
        long tmp = num/den;	
        res += String.valueOf(tmp);
        
        //divisible
        long rem = (num%den)*10;	//remain part
        if(rem==0) return res;
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        res +=".";
        
        //exit until get divisible
        while(rem!=0){
        	if(map.containsKey(rem)){
        		int start = map.get(rem);
        		String before = res.substring(0, start);
        		String after = res.substring(start, res.length());
        		res = before + "("+after+")";
        		return res;
        		
        	}
        	else{
        		//the length here is before add the digit
        		//the length could be used to get the beginning of repeat part
        		map.put(rem, res.length());	
        		tmp = rem/den;	//next digit
        		res += String.valueOf(tmp);
        		rem = (rem%den)*10;	//remain part
        	}
        }
        
        return res;
        
    }
	
	
	public static void main(String args[]){
		System.out.println(fractionToDecimal(1,5));
	}
	
}
