package arrays;



public class MinimumSwapsSortedArray {

	public static void main(String[] args) {

		int[] arr = {1, 6, 2, 3, 4, 5};
		int[] temp = new int[arr.length];
		if(checkArray(arr)) {
			System.out.println(mergeSort(arr, temp, 0, arr.length - 1));
		} else {
			System.out.println("Not Possible");
		}
		

	}

	private static boolean checkArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] - 1 - i > 2) {
				return false;
			}
		}
		return true;
	}

	/*
	 * 1. We will try to break this array into two parts recursively,
	 * 
	 * 2. Try to merge these two subarrays and create a sorted ordered array, while creating this array check if element
	 * of first subarray is greater than the element of second subarray. If yes, inversion count should be mid - i as
	 * rest of the elements in first subarray are going to be greater than all elements of second subarray.
	 * 
	 * 3. do these recursively till low < high.
	 * 
	 * 4. number of inversions will be our minimum number of swaps.
	 * 
	 *
	 * 
	 */
	
	
	/*
	 * 
	 * Time Complexity - O(nlogn)
	 */
	public static int mergeSort(int[] arr, int[] temp, int low, int high) {
		int inversionCount = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			inversionCount = inversionCount + mergeSort(arr, temp, low, mid);
			inversionCount = inversionCount + mergeSort(arr, temp, mid + 1, high);
			inversionCount = inversionCount + merge(arr, temp, low, mid + 1, high);
		}
		return inversionCount;
	}

	private static int merge(int[] arr, int[] temp, int low, int mid, int high) {
		int inversionCount = 0;
		int k = low;
		int j = mid;
		int i = low;

		while (i <= mid - 1 && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversionCount = inversionCount + (mid - i);
			}
		}

		while (i <= mid - 1) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		for (int l = low; l <= high; l++) {
			arr[l] = temp[l];
		}

		return inversionCount;

	}

}
