package lintcode;

import lintcode.RemoveDuplicatesSortedListII.ListNode;

public class SortList {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	//time limit exceeded
    public static ListNode sortList(ListNode head) {  
        //corner case
    	if(head == null){
        	return head;
        }
    	
        ListNode maxP = head;
        ListNode p0 = head;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //use loop to get max and min value of the given list
        while(maxP!=null){
        	min = Math.min(min, maxP.val);
        	max = Math.max(max, maxP.val);
        	maxP = maxP.next;
        }
        
        //use partition to sort
        for(int i=min;i<=max;i++){
        	head = partition(head, i);
        }
    	
    	return head;
    }
    
    
    public static ListNode partition(ListNode head, int x) {
        //corner case
    	if(head == null){
        	return head;
        }

        ListNode lDummy = new ListNode(Integer.MIN_VALUE);
        ListNode gDummy = new ListNode(Integer.MAX_VALUE);
        ListNode p0 = head, pl = lDummy, pg = gDummy;
        //loop from the first node of given list to the last
        while(p0!=null){
        	if(p0.val < x){
        		//if its value less than target, then make it into the lessList
        		pl.next = p0; //lDummy.next = p0(only the first time), so it records the beginning of pl
        		pl = p0;	//bcz here pl change his direction
        	}
        	else{
        		//if its value greater than or equals to target, then make it into the greaterList
        		pg.next = p0;	//gDummy.next = p0(only the first time), so it records the beginning of pg
        		pg = p0;	
        	}
        	p0 = p0.next;	//move the pointer towards
        }
        
        pg.next = null;		//make the greaterList ends with null
        pl.next = gDummy.next;	//connect lessList and greaterList
        
        return lDummy.next;
        
    }
    
  
    //mergeSort
    public static ListNode sortList2(ListNode head) {  
    	if(head == null ||head.next == null){
    		return head;
    	}
    	//divide & conquer
    	ListNode mid = sfMiddle(head);
    	
    	ListNode right = sortList2(mid.next);
    	mid.next = null;
    	ListNode left = sortList2(head);
    	
    	return mergeTwoLists(left, right);
    	
    }
    
    public static ListNode sfMiddle(ListNode head){
    	ListNode slow = head;	//point to head, move 2times slower than pointer "fast"
    	ListNode fast = head;	//point to head, then move 2 times faster than pointer "slow"
    	//then when "fast" get the end of list, "slow" should be pointed at the middle
    	while(fast.next!=null&&fast.next.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
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
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(2);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	
    	ListNode res = sortList2(l1);
    	
    	while(res!=null){
    		//System.out.println(res.val);
    		res = res.next;
    	}
    }
}
