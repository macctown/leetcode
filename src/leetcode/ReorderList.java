package leetcode;

import leetcode.InsertionSortList.ListNode;

public class ReorderList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	//reverse first, then merge two
	public static void reorderList(ListNode head) {
        if(head == null||head.next==null){
        	return;
        }
        
        ListNode reverseNode = sfMiddle(head);
        ListNode reverseList = reverse(reverseNode.next);
        reverseNode.next = null;
        
        MergeTwoList(head, reverseList);
        
    }

	private static ListNode sfMiddle(ListNode head) {
		// TODO Auto-generated method stub
		if(head==null){
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		
		if(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private static void MergeTwoList(ListNode list1, ListNode list2) {
		// TODO Auto-generated method stub
		
		ListNode newList = new ListNode(0);
		
		int count = 0;
		while(list1!=null&&list2!=null){
			if(count%2==0){
				newList.next = list1;
				//newList = list1;
				list1 = list1.next;
			}
			else{
				newList.next = list2;
				//newList = list2;
				list2 = list2.next;
			}
			newList = newList.next;
			count++;
			
		}
		
		if(list1!=null){
			newList.next = list1;
		}
		else if(list2!=null){
			newList.next = list2;
		}
		
	}

	private static ListNode reverse(ListNode head) {
		// TODO Auto-generated method stub
		if(head == null){
			return head;
		}
		
		ListNode p1, p2,p3;
		p1 = head;
		p2 = p1.next;
		
		while(p2!=null){
			p3 = p2.next;
			p2.next =p1;
			p1=p2;
			p2=p3;
		}
		
		head.next = null;
		head = p1;
		
		return head;
	}
	
	
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	
    	reorderList(l1);
    	
    	
	}
	
}
