package linkedlists;

import java.util.Scanner;

public class LastNthNode {


	/*
	 * initialize counter = 0;
	 * 
	 * int n given by user
	 * 
	 * create ptr1 = head;
	 * 
	 * run a loop while(counter < n) {
	 * 
	 * ptr1 = ptr1.next; counter++;
	 * 
	 * }
	 * 
	 * create ptr2 = head;
	 * 
	 * while(ptr1 != null) { ptr1 = ptr1.next;
	 * 
	 * ptr2 =ptr2.next; }
	 * 
	 * return ptr2.data;
	 */

	Node headNode;

	/* Structure of the node of linked list */
	static class Node {

		/* data of the node */
		int data;

		/*
		 * This is used to point the next node of the current node
		 */
		Node next;
		
		Node prev;

		public Node down;

		Node(int value) {
			data = value;
			next = null;
		}
	}

	/*
	 * This method will return the data of the last nth node of the linked list
	 */
	
	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(1)
	 */
	int lastNthNode(int n) {

		int counter = 0;
		
		Node ptr1 = headNode;
		
		//if(n > length of linked list) {
	      //print "Not possible"
		
	//}
	
		
		while(counter < n) {
			ptr1 = ptr1.next;
			if(ptr1 == null) {
				return -1;
			}
			counter++;
		}
		
		Node ptr2 = headNode;
		
		while(ptr1 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		return ptr2.data;
	}

	/*
	 * This method adds a new node with data 'newData' to the front of the linked list
	 */
	public void addAtHead(int newData) {

		/* Create a new Node of data newData */
		Node newNode = new Node(newData);

		/* Now, set the next of the newNode as headNode */
		newNode.next = headNode;

		/* Next, make this newNode as head */
		headNode = newNode;
	}

	public static void main(String[] args) {
		LastNthNode linkedList = new LastNthNode();

		Scanner in = new Scanner(System.in);

		/* Get the number of nodes in the linkedList from input */
		int noOfNodes = in.nextInt();

		/* Get the nodes of the linkedList from input */
		for (int i = 0; i < noOfNodes; i++) {
			linkedList.addAtHead(in.nextInt());
		}

		/*
		 * Get the value of n from input to find the last nth node of the linked list
		 */
		System.out.println(linkedList.lastNthNode(in.nextInt()));
	}


}
