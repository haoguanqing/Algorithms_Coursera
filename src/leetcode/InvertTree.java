package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return val + "-("+left.toString()+","+right.toString()+")";
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root==null){return root;}
		
		TreeNode invertedRoot = new TreeNode(root.val);
		invertedRoot.left = invertTree(root.right);
		invertedRoot.right = invertTree(root.left);
		return invertedRoot;
	}

	/**
	 * use Queue to implement the inversion operation
	 * BFS
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root==null){return root;}
		
		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			final TreeNode node = queue.poll();
			final TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if(node.left!=null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}
		}
		return root;
	}
}
