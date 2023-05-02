import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeap <E extends Comparable<E>> {
	
	private List<E> heapArr;
	private Map<E, Integer> indexMap;
	
	public MinHeap() {
		heapArr = new ArrayList<E>();
		indexMap = new HashMap<E,Integer>();
	}
	
	public boolean isEmpty() {
		return heapArr.size() == 0;
	}
	public int size() {
		return heapArr.size();
	}
	
	public List<E> getHeap() {
		return heapArr;
	}
	
	public boolean contains(E elem) {
		return indexMap.containsKey(elem);
	}
	
	public int leftChild(E entry) {
		return (2 * indexMap.get(entry)) + 1;
	}
	
	public int rightChild(E entry) {
		return (2 * indexMap.get(entry)) + 2;
	}
	
	public int leftChild(int pos) {
		int child = (2 * pos) + 1;
		int retval = child >= heapArr.size() ? -1 : child;
		return retval;
	}
	public int rightChild(int pos) {
		int child = (2 * pos) + 2;
		int retval = child >= heapArr.size() ? -1 : child;
		return retval;
	}
	
	public int parent(int pos) {
		if (pos == 0) {
			return -1;
		}
		return (pos - 1) / 2;
	}
	
	public boolean isLeafNode(int pos) {
		return (pos >= heapArr.size()/2) && (pos < heapArr.size());
	}
	
	public int add(E entry) {
		heapArr.add(entry);
		return swimUp(heapArr.size() - 1);
	}
	
	private int swimUp(int current) {
		int parent = parent(current);
		E parentEntry = heapArr.get(parent);
		while ((current != 0) && (heapArr.get(current).compareTo(parentEntry) < 0) {
			swap(current, parent);
			current = parent;
			parent = parent(current);
			parentEntry = heapArr.get(parent);
		}
		return current;
	}
	
	private void swap(int pos1, int pos2) {
		E temp = heapArr.get(pos1);
		heapArr.set(pos1, heapArr.get(pos2));
		heapArr.set(pos2, temp);
	}
	
	public E remove() {
		return remove(0);
	}
	
	public E remove(int pos) {
		swap(pos, heapArr.size() -1);
		E removedEntry = heapArr.remove(heapArr.size() - 1);
		if (heapArr.size() > 0) {
			siftDown(pos);
		}
		return removedEntry;
	}
	
	private int siftDown(int current) {
		while (!isLeafNode(current)) {
			int lchild = leftChild(current);
			int rchild = rightChild(current);
			
			E lChildE = heapArr.get(lchild);
			if (rchild > -1 ) {
				E rChildE = heapArr.get(rchild);
				if (rChildE.compareTo(lChildE) < 0) {
					
				}
				
			}
		}
	}

}

















