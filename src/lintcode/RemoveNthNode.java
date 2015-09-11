package lintcode;

import lintcode.ReverseLinkedListII.ListNode;

public class RemoveNthNode {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	//or use length to calculate the position need to delete from beginning of list
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n==0){
    		return head;
    	}
    	ListNode rList = reverseList(head);
    	//get the length
    	
    			int length = getLength(rList);
    			
    			//n=1
    			if(n==1){
    				rList = rList.next;
    				return reverseList(rList);
    			}
    			
    			//0<n<=length
    			if(n>1&&n<=length){
    				ListNode p0 = rList;
    				int count=1;
    				while(p0!=null){
    					if(count==n-1){
    						p0.next = p0.next.next;
    						return reverseList(rList);
    					}
    					p0 = p0.next;
    					count++;
    				}
    			}
    			
    			return head;
    	
    }
    
    public static int getLength(ListNode head){
		int len = 0;
		while(head!=null){
			len++;
			head = head.next;
		}
		
		return len;
	}
    
    public static ListNode reverseList(ListNode head){
    	if(head == null||head.next==null){
    		//the condition have order, head==null need to be put at the first
    		return head;
    	}
    	ListNode p1,p2,p3;
    	p1 = head;
    	p2 = p1.next;
    	while(p2!=null){
    		p3 = p2.next;
    		p2.next = p1;
    		p1=p2;
    		p2=p3;
    	}
    	
    	head.next = null;
    	head = p1;
    	return head;
    }
    
    public static void main(String args[]){
    	ListNode l1 = new ListNode(1);

    	
    	ListNode res = removeNthFromEnd(l1,1);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
