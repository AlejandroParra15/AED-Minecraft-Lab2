package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Structures.GenericQueue;

class TestQueues {

private GenericQueue<Integer> testQueue;
	
	public void setupScenary1() {
		testQueue = new GenericQueue<Integer>();
	}

	@Test
	void testIsEmpty() {
		setupScenary1();
		assertTrue(testQueue.isEmpty());
		testQueue.add(1);
		assertFalse(testQueue.isEmpty());
	}
	@Test
	void testAdd() {
		setupScenary1();
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);
		testQueue.add(4);
		int result = testQueue.poll();
		assertTrue(result == 1&& testQueue.getSize()==3);
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);
		testQueue.add(4);
		assertTrue(testQueue.getSize() == 7);
	}
	
	@Test
	void testPoll() {
		setupScenary1();
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);
		testQueue.add(4);
		testQueue.add(5);
		testQueue.add(6);
		testQueue.add(7);
		testQueue.add(8);
		
		testQueue.poll();
		int result = testQueue.poll();
		assertTrue(result == 2&& testQueue.getSize()==6);
	}
	
	

}
