package stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue {

	Queue<Integer> q = new LinkedList<Integer>();

	/* Push operation of stack using queue */
	/*
	 * Time Complexity- o(n)
	 */
	void push(int x) {
		// write your code here
		int size = q.size();

		q.add(x);

		for (int i = 0; i < size; i++) {
			int temp = q.remove();
			q.add(temp);
		}

	}

	/* Removes the top element of the stack */

	/*
	 * Time Complexity - o(1)
	 */
	int pop() {
		if (!q.isEmpty()) {
			int x = q.remove();
			return x;
		}
		return -1;
	}


	/* Returns the element at the top of the stack */
	/*
	 * Time Complexity - o(1)
	 */
	int top() {
		if (!q.isEmpty()) {
			return q.peek();
		}
		return -1;
	}

	/*
	 * Time Complexity - o(1)
	 */
	int size() {
		return q.size();
	}


	public static void main(String[] args) {
		StackUsingQueue obj = new StackUsingQueue();
		Scanner in = new Scanner(System.in);

		/* Enter the number of elements you want to add in the stack */

		int n = in.nextInt();

		/* Enter the elements of the stack */
		for (int i = 0; i < n; i++) {
			obj.push(in.nextInt());
		}

		System.out.println(obj.top());
		obj.pop();
		System.out.println(obj.top());
	}

}
