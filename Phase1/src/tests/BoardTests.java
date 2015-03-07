package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.Board;
import code.Tile;

public class BoardTests 
{
	@Test
	public void getTileTest() //This test confirms the functionality of the getTileAt test. An 'A' tile is placed on the board.
	{
		Tile t = new Tile('A');
		Board b = new Board();
		b.place(t, 15, 15);
		Tile actual = b.getTileAt(15, 15);
		Tile expected = t;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void removeTileTest() //This test confirms that the removeTile method works correctly. An 'A' tile is placed on the board and is then removed.
	{
		Tile t = new Tile('A');
		Board b = new Board();
		b.place(t, 15, 15);
		b.remove(15, 15);
		Tile actual = b.getTileAt(15, 15);
		Tile expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest() //This test confirms that the checkEmpty method works correctly. A new board does not contain any Tiles.
	{
		Board b = new Board();
		boolean expected = true ;
		boolean actual = b.isEmpty(1, 1);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest2() //This test confirms that the checkEmpty method will return false when there is a tile in that specific position on the board.
	{
		Tile t = new Tile('R');
		Board b = new Board();
		b.place(t, 10, 15);
		boolean expected = false;
		boolean actual = b.isEmpty(10, 15);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);

	}
}
