package strings;

import java.util.Stack;

public class ReverseWords {

	/*
	 * Intialize Stack
	 * 
	 * Run a loop over the string
	 * 
	 * push the character in stack until the space
	 * 
	 * if space encountered, then pop from the stack until it is empty and store the result in string builder
	 * 
	 * 
	 * After running a loop over string, empty the stack if there are still characters in it.
	 */

	static void reverseWords(String s) {
		StringBuilder result = new StringBuilder();

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				stack.push(s.charAt(i));
			} else {
				while (!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append(" ");
			}
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		System.out.println(result);

	}

	public static void main(String[] args) {
		
		reverseWords("My Name is xyz");

	}

}
