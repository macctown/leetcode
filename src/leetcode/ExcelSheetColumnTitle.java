package leetcode;

import java.util.Collections;

public class ExcelSheetColumnTitle {
	
	
	public static String convertToTitle2(int n) {
        String tmpRes = "";
        if(n == 0){
        	return tmpRes;
        }
        
        while(n>0){
        	n--;
        	char tmp = (char)(n%26 + 'A');
        	n = n/26;
        	tmpRes += tmp;
        }
        	
        StringBuffer res = new StringBuffer(tmpRes);
        
        
        return res.reverse().toString();
    }
	
	public static void main(String args[]){
		System.out.println(convertToTitle2(53));
	}
}
