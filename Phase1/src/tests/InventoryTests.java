package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.TileRack;

public class InventoryTests {

	@Test
	public void test() {
		Inventory i = new Inventory();
		TileRack t = new TileRack(i);
		t.remove(1);
		t.remove(0);
		System.out.println("The size of the inventory is " + i.getSize());
		
		
		
	}

}
