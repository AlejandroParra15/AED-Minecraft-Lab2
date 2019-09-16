package Structures;

public class Node<T> {
	
	private T obj;
	private T data;
	private int key;
	
	private Node<T> next;
	
	public Node() {
		obj = null;
		next = null;
	}

	public Node(T ob) {
		obj = ob;
		next = null;
	}
	
	public Node(T ob, int k) {
		obj = ob;
		next = null;
		key = k;
	}
	
	public boolean hasNext() {
		if(next != null) {
			return true;
		}else {
			return false;
		}
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getObj() {
		return obj;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	
	public void setData(T data){
		this.data = data;
	}
	
}
