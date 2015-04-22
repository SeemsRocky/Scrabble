package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.model.Board_024_055;
import code.model.Tile_024_055;

public class BoardTests 
{
	@Test
	public void getTileTest() //This test confirms the functionality of the getTileAt test. An 'A' tile is placed on the board.
	{
		Tile_024_055 t = new Tile_024_055('A', 5);
		Board_024_055 b = new Board_024_055(20,20);
		b.addTile(t, 15, 15);
		Tile_024_055 actual = b.getTile(15, 15);
		Tile_024_055 expected = t;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void removeTileTest() //This test confirms that the removeTile method works correctly. An 'A' tile is placed on the board and is then removed.
	{
		Tile_024_055 t = new Tile_024_055('A', 1);
		Board_024_055 b = new Board_024_055(20,20);
		b.addTile(t, 15, 15);
		b.removeTile(15, 15);
		Tile_024_055 actual = b.getTile(15, 15);
		Tile_024_055 expected = null;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest() //This test confirms that the checkEmpty method works correctly. A new board does not contain any Tiles.
	{
		Board_024_055 b = new Board_024_055(20,20);
		boolean expected = true ;
		boolean actual = b.isEmpty(1, 1);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkEmptyTest2() //This test confirms that the checkEmpty method will return false when there is a tile in that specific position on the board.
	{
		Tile_024_055 t = new Tile_024_055('R', 5);
		Board_024_055 b = new Board_024_055(20,20);
		b.addTile(t, 10, 15);
		boolean expected = false;
		boolean actual = b.isEmpty(10, 15);
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);

	}
	@Test
	public void checkTwoLetterMultipliers()
	{
		Board_024_055 b = new Board_024_055(20,20);
	//	b.addLetterMultipliers();
		int actual =0;
		for(int x=0;x<20;x++)
		{
			for(int y=0;y<20;y++)
			{
				if(b.getTile(x,y).getLetterMultiplier()==2)
				{
					++actual;
				}
			}
		}
		int expected = 60;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkThreeLetterMultipliers()
	{
		Board_024_055 b = new Board_024_055(20,20);
	//	b.addLetterMultipliers();
		int actual =0;
		for(int x=0;x<20;x++)
		{
			for(int y=0;y<20;y++)
			{
				if(b.getTile(x,y) != null)
				{
					++actual;
				}
			}
		}
		int expected = 40;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected +
				"letter multiplier" + b.getTile(5,5).getLetterMultiplier()
				, actual == expected);
	}
	@Test
	public void checkTwoWordMultipliers()
	{
		Board_024_055 b = new Board_024_055(20,20);
	//	b.addWordMultipliers();
		int actual =0;
		for(int x=0;x<20;x++)
		{
			for(int y=0;y<20;y++)
			{
				if(b.getTile(x,y).getWordMultiplier()==2)
				{
					++actual;
				}
			}
		}
		int expected = 40;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
	@Test
	public void checkThreeWordMultipliers()
	{
		Board_024_055 b = new Board_024_055(20,20);
	//	b.addWordMultipliers();
		int actual =0;
		for(int x=0;x<20;x++)
		{
			for(int y=0;y<20;y++)
			{
				if(b.getTile(x,y).getWordMultiplier()==3)
				{
					++actual;
				}
			}
		}
		int expected = 20;
		assertTrue("The actual tile is " + actual+
				"the expected tile was " +expected, actual == expected);
	}
}
