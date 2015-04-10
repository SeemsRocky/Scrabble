package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.model.Inventory_024_055;
import code.model.TileRack_024_055;

public class InventoryTests {

	@Test
	public void sizeOfInventory() { // This test confirms that a new inventory
									// will have a size of 400.
		Inventory_024_055 i = new Inventory_024_055();
		int expected = 400;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

	@Test
	public void sizeAfterCreatingTileRack() { // This test confirms that a new
												// TileRack will take 12 Tiles
												// from the Inventory.
		Inventory_024_055 i = new Inventory_024_055();
		TileRack_024_055 t = new TileRack_024_055(i);
		int actual = i.getSize();
		int expected = 388;
		System.out.println("The size of the inventory is " + actual);
		assertTrue("the expected is " + expected + "the actual is " + actual,
				expected == actual);
	}

	@Test
	public void sizeAfterRemovingTiles() {// This test creates an inventory and
											// tilerack, then removes the tile
											// from the tilerack at position 0.
											// Then the refillIfNotFull method
											// refills the TileRack, using one
											// extra tile from the inventory
											// than the previous test.
		Inventory_024_055 i = new Inventory_024_055();
		TileRack_024_055 t = new TileRack_024_055(i);
		t.removeTile(0);
		t.fillRack();
		int expected = 387;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);

	}

	@Test
	public void sizeAfterCreatingMultipleTileRacks() {// This test confirms that
														// each Tilerack made
														// will always take 12
														// tiles from the
														// inventory.
		Inventory_024_055 i = new Inventory_024_055();
		TileRack_024_055 t = new TileRack_024_055(i);
		TileRack_024_055 t1 = new TileRack_024_055(i);
		TileRack_024_055 t2 = new TileRack_024_055(i);

		int expected = 364;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);

	}
}