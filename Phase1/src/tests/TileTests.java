package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Tile;

public class TileTests {

	@Test
	public void gettiletest1() {
		Tile t = new Tile('A');
		char actual = t.getLetter();
		char expected = 'A';
		assertTrue("", actual == expected);

	}
	
	@Test
	public void getvaluetest() {
		Tile t = new Tile('A');
		int actual = t.getValue();
		int expected = 1;
		assertTrue("", actual == expected);
		
	}
	public void getvaluetest2() {
		Tile t = new Tile('Y');
		int actual = t.getValue();
		int expected = 2;
		assertTrue("", actual == expected);
		
	}
	public void getvaluetest3() {
		Tile t = new Tile('Z');
		int actual = t.getValue();
		int expected = 5;
		assertTrue("", actual == expected);
		
	}

}
