package leetcode;

public class Powxn {
	public static double myPow(double x, int n) {
        if(n<0){
        	return 1/pow(x , -n);
        }
        else{
        	return pow(x , n);
        }
    }

	private static double pow(double x, int n) {
		// TODO Auto-generated method stub
		if(n==0) return 1;
		double half = pow(x, n/2);
		if(n%2==0) 
			return half*half;
		else
			return half*half*x;
	}
	
	
	public static void main(String args[]){
		System.out.println(myPow(3,3));
	}
	
	
}
