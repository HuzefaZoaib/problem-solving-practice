package com.practice.lru;

import java.util.*;

public class LRUCache<K,V> {

	private int maxSize = 3;
	private int currentSize = 0;
	
	private LinkedList doublyLinkedList = new LinkedList();
	private HashMap constantAccessToElement = new HashMap();

	/*public void put(V data) {
		
		// If cache hit
		if(constantAccessToElement.containsKey(data)) {
			Node node = constantAccessToElement.get(data);
			doublyLinkedList.bringItFirst(node);
			return;
		}
		
		if(currentSize <= maxSize) {
			Node node = doublyLinkedList.addFirst(data);
			constantAccessToElement.add(data, node);
			currentSize++;
			return;
		}
		
		// it cache miss and size is also full
		if(currentSize > maxSize) {
			// evict element
			Node node = doublyLinkedList.removeLast();
			constantAccessToElement.remove(node.getData());
			
			Node node = doublyLinkedList.addFirst(data);
			constantAccessToElement.add(data, node);
			return;	
		}
	}*/	
}
