package heap;
import java.util.ArrayList;

public class Heap {

	ArrayList<Integer> data;

	public Heap() {
		data = new ArrayList<Integer>();
		data.add(null);
	}


	public void insert(int priority) {
		data.add(priority);
		int childIndex = data.size() - 1;
		int parentIndex = childIndex / 2;
		while (childIndex != 1) {
			if (data.get(childIndex) >= data.get(parentIndex)) {
				break;
			}
			int childData = data.get(childIndex);
			int parentData = data.get(parentIndex);
			data.set(childIndex, parentData);
			data.set(parentIndex, childData);
			childIndex = parentIndex;
			parentIndex = childIndex / 2;
		}
	}


	public int getMin() {

		if (getSize() == 0) {
			return -1;
		}
		return data.get(1);
	}

	public int getSize() {
		return data.size() - 1;
	}


	public int removeMin() {
		int min = data.get(1);
		int last = data.get(data.size() - 1);
		data.set(1, last);
		data.remove(data.size() - 1);

		int currentIndex = 1;
		int leftChildIndex = 2 * currentIndex;
		int rightChildIndex = 2 * currentIndex + 1;

		while (leftChildIndex < data.size() - 1) {
			int minIndex = currentIndex;
			int currentData = data.get(currentIndex);
			int leftData = data.get(leftChildIndex);

			if (leftData < currentData) {
				minIndex = leftChildIndex;
			}

			if (rightChildIndex < data.size()) {
				int rightData = data.get(rightChildIndex);
				if (rightData < data.get(minIndex)) {
					minIndex = rightChildIndex;
				}
			}
			if (minIndex == currentIndex) {
				break;
			}

			data.set(currentIndex, data.get(minIndex));
			data.set(minIndex, currentData);
			currentIndex = minIndex;
			leftChildIndex = 2 * currentIndex;
			rightChildIndex = leftChildIndex + 1;
		}
		return min;
	}


}
