package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tile;

public class TileTests {

	@Test
	public void getTileTest1() { // This test confirms that the getLetter method
									// is working correctly
		Tile t = new Tile('A');
		char actual = t.getLetter();
		char expected = 'A';
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

	@Test
	public void getValueTest() { // The next 3 tests confirm that the getValue
									// method returns the correct amount of
									// points for each type of character.
		Tile t = new Tile('A');
		int actual = t.getValue();
		int expected = 1;
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

	public void getValueTest2() {
		Tile t = new Tile('Y');
		int actual = t.getValue();
		int expected = 2;
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

	public void getValueTest3() {
		Tile t = new Tile('Z');
		int actual = t.getValue();
		int expected = 5;
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

}
