package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.Board;
import code.Tile;

public class BoardTests 
{
	@Test
	public void getTileTest() 
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
	public void removeTileTest() 
	{
		Tile t = new Tile('A');
		Board b = new Board();
		b.place(t, 15, 15);
		b.remove(t, 15, 15);
		Tile actual = b.getTileAt(15, 15);
		Tile expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);

	}
	@Test
	public void checkEmptyTest() 
	{
		Board b = new Board();
		Tile actual = b.getTileAt(1,1);
		Tile expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);

	}
}
