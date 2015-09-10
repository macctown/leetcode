package lintcode;

import lintcode.MergeTwoSortedList.ListNode;

public class MergeTwoList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  	
  	ListNode dummy = new ListNode(Integer.MAX_VALUE);
  	ListNode newList = dummy;	//dummy node should be the one in the back
  	
  	int count = 0;	//use count to merge two list just by position
		while(l1!=null&&l2!=null){
			if(count%2 ==0){
				newList.next = l1;
				l1 = l1.next;	//make list continue without influence dummy(dummy only record the beginning position)
			}
			else{
				newList.next = l2;
				l2 = l2.next;
			}
			newList = newList.next;
			count++;
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
  	ListNode l2 = new ListNode(5);
  	ListNode l3 = new ListNode(8);
  	ListNode l4 = new ListNode(2);
  	ListNode l5 = new ListNode(3);
  	ListNode l6 = new ListNode(6);
  	

  	l1.next = l2;
  	l2.next = l3;
  	
  	l4.next = l5;
  	l5.next = l6;
  	
  	ListNode res = mergeTwoLists(l1, l4);
  	
  	while(res!=null){
  		System.out.println(res.val);
  		res = res.next;
  	}
	}
}
