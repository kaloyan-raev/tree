package tree;

public class Example {
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		root.list();
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode("X");
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
