package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class PopulatingNextRightPointersinEachNode {
	public static class TreeLinkNode {
	      int val;
	      TreeLinkNode left;
	      TreeLinkNode right;
	      TreeLinkNode next;
	      TreeLinkNode(int x) { val = x; }
	 }
	public static void connect2(TreeLinkNode root) {
		if(root == null){
			return;
		}
		
		if(root.left!=null){
			root.left.next = root.right;
		}
		
		if(root.right!=null&&root.next!=null){
			root.right.next = root.next.left;
		}
		
		connect2(root.left);
		connect2(root.right);
	}
	//bfs, then save each level
	public static void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        List<ArrayList<TreeLinkNode>> list = new ArrayList<ArrayList<TreeLinkNode>>();
        ArrayList<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
        int cur = 1;
        int next = 0;
        
        while(!queue.isEmpty()){
        	TreeLinkNode tmp = queue.poll();
        	cur--;
        	level.add(tmp);
        	
        	if(tmp.left!=null){
        		queue.add(tmp.left);
        		next++;
        	}
        	
        	if(tmp.right!=null){
        		queue.add(tmp.right);
        		next++;
        	}
        	
        	if(cur==0){
        		cur= next;
        		next = 0;
        		level.add(null);
        		list.add(level);
        		level = new ArrayList<TreeLinkNode>();
        		
        	}
        }
        
        for(int i=0;i<list.size();i++){
        	for(int j=0;j<list.get(i).size()-1;j++){
        		list.get(i).get(j).next = list.get(i).get(j+1);
        	}
        }
        
    }
}
