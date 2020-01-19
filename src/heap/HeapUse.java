package heap;
public class HeapUse {

	public static void main(String[] args) {
		Heap heap = new Heap();

		heap.insert(11);
		heap.insert(15);
		heap.insert(10);
		heap.insert(14);
		heap.insert(21);

		System.out.println(heap.getMin());

		System.out.println(heap.removeMin());

		System.out.println(heap.getMin());

	}

}
