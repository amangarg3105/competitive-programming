package linkedlists;

import java.util.Scanner;

class Node {

	/* data of the node */
	int data;

	/* This is used to point the next node in horizontal */
	Node next;

	/*
	 * This is used to point the next below node in vertical
	 */
	Node below;

	Node(int value) {
		data = value;
		next = null;
		below = null;
	}
}


public class FlattenLinkedList {

	Node headNode;

	Node merge(Node l1, Node l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		Node ouput = null;

		if (l1.data < l2.data) {
			ouput = l1;
			ouput.below = merge(l1.below, l2);
		} else {
			ouput = l2;
			ouput.below = merge(l1, l2.below);
		}

		return ouput;
	}

	Node flat(Node head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}
		head.next = flat(head.next);
		head = merge(head, head.next);

		return head;

	}


	void printList(Node head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.below;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		FlattenLinkedList linkedList = new FlattenLinkedList();

		/* Number of nodes in the horizontal */
		int nHoriz = scan.nextInt();

		/*
		 * Create an array of 'nHoriz' integers to store the number of nodes in each vertical list
		 */
		int allVertSize[] = new int[nHoriz];
		for (int i = 0; i < nHoriz; i++) {
			allVertSize[i] = scan.nextInt();
		}

		Node currHorizNode = null;
		Node currVertNode = null;
		Node preHorizNode = null;
		Node preVertNode = null;

		/* Create the input linlked list */
		for (int i = 0; i < nHoriz; i++) {

			/* Get the current vertical linked lists size */
			int eachVertSize = allVertSize[i];

			eachVertSize--;

			/* Get the data of the current node */
			int nodeData = scan.nextInt();
			currHorizNode = new Node(nodeData);

			/*
			 * If this is the first node then make this node as the head node
			 */
			if (i == 0) {
				linkedList.headNode = currHorizNode;
			}

			/*
			 * If there is nodeA previous node in the horizontal linked list then add this node to its next
			 */
			if (preHorizNode != null) {
				preHorizNode.next = currHorizNode;
			}

			/*
			 * Make this node as previous node in the horizontal linked list for the next iteration, that is, for next
			 * value of i
			 */
			preHorizNode = currHorizNode;

			/* Now, get all the nodes in the current vertical linked list */
			for (int j = 0; j < eachVertSize; j++) {

				/* Create nodeA current node of vertical linked list */
				int nodeA = scan.nextInt();
				currVertNode = new Node(nodeA);

				/*
				 * If the current node is the second node of the vertical linked list, then make the previous vertical
				 * node as the current horizontal node
				 */
				if (j == 0) {
					preVertNode = currHorizNode;
				}

				/*
				 * Now, add the current vertical nod as the next node to the previous vertical node
				 */
				preVertNode.below = currVertNode;

				/* Move the cuurent 'preVertNode' to its next below node */
				preVertNode = preVertNode.below;
			}

		}

		linkedList.flat(linkedList.headNode);

		linkedList.printList(linkedList.headNode);

	}
}
