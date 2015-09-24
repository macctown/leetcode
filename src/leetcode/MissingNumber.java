package leetcode;

public class MissingNumber {
	
	//use sum, add all elements suppose to be in the array and then delete all actually in array
	//TC: O(n)
	public static int missingNumber(int[] nums) {
		int sum = 0;
		//add all the elements should be in the nums(include the missing one)
		for(int i=0;i<=nums.length;i++){
			sum += i;
		}
		//delete all the elements in nums, and the left is the result
		for(int j=0;j<nums.length;j++){
			sum -= nums[j];
		}
		
		return sum;
    }


	public static void main(String args[]){
		int[] test1 = {};
		int[] test2 = {0,1,3};
		int[] test3 = {1};
		System.out.println(missingNumber(test1));
		System.out.println(missingNumber(test2));
		System.out.println(missingNumber(test3));
	}
}
