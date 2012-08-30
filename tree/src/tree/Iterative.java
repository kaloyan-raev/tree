package tree;

import java.util.Stack;

public class Iterative {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree();
		listNames(root);
	}
	
	private static void listNames(TreeNode root) {
		// we need this stack to keep track of the current node
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		
		while (current != null) {
			System.out.println(current.getName());
			
			if (current.getChildren().isEmpty()) {
				current = current.getNextSibling();
				if (current == null && !stack.empty()) {
					current = stack.pop(); 
				}
			} else {
				TreeNode next = current.getNextSibling();
				if (next != null) {
					stack.push(next); 
				}
				current = current.getFirstChild();
			}
		}
	}

}
