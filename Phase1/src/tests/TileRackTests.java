package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.TileRack;

public class TileRackTests {
	@Test
	public void TileRackTests1() {
		TileRack t = new TileRack(null);
		t.remove(1);
		int expected = 11;
		int actual = t.getSize();
		assertTrue("",actual == expected);
		
		
	}
	@Test
	public void TileRackTests2() {
		TileRack t = new TileRack(null);
		t.remove(1);
		t.refillIfNotFull();
		int expected = 12;
		int actual = t.getSize();
		assertTrue("",actual == expected);
		
		
	}

}
