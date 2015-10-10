package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClosetNumbers {
	public static void main(String[] args) {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try {
			int listSize = Integer.parseInt(input.readLine());
			long[] list = getElements(input.readLine(), listSize);

			// sort this  array
			Arrays.sort(list);

			// find Closest numbers in the array
			printClosestNumbers(list, listSize);

			input.close();
		} catch (NumberFormatException e) {
			System.err.println("Caught NumberFormatException: Error in coverting to interger");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Caught IOException: Error in reading input from stdin");
			e.printStackTrace();
		}
	}
	
	private static long findMinDiff(long[] array, int start, int end) {

		if (start == end) // base case
			return Long.MAX_VALUE;
		else if (end - start == 1) // base case
			return (array[end] - array[start]);

		int mid = (start + end) / 2; // the middle index

		long leftDiff = Math.abs(findMinDiff(array, start, mid)); // calculate the min diff for left side
		long rightDiff = Math.abs(findMinDiff(array, mid + 1, end)); // calculate the min diff for right side

		long diffMid = Math.abs(array[mid + 1] - array[mid]); // for case when we have one element on each side

		return Math.min(diffMid, Math.min(leftDiff, rightDiff)); // return the min of all three differences
	}
	
	private static long[] getElements(String elements, int size) {

		String[] elementsArray = elements.trim().split(" ");

		if (elementsArray.length != size)
			throw new IllegalArgumentException("Number of elements in the list does not match the size provided");

		long[] numbers = new long[size];
		int index = 0;

		// extract integers
		for (String ele : elementsArray) {
			numbers[index++] = Long.parseLong(ele);
		}
		return numbers;
	}

	
	private static void printClosestNumbers(long[] array, int arraySize) {

		long minDiff = findMinDiff(array, 0, arraySize - 1); // find the minimum difference

		for (int i = 0; i < arraySize - 1; i++) { // print all pair of numbers which have the difference between them 
													//equal to minimum diff
			if (Math.abs(array[i + 1] - array[i]) == minDiff) {
				System.out.print(array[i] + " " + array[i + 1] + " ");
			}
		}

	}
}
