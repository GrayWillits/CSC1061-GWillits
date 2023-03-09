package edu.frcc.csc1061j.MyHashMap;

import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new MyHashMap<String, Integer>();
		map.put("One",  1);
		map.put("Two",  2);
		map.put("Three",  3);
		
		
		if (map.containsKey("Two")) {
			System.out.println("Has Two");
		}
		
		System.out.println("Value of Three : " + map.get("Three"));
		
	}

}
