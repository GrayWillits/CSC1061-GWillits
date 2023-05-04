import java.util.Arrays;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] nodes = {88, 85, 83, 72, 73, 42, 57, 6, 48, 60};
		
		MinHeap<Integer> heap = new MinHeap<Integer>();
		
		for (int node : nodes) {
			heap.add(node);
		}
		
		System.out.println("Heap Array: " + Arrays.toString(heap.getHeap().toArray()));
	}

}
