package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Structures.AccessQueue;

class TestQueue {
	
	private AccessQueue<Integer> TestQueue;

	
	public void setupScenary1() {
		TestQueue = new AccessQueue<Integer>();
		TestQueue.add(10);
		TestQueue.add(9);
		
	}
	
	public void setupScenary2() {
		
	}
	
	public void setupScenary3() {
		
	}
	
	@Test
	void testAdd() {
		setupScenary1();
		assertTrue(TestQueue.peek() == 10);
		TestQueue.poll();
		assertTrue(TestQueue.peek() == 9);
	}
	
	@Test
	void testPoll() {
		
	}

}
