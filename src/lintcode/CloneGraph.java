package lintcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	class UndirectedGraphNode {
		 int label;
		 ArrayList<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //corner case
    	if(node == null){
        	return null;
        }
        
    	//store all the nodes
    	ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        //store all the nodes in hashmap, so that it could be checked by key&value
    	HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
    	//start from the given node
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        int start = 0;
        while(start < nodes.size()){
        	UndirectedGraphNode head = nodes.get(start);
        	start++;
        	//loop for get the neighbor of the node
        	for(int i=0;i<head.neighbors.size();i++){
        		UndirectedGraphNode nei = head.neighbors.get(i);
        		//if it's a new one, add it to map and list
        		if(!map.containsKey(nei)){
        			map.put(nei, new UndirectedGraphNode(nei.label));
        			nodes.add(nei);
        		}
        	}
        }
        
        //copy neighbor of each node
        for(int i=0;i<nodes.size();i++){
        	UndirectedGraphNode newNode = map.get(nodes.get(i));
        	for(int j =0;j<nodes.get(i).neighbors.size();j++){
        		newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
        	}
        }
        
        return map.get(node);
    
    }
    
    public static void main(String args[]){
    	
    }
}
