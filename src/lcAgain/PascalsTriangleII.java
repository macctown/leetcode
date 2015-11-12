package lcAgain;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        int k = rowIndex + 1;
        
        for(int i=0; i<k ;i++){
            res.add(0);
        }
        
        for(int j=1;j<k+1;j++){
            for(int m=k-1;m>=0;m--){
                if(m==0 || m==k-1){
                    res.set(m, 1);
                }
                else{
                    res.set(m, res.get(m) + res.get(m-1));
                }
            }
        }
        
        return res;
    }
}
