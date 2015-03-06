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
	public void getScoreTest() {// This test confirms that the getScore method
								// is
		// functioning correctly. A TileRack is created but we
		// removed the random tiles so that we can have Tiles
		// that can be made into a word. The values of the
		// letters D, O, and G are added up.
		Inventory inv = new Inventory();
		Board b = new Board();
		Player p1 = new Player("Adhish", b, inv);
		TileRack t = new TileRack(inv);
		p1.setTileRack(t);
		for (int i = 0; i < 12; i++) {
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

		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);
	}

	@Test
	public void getNameTest() {
		Inventory inv = new Inventory();
		Board b = new Board();
		Player p1 = new Player("Adhish", b, inv);
		String expected = Adhish;
		String actual = p1.getName();
		assertTrue("The expected value was " + expected
				+ " but the value I got was " + actual, actual == expected);

	}
}
