package stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class kLargestElement {

	/*
	 * Create a new stack
	 * 
	 * run a loop over input stack while it is not empty {
	 * 
	 * pop the top element from this input stack
	 * 
	 * check if your new stack is not empty && popped element < top element of new stack { pop the elements from new
	 * stack and push them in a input stack till popped element < top element of new stack }
	 * 
	 * push the popped element in a new stack }
	 * 
	 * return newStack;
	 * 
	 *
	 */


	// This function returns the sorted stack
	
	/*
	 * Time Complexity - o(n^2)
	 * Space Complexity - o(n)  -----> o(1)
	 */
	public static Stack<Integer> sortStack(Stack<Integer> inputStack) {

		Stack<Integer> tempStack = new Stack<Integer>();

		while (!inputStack.isEmpty()) {

			int value = inputStack.pop();

			while (!tempStack.isEmpty() && value < tempStack.peek()) {
				int tempValue = tempStack.pop();
				inputStack.push(tempValue);
			}

			tempStack.push(value);
		}
		return tempStack;

	}


	public static void findKthLargestNum(Stack<Integer> sortedStack, int k) {


		int i = 1;

		while (i < k) {
			sortedStack.pop();
			i++;
		}
		System.out.println(sortedStack.peek());
	}


	public static void main(String args[]) {
		Stack<Integer> inputStack = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			inputStack.add(in.nextInt());
		}

		if (inputStack.isEmpty()) {
			System.out.println("stack is empty");
			System.exit(0);
		}

		int k = in.nextInt();
		if (k > inputStack.size()) {
			System.out.println("invalid input");
			System.exit(0);
		}

		Stack<Integer> tempStack = sortStack(inputStack);
		findKthLargestNum(tempStack, k);

	}
}

