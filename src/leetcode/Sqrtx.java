package leetcode;

public class Sqrtx {
	public static int mySqrt(int x) {
        long lowerLimit = 0;
        long higherLimit = x/2+1;
        
        while(lowerLimit <= higherLimit){
        	long mid = lowerLimit + (higherLimit - lowerLimit)/2;

            System.out.println(lowerLimit+" "+higherLimit+" "+mid);
        	if(mid * mid < x){
        		lowerLimit = mid+1;
        	}
        	if(mid * mid > x){
        		higherLimit = mid-1;
        	}
        	if(mid * mid == x){
        		return (int)mid;
        	}
        }
        return (int)higherLimit;
    }
	
	public static void main(String args[]){
		System.out.println(mySqrt(10));
	}
}
