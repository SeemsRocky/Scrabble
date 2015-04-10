package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.model.Board;
import code.model.Tile;

public class BoardTests 
{
	@Test
	public void getTileTest() //This test confirms the functionality of the getTileAt test. An 'A' tile is placed on the board.
	{
		Tile t = new Tile('A', 5);
		Board b = new Board(20,20);
		b.addTile(t, 15, 15);
		Tile actual = b.getTile(15, 15);
		Tile expected = t;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void removeTileTest() //This test confirms that the removeTile method works correctly. An 'A' tile is placed on the board and is then removed.
	{
		Tile t = new Tile('A', 1);
		Board b = new Board(20,20);
		b.addTile(t, 15, 15);
		b.removeTile(15, 15);
		Tile actual = b.getTile(15, 15);
		Tile expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest() //This test confirms that the checkEmpty method works correctly. A new board does not contain any Tiles.
	{
		Board b = new Board(20,20);
		boolean expected = true ;
		boolean actual = b.isEmpty(1, 1);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest2() //This test confirms that the checkEmpty method will return false when there is a tile in that specific position on the board.
	{
		Tile t = new Tile('R', 5);
		Board b = new Board(20,20);
		b.addTile(t, 10, 15);
		boolean expected = false;
		boolean actual = b.isEmpty(10, 15);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);

	}
}
