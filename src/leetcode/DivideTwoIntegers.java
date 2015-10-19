package leetcode;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
        if(dividend == 0){
        	return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) return ~dividend;
       
        //for overflow, change int to long ,but should cast the num before assign it to a long variable
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        long res = 0;
        
        while(d2 <= d1){
        	long c = d2;
        	int i=0;
        	while(c <= d1){
        		d1 = d1-c;
        		c = c <<1;
        		res += 1<<i;
        		i++;
        	}
        }
        
        if(( dividend<0 || divisor<0 ) && !(dividend<0&&divisor<0)){
        	res = 0-res;
        }
        
        return (int)(res);
        
    }
	
	public static void main(String args[]){
		System.out.println(divide(-2147483648, -1));
	}
}
