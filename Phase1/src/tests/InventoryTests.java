package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.TileRack;


public class InventoryTests {

	@Test
	public void sizeOfInventory() {
		Inventory i = new Inventory();
		int expected = 400;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
	}
	
	@Test
	public void sizeAfterCreatingTileRack() {
		Inventory i = new Inventory();
		TileRack t = new TileRack(i);
     	int actual = i.getSize();
		int expected = 388;
		System.out.println("The size of the inventory is "+actual);
		assertTrue( "the expected is " + expected 
				+ "the actual is " + actual,
				expected==actual);
	}
	
	@Test
	public void sizeAfterRemovingTiles() {
		Inventory i = new Inventory();
		TileRack t = new TileRack(i);
		t.remove(0);
		t.refillIfNotFull();
		int expected = 387;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
		
	}
	@Test
	public void sizeAfterCreatingMultipleTileRacks() {
		Inventory i = new Inventory();
		TileRack t = new TileRack(i);
		TileRack t1 = new TileRack(i);
		TileRack t2 = new TileRack(i);
		
		int expected = 364;
		int actual = i.getSize();
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
		
	}
}