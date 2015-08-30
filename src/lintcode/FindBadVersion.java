package lintcode;


/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

public class FindBadVersion {
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
    	int lowerLimit = 0;
    	int higherLimit = n;
    	
    	while(lowerLimit+1<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit)/2;
    		if(!VersionControl.isBadVersion(mid)){
    			lowerLimit = mid+1;
    		}
    		if(VersionControl.isBadVersion(mid)){
    			higherLimit = mid;
    		}
    	}
    	if(VersionControl.isBadVersion(lowerLimit)){
    		return lowerLimit;
    	}
    	else{
    		return higherLimit;
    	}
    	
    }
    
}
