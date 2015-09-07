package lintcode;

public class EditDistance {
	/**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public static int minDistance(String word1, String word2) {
        //corner case 
    	if(word1 == null||word2==null){
    		return 0;
    	}
    	//initialize the res array, note: length should plus 1
    	//to avoid the case that the word are empty
    	//Trick: set 1 more when initial all the res array 
    	int[][] dis = new int[word1.length()+1][word2.length()+1];
    	
    	//set value: means change first i string to a empty string, it need to take i changes
    	for(int i=0;i<word1.length()+1;i++){
    		dis[i][0] = i;
    	}
    	for(int i=0;i<word2.length()+1;i++){
    		dis[0][i] = i;
    	}
    	
    	
    	for(int i=1;i<word1.length()+1;i++){
    		for(int j=1;j<word2.length()+1;j++){
    			//dis[i][j] is the result from the min of three kinds of operation:insert, replace and delete
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				//if the two letters are same in the same position
    				dis[i][j] = Math.min(dis[i-1][j-1],Math.min(dis[i-1][j]+1,dis[i][j-1]+1));
    			}
    			else{
    				dis[i][j] = Math.min(dis[i-1][j-1]+1,Math.min(dis[i-1][j]+1,dis[i][j-1]+1));
    			}
    		}
    	}
    	
    	return dis[word1.length()][word2.length()];
    }
    
    public static void main(String atgs[]){
    	String word1="";
    	String word2="";
    	
    	System.out.println(minDistance(word1,word2));
    }                       
}
