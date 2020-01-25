package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
	int data;
	Node next;
};


public class MergeKSortedLists {


	/*
	 * Create Min Heap
	 * 
	 * Insert K Nodes in this heap
	 * 
	 * Head = null
	 * 
	 * While(heap.isNotEmpty)
	 * 
	 * {
	 * 
	 * 
	 * Node minNode = minheap.removeMin();
	 * 
	 * 
	 * if(minNode.next != null) { heap.add(Node); }
	 * 
	 * if(head == null) {
	 * 
	 * head = minNode;
	 * 
	 * }
	 * 
	 * return head;
	 * 
	 * }
	 */

	Node newNode(int data) {

		Node newNode = new Node();

		newNode.data = data;
		newNode.next = null;

		return newNode;
	}
	
	
	/*
	 * Done By Shraddha Thakur
	 * 
	 * Second Approach takes O(1) space complexity if we ignore recursive stack space, time Complexity O(N log k)
	 */
	
//	public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0)
//            return null;
//        if (lists.length == 1)
//            return lists[0];
//        
//        ListNode merged = null;
//        for (int i = 1; i < lists.length; i++)
//        {
//            if (merged == null)
//                merged = mergeTwoLists(lists[i-1], lists[i]);
//            else
//                merged = mergeTwoLists(merged, lists[i]);
//        }
//        
//        return merged;
//    }
//    
//    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null)
//            return l2;
//        else if (l2 == null)
//            return l1;
//        
//        if (l1.val < l2.val)
//        {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//        
//        l2.next = mergeTwoLists(l1, l2.next);
//        return l2;
//    }

	private static Node mergeKSortedLists(ArrayList<Node> arr, int k) {
		PriorityQueue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.data - o2.data;
			}
		});
		Node head = null;
		Node last = null;
		for (int i = 0; i < k; i++) {
			heap.add(arr.get(i));
		}

		while (!heap.isEmpty()) {
			Node minNode = heap.remove();

			if (minNode.next != null) {
				heap.add(minNode.next);
			}

			if (head == null) {
				head = minNode;
				last = minNode;
			}

			last.next = minNode;

		}

		return head;

	}

	public static void main(String args[]) {

		// array list whose each element is the head of each linked list
		ArrayList<Node> arr = new ArrayList<>();
		MergeKSortedLists obj = new MergeKSortedLists();

		Scanner in = new Scanner(System.in);

		// Number of linked lists
		int k = in.nextInt();

		// Number of elements in each linked list
		int n = in.nextInt();

		Node tmp = null;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {

				// head node of the linked list
				if (j == 0) {
					int dt = in.nextInt();
					arr.add(obj.newNode(dt));
				} else {
					int dt = in.nextInt();
					tmp = arr.get(i);
					for (int m = 1; m < j; m++) {
						tmp = tmp.next;
					}
					tmp.next = obj.newNode(dt);
				}
			}
		}

		// write your code here
		mergeKSortedLists(arr, k);

	}

}
