package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int total = m+n;
		
		for(int i=m-1, j=n-1;total>0;total--){
			System.out.print("array: ");
			for(int o=0;o<nums1.length;o++){
				System.out.print(nums1[o]+" ");
			}
			
			System.out.print("i: "+i);
			System.out.print(" j: "+j);
			System.out.print(" total: "+total);
			System.out.println();
			if(i<0){
				//put all elements left in nums1 in final nums
				System.out.print("nums2: "+nums2[j]);
				nums1[total-1] = nums2[j];
				j--;
			}
			else if(j<0){
				//put all elements left in nums1 in final nums
				nums1[total-1] = nums1[i];
				i--;
			}
			else{
				//compare which one is bigger and put in the back of final nums
				if(nums1[i] > nums2[j]){
					nums1[total-1] = nums1[i];
					i--;
				}
				else{
					nums1[total-1] = nums2[j];
					j--;
				}
			}
		}
		
		
    }
	
	public static void main(String[] args){
		int[] array1 = new int[10];
		int[] array2 = new int[3];
		
		array2[0] = 1;
		 
		
		merge(array1,0,array2,1);
		
	}
}
