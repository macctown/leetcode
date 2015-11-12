package lcAgain;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<9; i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(set.contains(board[i][j])){
                    return false;
                }
                else{
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        
        for(int i=0; i<9; i++){
            for(int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(set.contains(board[j][i])){
                    return false;
                }
                else{
                    set.add(board[j][i]);
                }
            }
            set.clear();
        }
        
        //looop the 9 blocks
        for(int i=0; i<9; i=i++){
            for(int j=i/3*3;j<i/3*3+3;j++){
                for(int k=(i%3)*3; k<(i%3)*3+3; k++){
                    if(board[j][k]=='.'){
                        continue;
                    }
                    if(set.contains(board[j][k])){
                        return false;
                    }
                    else{
                        set.add(board[j][k]);
                    }
                }
                
            }
            set.clear();
        }
        
        return true;
        
    }
}
