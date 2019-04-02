package tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95UniqueBinarySearchTreesTwo {
    public List<TreeNode> generateTrees(int n) {
        // DFS: all possible solutions 
    	// for each number, it has two options, be the current node or not. 
    	if(n <= 0) return new ArrayList<>();
    	return findAllSolutions(1, n); //TODO
    }
    private List<TreeNode> findAllSolutions(int start, int end){
    	// List stores the root node of each custom tree
    	List<TreeNode> res = new ArrayList<>();
    	if(start > end) {
    		res.add(null);
    		return res;
    	}
    	for(int val = start; val <= end; val++ ) {
    		// recursion to get all the left treenodes and right treenodes 
    		List<TreeNode> left = findAllSolutions(start,val - 1);
    		List<TreeNode> right = findAllSolutions(val + 1, end);
    		
    		for(TreeNode l : left) {
    			for(TreeNode r : right) {
    				// actually in either the left list or right list, there is only one node stored
    				TreeNode node = new TreeNode(val);
    				node.left = l;
    				node.right = r;
    				res.add(node);
    				
    			}
    		}
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode95UniqueBinarySearchTreesTwo test = new LeetCode95UniqueBinarySearchTreesTwo();
		List<TreeNode> res = test.generateTrees(3);
		for(TreeNode node : res) {
			
		}

	}

}
