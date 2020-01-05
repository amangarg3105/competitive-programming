package maps;

import java.util.HashMap;
import java.util.Scanner;

public class QuadrupleProduct {


	/*
	 * Create a HashMap Integer
	 * 
	 * iterate over the array for x i to n
	 * 
	 * run a loop for y i+1 to n
	 * 
	 * productValue = arr[x] * arr[y];
	 * 
	 * if(Map.containse(product)
	 * 
	 * { Pair p = map.get(product);
	 * 
	 * print p and arr[x] and arr[y]
	 * 
	 * } else {
	 * 
	 * map.put(product, Pair);
	 * 
	 * }
	 */


	static class Pair {
		int firstElememt;
		int secondElement;

		public Pair(int firstElememt, int secondElement) {
			this.firstElememt = firstElememt;
			this.secondElement = secondElement;
		}


	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// getting the number of input integers
		int n = in.nextInt();
		int array[] = new int[n];

		// storing the input integers to the array
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		HashMap<Integer, Pair> map = new HashMap<Integer, QuadrupleProduct.Pair>();
		boolean isFound = false;
		for (int x = 0; x < n; x++) {
			for (int y = x + 1; y < n; y++) {
				int productValue = array[x] * array[y];

				if (map.containsKey(productValue)) {
					isFound = true;
					Pair p = map.get(productValue);
					System.out
							.println(array[p.firstElememt] + " " + array[p.secondElement] + " " + array[x] + " " +  array[y]);
				} else {
					map.put(productValue, new Pair(x, y));
				}
			}
		}

		if (!isFound) {
			System.out.println("Not Found");
		}

	}
}
