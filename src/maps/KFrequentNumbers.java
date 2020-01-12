package maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


class Pair implements Comparable<Pair> {
	int number;
	int frequency;

	public Pair(int number, int frequency) {
		this.number = number;
		this.frequency = frequency;
	}

	@Override
	public int compareTo(Pair o) {

		if (this.frequency == o.frequency) {
			return Integer.compare(o.number, this.number);
		}

		return Integer.compare(o.frequency, this.frequency);
	}
}


public class KFrequentNumbers {


	/*
	 * Create a Map Integer vs Integer Store the element in this map as per their freq. Create a list Iterate over the
	 * keyset Of Map create the pair key vs val. add it in the arrayList;
	 * 
	 * Sort the list
	 * 
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// get the number of integers from input
		int n = in.nextInt();

		// store all the input integers to the array
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		// get the value of k from input
		int k = in.nextInt();


		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}

		ArrayList<Pair> list = new ArrayList<Pair>();

		for (Integer key : map.keySet()) {
			int val = map.get(key);
			Pair p;
			p = new Pair(key, val);
			list.add(p);
		}

		// Sort the list in desc.
		Collections.sort(list);

		for (int i = 0; i < k; i++) {
			System.out.print(list.get(i).number + " ");
		}


	}


}
