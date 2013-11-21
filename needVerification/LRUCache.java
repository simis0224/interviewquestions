package needVerification;

import java.util.HashMap;

public class LRUCache {
	
	public class Node {
		Node pre;
		Node next;
		String key;
		Object data;
		public Node(String key, Object data) {
			this.key = key;
			this.data = data;
		}
	}
	
	private Node head;
	private Node tail;
	private int maxSize;
	private HashMap<String, Node> map = new HashMap<String, Node>();
	
	public LRUCache(int maxSize) {
		this.head = new Node(null, null);
		this.tail = new Node(null, null);
		this.maxSize = maxSize;
	}
	
	private void removeElementFromList(Node node) {
		if(node == null) {
			return;
		}
		
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	
	private void addElementToListHead(Node node) {
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
	}
	
	public Object get(String key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			if(map.size() > 1) {
				removeElementFromList(node);
				addElementToListHead(node);
			}
			return node.data;
		} else {
			return null;
		}
	}
	
	public void put(String key, Object data) {
		Node node = null;
		if(map.containsKey(key)) {
			node = map.get(key);
			removeElementFromList(node);
			node.data = data;
		} else {
			if(map.size() >= maxSize) {
				map.remove(tail.pre.key);
				removeElementFromList(tail.pre);
			} 
			node = new Node(key, data);
			map.put(key, node);
		}
		addElementToListHead(node);
	}
	
}
