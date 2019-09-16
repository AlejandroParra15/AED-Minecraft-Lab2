package Structures;

public class AccessQueue<T> implements MQueue<T>{
	
	private int size;
	
	private Node<T> head;
	private Node<T> tail;
	
	public AccessQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public void add(T obj) {
		
		Node<T> nn = new Node<T>(obj);
		if(head == null) {
			head = nn;
			tail = nn;
		}else {
			tail.setNext(nn);
			tail = nn;
			
		}
		size++;
	}

	@Override
	public T poll() {
		
		T dev = null;
		
		if(head != null) {
			dev  = head.getObj();
			head = head.getNext();
		}
		
		return dev;
	}

	@Override
	public T peek() {
		
		if(head != null) {
			return head.getObj();
		}else {
			return null;
		}
		
	}
	
	public int size() {
		return size;
	}
	
}
