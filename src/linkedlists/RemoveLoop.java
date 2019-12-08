package linkedlists;

import linkedlists.LastNthNode.Node;

public class RemoveLoop {


	public void removeLoop(Node head) {

		Node fastNode = head;
		Node slowNode = head;
		boolean isLoopExists = false;
		
		/*
		 * Floyd's warshal cycle 
		 */

		while (slowNode != null && fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode == slowNode) {
				isLoopExists = true;
				break;
			}
		}
		
		if(isLoopExists) {
			slowNode = head;
			Node prevNode = null;
			while(slowNode != fastNode) {
				prevNode = fastNode;
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
			System.out.println("Loop found Node  :" + slowNode.data);
			
			prevNode.next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
