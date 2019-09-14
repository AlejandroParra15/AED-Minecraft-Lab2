package Structures;

public interface MQueue<T> {
	
	public void add(T obj);
	
	public T poll();
	
	public T peek();
	
}
