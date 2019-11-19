package arrays;


public class DynamicArrayUse {

	public static void main(String[] args) {
		// int[] a = new int[5];

		DynamicArray d = new DynamicArray();

		for (int i = 1; i < 10; i++) {
			d.add(i);
		}

		// d.set(33, 55);
		// d.removeLast();

		d.print();
		System.out.println();
		d.removeAt(55);

		d.print();

	}

}
