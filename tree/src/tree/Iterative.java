package tree;

import java.util.Iterator;
import java.util.Stack;

public class Iterative {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree();
		listNames(root);
	}
	
	private static void listNames(TreeNode root) {
		// we need this stack to keep track how deep we are traversing the tree
		Stack<Iterator<TreeNode>> stack = new Stack<Iterator<TreeNode>>();
		
		TreeNode current = root;
		
		do {
			System.out.println(current);
			
			Iterator<TreeNode> iterator = current.getChildren().iterator();
			if (iterator.hasNext()) { 
				// the current node has some children
				// save the iterator's state in the stack
				stack.push(iterator);
				// the first child becomes the current node
				current = iterator.next();
			} else { 
				// the current node is a leaf
				while (!stack.isEmpty()) {
					// get the last saved iterator from the stack
					iterator = stack.peek();
					if (iterator.hasNext()) {
						// the next sibling becomes the current node
						current = iterator.next();
						break;
					} else {
						// no more siblings - remove the iterator from the stack
						stack.pop();
					}
				}
			}
		} while (!stack.isEmpty());
	}
	
}
