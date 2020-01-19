package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FlatBinaryTree {


	private static void flatBinaryTree(TreeNode rootNode) {

		if (rootNode == null) {
			return;
		}

		TreeNode node = rootNode;

		while (node != null) {

			if (node.left != null) {
				TreeNode rightSubTree = node.left;

				while (rightSubTree.right != null) {
					rightSubTree = rightSubTree.right;
				}

				rightSubTree.right = node.right;

				node.right = node.left;
				node.left = null;

			}

			node = node.right;
		}

	}

	public static void main(String[] args) {
		// root node of the binary tree
		TreeNode rootNode;

		Scanner in = new Scanner(System.in);

		// number of elements
		int n = in.nextInt(), element;

		// queue used to create a binary tree
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		// creating a new binary tree.
		rootNode = new TreeNode(in.nextInt());
		q.add(rootNode);
		TreeNode cur = null;
		for (int i = 1; i < n; i++) {

			cur = q.remove();
			// Note: if the element is -1 then the node is null
			element = in.nextInt();
			if (element != -1) {
				cur.left = new TreeNode(element);
				q.add(cur.left);
			}
			i++;
			element = in.nextInt();
			// Note: if the element is -1 then the node is null
			if (element != -1) {
				cur.right = new TreeNode(element);
				q.add(cur.right);
			}
		}

		flatBinaryTree(rootNode);

	}


}
