package leetcode;

public class InsertionSortList {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	
	public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
        	return head;
        }
		ListNode newList = new ListNode(-1);
		ListNode cur = head;
		
		while(cur!=null){
			ListNode next = cur.next;
			ListNode pre = newList;
			
			//move point to the first one less than cur
			while(pre.next!=null&&pre.next.val<=cur.val){
				pre = pre.next;
			}
			//connect cur and the larger one after it
			cur.next = pre.next;
			//connect cur and the pre which less than it
			pre.next = cur;
			
			cur = next;
			
		}
		
		return newList.next;
		
    }
	
	public static void main(String args[]){
		
	}
}
