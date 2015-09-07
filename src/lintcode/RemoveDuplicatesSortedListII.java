package lintcode;

public class RemoveDuplicatesSortedListII {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		 }
	 }
	
    public static ListNode deleteDuplicates(ListNode head) {
        //set a dummy node before the given list
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(Integer.MIN_VALUE);
    	dummy.next = head;
    	head = dummy;
    	
    	//loop from first one to the 2nd last of LinkedList
    	while(head.next!=null&&head.next.next!=null){
    		if(head.next.val==head.next.next.val){
    			int val = head.next.val;
    			while(head.next != null&&head.next.val == val ){
    				//the condition: to guarantee the next one is same as the node now and next is not a null	
    				//move point forward
    				head.next = head.next.next;
    			}
    		}
    		else{
    			//node.next differ from node.next.next
    			
    			head = head.next;
    		}
    	}
    	return dummy.next;
    }
    
    public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(3);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	
    	
    	ListNode res = deleteDuplicates(l1);
    	/*for(ListNode node=res;node.next!=null;node=node.next){
    		System.out.println(node.val);
    	}*/
    }
    
    
}
