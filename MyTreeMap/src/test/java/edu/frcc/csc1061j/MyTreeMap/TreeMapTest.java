package edu.frcc.csc1061j.MyTreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
		
		map.put(8,8);
		map.put(12,12);
		map.put(6,6);
		map.put(2,2);
		map.put(18,18);
		
		printInOrder(map);
	}
	
	private static void printInOrder(MyTreeMap<Integer, Integer> map) {
		for (Integer value: map) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
}
