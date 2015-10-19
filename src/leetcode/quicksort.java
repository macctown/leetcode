package leetcode;

public class quicksort {
	public static int findKthLargest(int[] nums, int k) {
        if(nums.length==0||nums==null){
        	return -1;
        }
        
        return quickSort(nums, nums.length-k, 0, nums.length-1);
    }

	private static int quickSort(int[] nums, int poi, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end){
			return nums[start];
		}
		int m = partition(nums, start, end);
		if(m==poi){
			return nums[m];
		}
		else if(m>poi){
			return quickSort(nums, poi, start, m-1);
		}
		else{
			return quickSort(nums, poi, m+1, end);
		}
	}

	private static int partition(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = nums[start];
		int indexOfPivot = start;
		int indexOfCurrent = start+1;
		
		while(indexOfCurrent <= end){
			if(nums[indexOfCurrent] < pivot){
				indexOfPivot++;
				int tmp = nums[indexOfCurrent];
				nums[indexOfCurrent] = nums[indexOfPivot];
				nums[indexOfPivot] = tmp;
			}
			indexOfCurrent++;
		}
		
		int tmp = nums[indexOfPivot];
		nums[indexOfPivot] = nums[start];
		nums[start] = tmp;
		return indexOfPivot;
	}
	
	
}
