package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Board;
import code.Inventory;
import code.Player;
import code.Tile;
import code.TileRack;

public class PlayerTests {

	@Test
	public void test() {
		Inventory inv = new Inventory();
		Board b = new Board();
		Player p1 = new Player("Adhish", b, inv);
		TileRack t = new TileRack(inv);
		p1.setTileRack(t);
		for(int i = 0; i<12; i++){
			t.remove(0);
		}
		t.addTile(new Tile('D'));
		t.addTile(new Tile('O'));
		t.addTile(new Tile('G'));
		System.out.println(t.getTile(1));
		p1.placeATileOnTheBoard(0, 2, 2);
		p1.placeATileOnTheBoard(1, 2, 3);
		p1.placeATileOnTheBoard(2, 2, 4);
		p1.moveComplete();
		int expected = 11;
		int actual = p1.getScore();
		
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
	}

}
