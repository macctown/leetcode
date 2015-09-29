package leetcode;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        if(height==null || height.length==0){
        	return -1;
        }
        
        int left = 0;
        int right = height.length-1;
        int[][] maxArea = new int[right][right];
        maxArea[0][0] = Math.abs(height[1]-height[0]);
        int res = Integer.MIN_VALUE;
        while(left<right){
        	//area = min(i,j)*(j-i)
        	int Area = Math.min(height[left], height[right]) *(right-left);
        	//store the bigger result
        	res = Math.max(res, Area);
        	//move pointer i and j
        	if(height[left]<height[right]){
        		left++;
        	}
        	else if(height[left]>height[right]){
        		right--;
        	}
        	else if(height[left]==height[right]){
        		left++;
        		right--;
        	}
        }
        return res;
        
    }
	
	public static void main(String args[]){
		int[] test = {1,1};
		System.out.println(maxArea(test));
	}
}
