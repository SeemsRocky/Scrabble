package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Inventory;
import code.Tile;
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
	public void newTileRackAndRefillTest() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		tr.getSize();
		int actual = tr.getSize();
		int expected = 12;
		assertTrue("", actual == expected);
	}
	@Test
	public void getTileTest() {
		Inventory inv = new Inventory();
		TileRack tr = new TileRack(inv);
		for(int i = 0; i<12; i++){
			tr.remove(0);
		}
		tr.addTile(new Tile('A'));
		char expected = 'A'; 
		Tile t =	tr.getTile(0);
	    char actual = t.getLetter();
		
		assertTrue("", actual == expected);
	}


}
