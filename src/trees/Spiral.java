package trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Spiral {


	public static void spiralTree(TreeNode root) {

		Deque<TreeNode> dq = new LinkedList<TreeNode>();

		if (root == null) {
			return;
		}

		dq.addFirst(root);
		boolean flag = true;

		while (!dq.isEmpty()) {

			int numberOfNodesInthisLevel = dq.size();

			for (int i = 0; i < numberOfNodesInthisLevel; i++) {

				TreeNode node = null;

				if (flag) {
					node = dq.pollLast();
					if (node.right != null) {
						dq.addFirst(node.right);
					}
					if (node.left != null) {
						dq.addFirst(node.left);
					}
				} else {
					node = dq.pollFirst();

					if (node.left != null) {
						dq.addLast(node.left);
					}

					if (node.right != null) {
						dq.addLast(node.right);
					}
				}

				System.out.println(node.data);
			}

			flag = !flag;
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

		spiralTree(rootNode);


	}
}
