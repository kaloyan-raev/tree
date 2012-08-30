package tree;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {
	
	private TreeNode parent;
	private Set<TreeNode> children;
	
	private String name;
	
	TreeNode(String name, TreeNode parent) {
		this.name = name;
		this.parent = parent;
		this.children = new HashSet<TreeNode>();
	}

	public TreeNode getParent() {
		return parent;
	}

	public Set<TreeNode> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public TreeNode add(String name) {
		TreeNode n = new TreeNode(name, this);
		getChildren().add(n);
		return n;
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
