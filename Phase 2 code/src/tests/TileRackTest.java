package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.model.Inventory_024_055;
import code.model.TileRack_024_055;
import code.model.Tile_024_055;


public class TileRackTest {

	@Test
	public void removeAndRefillTest() { // This test removed and refills,
										// telling us that one or both methods
										// work.
		Inventory_024_055 inv = new Inventory_024_055();
		TileRack_024_055 tr = new TileRack_024_055(inv);
		tr.removeTile(1);
		tr.removeTile(2);
		tr.fillRack();
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

	@Test
	public void removeandrefilltest2() { // This test removed but does not
											// refill, confirming that the
											// remove and refill method are
											// working properly.
		Inventory_024_055 inv = new Inventory_024_055();
		TileRack_024_055 tr = new TileRack_024_055(inv);
		tr.removeTile(1);
		tr.removeTile(2);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 10;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}

	@Test
	public void newTileRackAndRefillTest() { // This test confirms that upon
												// initiation of a TileRack
												// object, 12 Tiles are inside
												// the TileRack
		Inventory_024_055 inv = new Inventory_024_055();
		TileRack_024_055 tr = new TileRack_024_055(inv);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);	}
}



