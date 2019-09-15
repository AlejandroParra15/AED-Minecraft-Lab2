package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Structures.Hash;

class TestHash {

	private Hash<Integer> testHash;
	
	private void setupScenary4() {
		testHash = new Hash<Integer>();
	}
	
	@Test
	void testHashElement() {
		setupScenary4();
		int position = testHash.position(1);
	  assertTrue(position == 1);
	  int position2 = testHash.position(testHash.BASE_SIZE);
	  assertTrue(position2 == 0);
	  int position3 = testHash.position(0);
	  assertTrue(position3 == 0);
	}
	
	@Test
	void testAddElement() {
		setupScenary4();
		testHash.add(1, 9);
		testHash.add(2, 8);
		testHash.add(3, 7);
		testHash.add(4, 6);
		testHash.add(5, 5);
		testHash.add(6, 4);
		testHash.add(7, 3);
		testHash.add(8, 2);
		testHash.add(9, 1);
		assertTrue(true);
	}

}
