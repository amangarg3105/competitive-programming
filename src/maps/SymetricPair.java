package maps;

import java.util.HashMap;
import java.util.Scanner;

public class SymetricPair {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// number of pairs in the array
		int n = in.nextInt();
		int arr[][] = new int[n][2];

		// store the input pairs to an array "arr"
		for (int i = 0; i < n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}

		boolean isFound = false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int first = arr[i][0];
			int sec = arr[i][1];
			Integer data = map.get(sec);
			if (data != null && data == first) {
				System.out.println(sec + " " + first);
				isFound = true;
			} else
				map.put(first, sec);
		}

		if (!isFound) {
			System.out.println("No Symmetric pair");
		}

	}

}
