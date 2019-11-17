package arrays;

import java.util.Scanner;

public class KSmallestElements {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i;
		int[] arr = new int[n];
		for (i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int k = s.nextInt();
		smallestKelements(arr, n, k);

	}

	static void smallestKelements(int arr[], int n, int k) {
		/*
		 * for the first k elements find the maximum element, .. if u find any number smaller than this maximum element
		 * in rest (k-n)array , then this max element(from (0-k)array) has to be deleted as a smaller element(from
		 * (k-n)array) has been found .. because we have to maintain the original order of the elements(in our ans , i.e
		 * (0-k)array) , we shift every element one step left (of our (0-k)array ) such that the maximum element gets
		 * deleted and replace the last element (0-k)array with the newly found minimum element.
		 */
		// Average case Time Complexity = O(nk)
		// Space Complexity = O(1)
		for (int i = k; i < n; i++) {
			int maximum = arr[k - 1];
			int position = k - 1;
			for (int j = k - 2; j >= 0; j--) {
				if (arr[j] > maximum) {
					maximum = arr[j];
					position = j;
				}
			}
			// maximum = 5
			if (maximum > arr[i]) {
				int j = position;
				while (j < k - 1) {

					// shitinf elements to left side
					arr[j] = arr[j + 1];
					j++;
				}

				arr[k - 1] = arr[i];
			}
		}

		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}

	}

}
