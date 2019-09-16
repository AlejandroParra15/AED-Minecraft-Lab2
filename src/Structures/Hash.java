package Structures;

public class Hash<T> {
	
	public final static int BASE_SIZE = 9*3;
	
	private Node<T>[] A;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Hash(int s) {
		
		A = new Node[s];
		setSize(s);
		
	}
	
	@SuppressWarnings("unchecked")
	public Hash() {
		
		A = new Node[BASE_SIZE];
		setSize(BASE_SIZE);
		
	}
	
	public int position(int k) {
		return k%A.length;
	}
	
	public void remove(int key) {
		
		int pos = position(key);
		boolean find = false;
		Node<T> x = A[pos];
		Node<T> ant = null;
		
		while(!find) {
			
			if(x.getKey() == key) {
				
				if(x.equals(A[pos]) && !x.hasNext()) {
					A[pos] = null;
				}else if(x.equals(A[pos]) && x.hasNext()) {
					A[pos] = x.getNext();
				}else if(!x.equals(A[pos]) && !x.hasNext()) {
					ant.setNext(null);
				}else if(!x.equals(A[pos]) && x.hasNext()) {
					ant.setNext(x.getNext());
				}
				
				find = true;
				
			}else {
				ant = x;
				x = x.getNext();
			}
			
		}
		
	}
	
	public void add(int key, T obj) {
		
		Node<T> temp = null;
		int place = position(key);
		
		if(A[place] == null) {
			A[place] = new Node<T>(obj, key);
		}else {
			
			temp = A[place];
			boolean exit = false;
			
			while(!exit) {
				if(temp.getNext() == null) {
					temp.setNext(new Node<T>(obj, key));
					exit = true;
				}else {
					temp = temp.getNext();
				}
				
			}
			
		}
		
	}

	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Node<T> getObject(int k) {
		return A[k];
	}
	
}
