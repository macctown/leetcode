package lcAgain;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return res;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        res.add(tmp);
        if(numRows == 1){
            return res;
        }
        
        for(int i=2;i<=numRows; i++){
            tmp = new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(j==0){
                    tmp.add(1);
                }
                else if(j == i-1){
                    tmp.add(1);
                }
                else{
                    tmp.add(res.get(i-2).get(j)+res.get(i-2).get(j-1));
                }
            }
            res.add(tmp);
        }
        
        return res;
    }
}
