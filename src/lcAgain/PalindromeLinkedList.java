package lcAgain;

import leetcode.PartitionList.ListNode;

public class PalindromeLinkedList {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode mid = findMid(head);
        ListNode sec = mid.next;
        mid.next = null;
        ListNode head2 = reverseList(sec);
        
        while(head2!=null&&head!=null){
            if(head2.val != head.val){
            	
                return false;
            }
            else{
            	head2 = head2.next;
                head = head.next;
            }
        }
        
        return true;
        
    }
    
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!= null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode reverseList(ListNode head){
        ListNode p1, p2, p3;
        p1 = head;
        p2 = p1.next;
        
        while(p2!=null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        
        head.next = null;
        head = p1;
        return head;
    }
    
    
    public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(2);
    	ListNode l6 = new ListNode(1);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	System.out.println(isPalindrome(l1));
    }
}
