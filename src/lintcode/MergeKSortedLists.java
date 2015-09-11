package lintcode;

import java.util.List;

import lintcode.MergeTwoSortedList.ListNode;

public class MergeKSortedLists {
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	//divide list into pair and merge them use "mergeSortedList"
	 public static ListNode mergeKLists(List<ListNode> lists) {  
		 //corner case, null and the list has no linkedlist
		 if(lists == null || lists.size()==0){
	    		return null;
	    	}
	    	
	    	int length = lists.size();
	    	return mergeHelper(lists, 0, length-1);
	    }
	    
	    private static ListNode mergeHelper(List<ListNode> lists, int i, int j) {
			//when i==j, just get the exact list
	    	if(i==j){
	    		return lists.get(i);
	    	}
	    	//get mid point
	    	int mid = (j-i)/2+i;
	    	//divide into left and right
	    	ListNode left = mergeHelper(lists, i, mid);
	    	ListNode right = mergeHelper(lists, mid+1, j);
	    	//merge left and right into one(sorted list)
			return mergeTwoLists(left, right);
		}
	    
	    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	
	    	ListNode dummy = new ListNode(Integer.MAX_VALUE);
	    	ListNode newList = dummy;	//dummy node should be the one in the back
	    	
			while(l1!=null&&l2!=null){
				if(l1.val<=l2.val){
					newList.next = l1;
					l1 = l1.next;	//make list continue without influence dummy(dummy only record the beginning position)
				}
				else{
					newList.next = l2;
					l2 = l2.next;
				}
				newList = newList.next;
			}
			
			//if some one has extra node, append it behind the newList
			if(l1!=null){
				newList.next = l1;
			}
			if(l2!=null){
				newList.next = l2;
			}
			
			
			return dummy.next;
	    }

	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(4);
    	ListNode l3 = new ListNode(2);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	
    	l1.next = l2;
    	l3.next = l4;
    	l5.next = l6;
    	
    	List<ListNode> test = new List<ListNode>();
    	test.add(l1);
    	test.add(l2);
    	test.add(l3);
    	ListNode res = mergeKLists(test);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
    
    
}
