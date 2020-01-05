package stackqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumSubArrayK {


	static void max(int arr[], int n, int k) {

		Deque<Integer> dq = new LinkedList<Integer>();
		int i = 0;
		for (i = 0; i < k; i++) {

			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
				dq.removeLast();
			}

			dq.addLast(i);
		}

		for (; i < n; i++) {

			System.out.print(arr[dq.peek()] + " ");

			while (!dq.isEmpty() && dq.peek() <= i - k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(arr[dq.peek()] + " ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int g = in.nextInt();

		max(arr, n, g);
	}
}
