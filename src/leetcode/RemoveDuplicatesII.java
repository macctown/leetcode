package leetcode;

import leetcode.RemoveDuplicatesfromSortedList.ListNode;

public class RemoveDuplicatesII {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null||head.next == null){
			return head;
		}
		//need a third node to point the pre
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode cur = dummy.next;
		ListNode after = dummy.next.next;
		
		boolean flag = false;
		while(after!=null){
			if(cur.val == after.val){
				flag = true;
				//move after until the a differ one
				after = after.next;
				//if after get null, it means, 1,2,3,4,4,4,4,4
				if(after == null){
					pre.next = null;
				}
			}
			else{
				if(flag == true){
					//more than two same elements
					pre.next = after;	//skip all the duplicate elements
					flag = false;
				}
				else{
					//when found adjecent different elemebts
					pre = cur;
				}
				cur = after;
				after = after.next;
			}
		}
		
		return dummy.next;
	}
	
	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	

    	l1.next = l2;
    	ListNode res = deleteDuplicates(l1);
    	
    	while(res!=null){
    		System.out.print("res:"+res.val);
    		res = res.next;
    	}
    }
	
}
