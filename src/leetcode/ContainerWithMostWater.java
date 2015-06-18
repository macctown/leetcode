package leetcode;

public class ContainerWithMostWater {
	public static int maxArea1(int[] height) {
		//O^2 time exceed
		int container = 0;
        for(int i=0;i<height.length-1;i++){
        	int temp = 0;
        	for(int j=i+1;j<height.length;j++){
        		System.out.print("i: "+i);
        		System.out.print(" j: "+j);
        		if(height[j]<height[i]){
        			temp = height[j]*(Math.abs(j-i));
        		}
        		else{
        			temp = height[i]*(Math.abs(j-i));
        		}
        		System.out.println(" temp: "+temp);
        		if(temp > container){
            		container = temp;
            	}
        	}
        	
        }
        
        return container;
    }
	
	
	public static int maxArea(int[] height) {
		int container = 0;
		int i = 0;
		int j = height.length-1;
		//the taller one has more possibility to make the max Area
		//so keep it and change another side
		while(i<j){
			int temp = 0;
			System.out.print("i: "+i);
    		System.out.print(" j: "+j);
			if(height[j]<height[i]){
    			temp = height[j]*(Math.abs(j-i));
    			j--;
    		}
			else{
    			temp = height[i]*(Math.abs(j-i));
    			i++;
    		}
			System.out.println(" temp: "+temp);
			if(temp > container){
        		container = temp;
        	}
		}
		return container;
    }
	
	public static void main(String[] args){
		int[] test = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(maxArea(test));
	}
}
