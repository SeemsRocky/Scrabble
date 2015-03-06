package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.Tile;
import code.TileRack;

public class TileRackTest {

	@Test
	public void removeAndRefillTest() { // This test removed and refills,
										// telling us that one or both methods
										// work.
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.remove(1);
		tr.remove(2);
		tr.refillIfNotFull();
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

	@Test
	public void removeandrefilltest2() { // This test removed but does not
											// refill, confirming that the
											// remove and refill method are
											// working properly.
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.remove(1);
		tr.remove(2);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 10;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

	@Test
	public void newTileRackAndRefillTest() { // This test confirms that upon
												// initiation of a TileRack
												// object, 12 Tiles are inside
												// the TileRack
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

	@Test
	public void getTileTest() { // This test confirms that the getLetter method
								// works properly by getting the index of the
								// Tile we want within the TileRack and
								// returning the character that is contained in
								// that position.
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		for (int i = 0; i < 12; i++) {
			tr.remove(0);
		}
		tr.addTile(new Tile('A'));
		char expected = 'A';
		Tile t = tr.getTile(0);
		char actual = t.getLetter();

		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

}
