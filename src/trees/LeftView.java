package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class LeftView {


	static TreeNode rootNode;

	static int maxLevel = -1;

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

		// write your code here

//		leftViewUsingLevelOrder(rootNode);
//
//		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//		leftViewUsingMapPreOrder(rootNode, map, 0);
		// printMap()


		leftViewUsingPreOrder(rootNode, 0);


	}

	private static void leftViewUsingPreOrder(TreeNode rootNode2, int currentLevel) {
		if (rootNode2 == null) {
			return;
		}
		if (maxLevel < currentLevel) {
			maxLevel = currentLevel;
			System.out.println(rootNode2.data);
		}

		leftViewUsingPreOrder(rootNode2.left, currentLevel + 1);
		leftViewUsingPreOrder(rootNode2.right, currentLevel + 1);

	}

	private static void leftViewUsingMapPreOrder(TreeNode rootNode2, Map<Integer, Integer> map, int currentlevel) {

		if (rootNode2 == null) {
			return;
		}

		if (!map.containsKey(currentlevel)) {
			map.put(currentlevel, rootNode2.data);
		}


		leftViewUsingMapPreOrder(rootNode2.left, map, currentlevel + 1);
		leftViewUsingMapPreOrder(rootNode2.right, map, currentlevel + 1);


	}

	private static void leftViewUsingLevelOrder(TreeNode rootNode2) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(rootNode2);

		TreeNode cur = null;

		while (!q.isEmpty()) {
			int size = q.size();

			int i = 0;

			while (i++ < size) {
				cur = q.poll();

				if (i == 1) {
					System.out.println(cur.data);
				}

				if (cur.left != null) {
					q.add(cur.left);
				}

				if (cur.right != null) {
					q.add(cur.right);
				}

			}

		}

	}


}
