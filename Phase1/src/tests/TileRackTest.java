package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.TileRack;

public class TileRackTest {

	@Test
	public void removeAndRefillTest() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.remove(1);
		tr.remove(2);
		tr.refillIfNotFull();
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("", actual == expected);
	}
	@Test
	public void removeandrefilltest2() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.remove(1);
		tr.remove(2);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 10;
		assertTrue("", actual == expected);
	}
	@Test
	public void newtilerackandrefilltest() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("", actual == expected);
	}
	@Test
	public void gettiletest() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("", actual == expected);
	}


}
