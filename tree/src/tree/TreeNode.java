package tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Implements a simple tree structure.
 * 
 * <p>
 * Tree nodes have only name as a containing data.
 * </p>
 * 
 * <p>
 * New tree can be created by calling the constructor of this class to create
 * the root node, and then calling the <code>add()</code> method to add more
 * nodes.
 * </p>
 * 
 * <p>
 * The complete tree can be listed by calling the <code>list()</code> method on
 * the root node. The traversal algorithm does not use recursion and therefore
 * can list trees with significant depth.
 * </p>
 * 
 * @see #add(String)
 * @see #list()
 */
public class TreeNode {

	private TreeNode parent;
	private Set<TreeNode> children;

	private String name;

	/**
	 * Creates a new tree containing only a root node with the given name.
	 * 
	 * <p>
	 * Any other nodes can be added to the tree by calling the
	 * <code>add()</code> method.
	 * 
	 * @param name
	 *            the name set on the root node.
	 * 
	 * @see #add(String)
	 */
	public TreeNode(String name) {
		this(name, null);
	}

	private TreeNode(String name, TreeNode parent) {
		this.name = name;
		this.parent = parent;
		this.children = new HashSet<TreeNode>();
	}

	/**
	 * Returns the parent of the current node.
	 * 
	 * @return a tree node that is the parent of the current one, or
	 *         <code>null</code> if the current node is the root.
	 */
	public TreeNode getParent() {
		return parent;
	}

	/**
	 * Returns the children of the current node.
	 * 
	 * @return a set of tree nodes - empty if no children. Never returns
	 *         <code>null</code>.
	 */
	public Set<TreeNode> getChildren() {
		return children;
	}

	/**
	 * Returns the name of the current node.
	 * 
	 * @return the name of the current node.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds a new node to the tree.
	 * 
	 * <p>
	 * The new node is added as a new child to the current node.
	 * </p>
	 * 
	 * @param name
	 *            the name to set for the new node.
	 * 
	 * @return the new tree node.
	 */
	public TreeNode add(String name) {
		TreeNode n = new TreeNode(name, this);
		getChildren().add(n);
		return n;
	}

	/**
	 * The name of the tree node is the node's string representation.
	 * 
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Lists all nodes of the subtree defined by the current node.
	 * 
	 * <p>
	 * The complete subtree is traversed and each of the nodes is printed in the
	 * system output. If you want to list the entire tree, then call this method
	 * on the tree's root node.
	 * </p>
	 */
	public void list() {
		// we need this stack to keep track how deep we are traversing the tree
		Stack<Iterator<TreeNode>> stack = new Stack<Iterator<TreeNode>>();

		TreeNode current = this;

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
