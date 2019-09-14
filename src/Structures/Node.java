package Structures;

public class Node<T> {
	
	private T obj;
	
	private Node<T> next;
	
	public Node() {
		obj = null;
		next = null;
	}

	public Node(T ob) {
		obj = ob;
		next = null;
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
	
}
