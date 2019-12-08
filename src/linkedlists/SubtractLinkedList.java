package linkedlists;

import linkedlists.LastNthNode.Node;

public class SubtractLinkedList {


	/*
	 *
	 * Point head1 = first LinkedList Point head2 = second LinkedList
	 * 
	 * boolean borrowAvailable = false; Recursively, Move to the end of linkedLists
	 * 
	 * Assuming recursion went well and we have two nodes here temp1 and temp2 pointing to end of the linked list
	 * respectively.
	 * 
	 * 
	 * 
	 * if(borrowAvailable) { temp1.data--; borrowAvailable = false; } Now check that if(temp1.data > temp2.data) { sub =
	 * temp1.data - temp2.data; } else { temp1.data = temp1.data + 10; sub = temp1.data - temp2.data; borrowAvailable =
	 * true;
	 * 
	 * 
	 * }
	 *
	 */

	boolean borrowAvailable = false;
	
	Node addZerosInFront(Node smallNode, int diff) {
		
		if(smallNode == null) {
			return null;
		}
		
		Node zeroNode = new Node(0);
		diff--;
		Node temp = zeroNode;
		while(diff != 0) {
			temp.next = new Node(0);
			temp = temp.next;
			diff--;
		}
		temp.next = smallNode;
		return zeroNode;
	}
	
	/*
	 * Time Complexity - O(LengthOfLL1 + LengthOfLL2)
	 * Space Complexity - O(LengthOfLL1)
	 */

	Node subtract(Node temp1, Node temp2) {
		if (temp1 == null && temp2 == null) {
			return null;
		}

		Node previous = subtract(temp1.next, temp2.next);

		int d1 = temp1.data;
		int d2 = temp2.data;
		int sub = 0;

		if (borrowAvailable) {
			d1--;
			borrowAvailable = false;
		}

		if (d1 < d2) {
			borrowAvailable = true;
			d1 = d1 + 10;
		}
		sub = d1 - d2;

		Node subNode = new Node(sub);

		subNode.next = previous;

		return subNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
