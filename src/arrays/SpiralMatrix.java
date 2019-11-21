package arrays;

import java.util.Scanner;

public class SpiralMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] = s.nextInt();

		spiral(arr);
	}


	static void spiral(int[][] matrix) {

		//Time Complexity - O(n^2)
		
		int top = 0;

		int left = 0;

		int right = matrix[0].length - 1;

		int bottom = matrix.length - 1;

		while (true) {

			for (int i = left; i <= right; i++) {
				System.out.print(matrix[top][i] + " ");
			}
			top++;
			if (top > bottom) {
				break;
			}

			for (int i = top; i <= bottom; i++) {
				System.out.print(matrix[i][right] + " ");
			}
			right--;

			if (left > right) {
				break;
			}

			for (int i = right; i >= left; i--) {
				System.out.print(matrix[bottom][i] + " ");
			}
			bottom--;
			if (top > bottom) {
				break;
			}

			for (int i = bottom; i >= top; i--) {
				System.out.print(matrix[i][left] + " ");
			}
			left++;
			if (left > right) {
				break;
			}
		}
	}

}
