package Structures;



public class GenericQueue<E> {
	
	
	private Node<E> first,last;
	private int size;

	
	public GenericQueue() {
	this.first = null;
	this.last = null;
	
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void add(E item) {
		Node<E> prevLast = last;
		last = new Node<E>(item);
		if(isEmpty()) {
			first = last;
		}else {
			prevLast.setNext(last);
		}
		size++;
	}
	
	public E poll() {
		if(isEmpty()) {
			return null;
		}
		if(first == last) {
			E data = (E)first.getData();
			first = last = null;
			size--;
			return data;
		}
		E data = (E)first.getData();
		first = first.getNext();
		size--;
		return data;
	}
	
     public int getSize() {
		return size;
	}
     
     public E peek() {
    	 return first.getData();
     }
	
}