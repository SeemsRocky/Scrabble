package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.TileRack;

public class InventoryTests {

	@Test
	public void test() {
		Inventory i = new Inventory();
		for(int l = 0; l<400; l++){
			System.out.println(i.getTile(l));
		}
		TileRack t = new TileRack(i);
		t.remove(1);
		t.remove(0);
		int size = i.getSize();
		int expected = 388;
		System.out.println("The size of the inventory is "+size);
		assertTrue( "the expected is " + expected 
				+ "the actual is " + size,
				expected==size);
	}
	@Test
	public void test2() {
		Inventory i = new Inventory();
		for(int l = 0; l<400; l++){
			System.out.println(i.getTile(l));
		}
		TileRack t1 = new TileRack(i);
		TileRack t2 = new TileRack(i);
		t1.remove(1);
		t1.remove(0);
		t2.remove(1);
		t2.remove(0);
		t1.refillIfNotFull();
		t2.refillIfNotFull();
		int size = i.getSize();
		int expected = 372;
		System.out.println("The size of the inventory is "+size);
		assertTrue( "the expected is " + expected 
				+ "the actual is " + size,
				expected==size);
	}
}
