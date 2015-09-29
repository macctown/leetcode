package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {	
	public static int row = 0;
	public static int col = 0;
	
	public static boolean exist(char[][] board, String word) {
        if(board.length==0||board==null){
        	return false;
        }
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
                if(dfs(board, word, 0, i, j, visited)){
                	return true;
                }
        	}
        }
        
        return false;
    }
	
	private static boolean dfs(char[][] board, String word, int indexofChar, int rowIndex,
			int colIndex, boolean[][] visited) {
		//no false until the indexofChar == word.length
		if(indexofChar==word.length()){
			return true;
		}
		if(rowIndex<0||colIndex<0||rowIndex>=row||colIndex>=col){
			return false;
		}
		if(visited[rowIndex][colIndex]==true){
			return false;
		}
		if(board[rowIndex][colIndex]!=word.charAt(indexofChar)){
			return false;
		}
		visited[rowIndex][colIndex] = true;
		
		//look for result to four direction
		boolean res = (dfs(board, word, indexofChar+1, rowIndex+1, colIndex, visited))
				||(dfs(board, word, indexofChar+1, rowIndex, colIndex+1, visited))
				||(dfs(board, word, indexofChar+1, rowIndex-1, colIndex, visited))
				||(dfs(board, word, indexofChar+1, rowIndex, colIndex-1, visited));
		//make it unvisited again for next element
		visited[rowIndex][colIndex] = false;
		
		
		return res;
	}

	public static void main(String args[]){
		
	}
}
