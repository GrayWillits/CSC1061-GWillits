package edu.frcc.csc1061j.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDoubleLinkedList<E> implements List<E> {

	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		public E data;
		public Node next;
		public Node prev;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public MyDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (indexOf(o) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		if (head == null ) {
			head = newNode;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}
	
	@Override
	public E remove(int index) {
		E data = get(index);
		if (index == 0) {
			if (tail == head ) {
				tail = null;
			}
			head.prev = null;
			head = head.next;			
		}
		else {
			Node node = getNode(index - 1);
			if (node.next == tail) {
				tail = node;
			}
			node.next = node.next.next;
			if (node.next != null) {
				node.next.prev = node;
			}
		}
		size--;
		return data;
	}
	
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E data: c) {
			add(data);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else {
			Node node = getNode(index - 1);
			if (node == tail) {
				tail = newNode;
			}
			newNode.next = node.next;
			newNode.prev = node;
			if (node.next != null) {
				node.next.prev = newNode;
			}
			node.next = newNode;
		}
		size++;
	}

	@Override
	public int indexOf(Object o) {
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(node.data)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node node = tail;
		for (int i = 0; i < size; i++) {
			if (o.equals(node.data)) {
				return i;
			}
			node = node.prev;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
