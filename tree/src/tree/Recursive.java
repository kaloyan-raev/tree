package tree;

public class Recursive {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree();
		listNames(root);
	}
	
	private static void listNames(TreeNode node) {
		System.out.println(node);
		for (TreeNode n : node.getChildren()) {
			listNames(n);
		}
	}

}
