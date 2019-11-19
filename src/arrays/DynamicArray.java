package arrays;

public class DynamicArray {


	// add()

	// get()

	// removeLast()

	// size()

	// removeAt(int index)

	// set(int index, int value)

	// isEmpty()

	// use the static array
	// we need to restructure our array if it exceeds the size of array
	int[] arr;
	int counter;

	public DynamicArray() {
		arr = new int[5];
	}

	public void print() {
		for (int i = 0; i < counter; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void add(int value) {
		if (arr.length == counter) {
			restructeArray();
		}
		arr[counter] = value;
		counter++;
	}

	private void restructeArray() {
		int temp[] = arr;
		arr = new int[arr.length * 2];
		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
	}

	public void removeAt(int index) {
		if (index < counter) {
			arr[index] = 0;
			int temp = index;
			// shifting to left side.
			while (temp + 1 < counter) {
				arr[temp] = arr[temp + 1];
				arr[temp + 1] = 0;
				temp++;
			}
			counter--;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public int removeLast() {
		int value = arr[counter - 1];
		arr[counter - 1] = 0;
		counter--;
		return value;
	}

	public int get(int index) {
		return arr[index];
	}


	public void set(int index, int value) {
		if (index > counter) {
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[index] = value;
	}


	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public void sort() {
		// merge sort

	}

	public int size() {
		return counter;
	}
}
