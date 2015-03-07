package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import code.Board;
import code.Tile;

public class BoardTests 
{
	@Test
	public void getTileTest() //This test confirms the functionality of the getTileAt test 
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
		b.remove(15, 15);
		Tile actual = b.getTileAt(15, 15);
		Tile expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest() 
	{
		Board b = new Board();
		boolean expected = true ;
		boolean actual = b.isEmpty(1, 1);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest2() 
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
