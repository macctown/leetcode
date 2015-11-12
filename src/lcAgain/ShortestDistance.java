package lcAgain;

public class ShortestDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
        int poi = -1; 
        int minDis = Integer.MAX_VALUE;
        
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                //if it's the first time we got word1 or word2, just record its position
                //if it's not the first time and the word[i] right now is diff from word[poi],
                //that means one of them is word1. one of them is word2, then update minDis
                if(poi!=-1 && !words[poi].equals(words[i])){
                    minDis = Math.min(minDis, Math.abs(i-poi));
                }
                poi = i;
            }
        }
        
        return minDis;
    }
}
