package tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeNode {
	
	private TreeNode parent;
	private Set<TreeNode> children;
	private Iterator<TreeNode> iterator;
	
	private String name;
	
	TreeNode(String name, TreeNode parent) {
		this.name = name;
		this.parent = parent;
		this.children = new HashSet<TreeNode>();
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Set<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public TreeNode add(String name) {
		TreeNode n = new TreeNode(name, this);
		getChildren().add(n);
		return n;
	}

	/**
	 * Initializes the children iterator and returns the first children.
	 * 
	 * <p>
	 * Assumes that there are some children. Before calling make sure that
	 * <code>getChildren.isEmpty() != null</code>
	 * </p>
	 * 
	 * @return the first children
	 */
	public TreeNode getFirstChild() {
		iterator = getChildren().iterator();
		return iterator.next();
	}

	/**
	 * Returns the next sibling. 
	 * 
	 * <p>Assumes that <code>getFirstChild()</code> has already been called on the parent. </p>
	 * 
	 * @return the next sibling. 
	 */
	public TreeNode getNextSibling() {
		if (parent == null || parent.iterator == null || !parent.iterator.hasNext()) {
			return null;
		} else {
			return parent.iterator.next();
		}
	}
	
	@Override
	public String toString() {
		return name;
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode("X", null);
		TreeNode a = root.add("A");
		root.add("B");
		TreeNode c = root.add("C");
		a.add("AA");
		TreeNode ca = c.add("CA");
		c.add("CB");
		c.add("CC");
		ca.add("CAA");
		ca.add("CAB");
		
		return root;
	}

}
