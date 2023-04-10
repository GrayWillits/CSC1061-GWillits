package edu.frcc.csc1061j.MyTreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K,V> implements Map<K,V>, Iterable<V> {

	private Node root = null;
	private int size = 0;
	
	private class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public Iterator<V> iterator() {
		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<V> {
		private ArrayList<V> list = new ArrayList<>();
		private int currentIndex = 0;
		
		public InOrderIterator() {
			inOrder(root);
		}
		
		private void inOrder(Node node) {
			if (node == null) {
				return;
			}
			inOrder(node.left);
			list.add(node.value);
			inOrder(node.right);
		}

		@Override
		public boolean hasNext() {
			return currentIndex < list.size();
		}

		@Override
		public V next() {
			V value = list.get(currentIndex);
			currentIndex++;
			return value;
		}
		
	}
	
	private ArrayList<Node> getInOrder(Node node) {
		ArrayList<Node> list = new ArrayList<>();
		inOrderNodesRecursive(node, list);
		return list;
	}
	
	private void inOrderNodesRecursive(Node node, ArrayList<Node> list) {
		if (node == null) {
			return;
		}
		inOrderNodesRecursive(node.left, list);
		list.add(node);
		inOrderNodesRecursive(node.right, list);
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
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				current = current.right;
			}
			else {
				return current.value;
			}
		}
		
		return null;
	}
	
	private Node getNode(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		Node current = root;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				current = current.right;
			}
			else {
				return current;
			}
		}
		
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			return value; 
		}
		
		Node current = root;
		Node parent = null;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			}
			else {
				return null;
			}
		}
		
		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) > 0) {
			parent.right = newNode;
		}
		else {
			parent.left = newNode;
		}
		size++;
		return value;
	}
	
	private Node getParent(Node node) {
		Comparable<K> k = (Comparable<K>) node.key;
		Node current = root;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				if (current.left.key.equals(k)) {
					return current;
				}
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				if (current.right.key.equals(k)) {
					return current;
				}
				current = current.right;
			}
		}
		
		return null;
	}

	@Override
	public V remove(Object key) {
		
		// THIS IS HOMEWORK
		Node node = getNode(key);
		Node parent = getParent(node);
		ArrayList<Node> list = getInOrder(node);
		
		if (node.left == null && node.right == null) {
			if (parent.left.equals(node)) {
				parent.left = null;
				return node.value;
			}
			if (parent.right.equals(node)) {
				parent.right = null;
				return node.value;
			}
		}
		if (node.left != null && node.right == null) {
			if (parent.left.equals(node)) {
				parent.left = node.left;
				return node.value;
			}
			if (parent.right.equals(node)) {
				parent.right = node.left;
				return node.value;
			}
		}
		if (node.left == null && node.right != null) {
			if (parent.left.equals(node)) {
				parent.left = node.right;
				return node.value;
			}
			if (parent.right.equals(node)) {
				parent.right = node.right;
				return node.value;
			}
		}
		if (node.left != null && node.right != null) {
			Node predecessor = list.get(list.indexOf(node) - 1);
			remove(predecessor);
			predecessor.left = node.left;
			predecessor.right = node.right;
			if (parent.left.equals(node)) {
				parent.left = predecessor;
				return node.value;
			}
			if (parent.right.equals(node)) {
				parent.right = predecessor;
				return node.value;
			}
		}
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}