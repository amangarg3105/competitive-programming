package stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class WeatherAnnualReport {

	/*
	 * Create a stack
	 * 
	 * push the 0 th index
	 * 
	 * create a new result array of size input array
	 * 
	 * for(int i = 1; i < arr.length; i++) {
	 * 
	 * keeping poping from stack till arr[i] >= arr[s.top]
	 * 
	 * if your stack is empty then for result[i] = i + 1;
	 * 
	 * else result[i] = i - s.top();
	 * 
	 * push the index
	 * 
	 * output the result array
	 * 
	 * 
	 * 
	 * }
	 */

	static void difference(int height[], int S[]) {

		Stack<Integer> st = new Stack<Integer>();
		
		st.push(0);
		S[0] = 1;
		for(int i = 1; i < height.length; i++) {
			while(!st.isEmpty() && height[i] >= height[st.peek()]) {
				st.pop();
			}
			if(st.isEmpty()) {
				S[i] = i + 1;
			} else {
				S[i] = i - st.peek();
			}
			st.push(i);
		}
		
		for(int i = 0; i < S.length; i++) {
			System.out.print(S[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] height = new int[12];
		for (int i = 0; i < 12; i++) {
			height[i] = in.nextInt();
		}

		// Output array that will store the number of months having rainfall less than the current month
		int S[] = new int[12];
		difference(height, S);
	}

}
