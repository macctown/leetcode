package lcAgain;

public class AddBinary {
	public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        String res = "";
        int maxLen = Math.max(lenA, lenB);
        
        for(int i=0;i<maxLen;i++){
            int A = 0;
            int B = 0;
            if(i<lenA){
                A = a.charAt(lenA-i-1)-'0';
            }
            else{
                A = 0;
            }
            
            if(i<lenB){
                B = b.charAt(lenB-i-1)-'0';
            }
            else{
                B = 0;
            }
            
            int tmp = A+B+carry;
            carry = tmp/2;
            res = String.valueOf(tmp%2) + res;
        }
        if(carry == 1){
            res = "1"+res;
        }
        return res;
    }
}
