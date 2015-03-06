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
	public void score() {
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
		
		p1.placeATileOnTheBoard(0, 2, 2);
		p1.placeATileOnTheBoard(0, 3, 2);
		p1.placeATileOnTheBoard(0, 4, 2);
		p1.moveComplete();
		int expected = 11;
		int actual = p1.getScore();
		
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
	}
	
	@Test
	public void scoreAgainBecauseWhyNot() {
		Inventory inv = new Inventory();
		Board b = new Board();
		Player p1 = new Player("Adhish", b, inv);
		TileRack t = new TileRack(inv);
		p1.setTileRack(t);
		for(int i = 0; i<12; i++){
			t.remove(0);
		}
		t.addTile(new Tile('S'));
		t.addTile(new Tile('A'));
		t.addTile(new Tile('V'));
		t.addTile(new Tile('E'));
		p1.placeATileOnTheBoard(0, 2, 2);
		p1.placeATileOnTheBoard(0, 3, 2);
		p1.placeATileOnTheBoard(0, 4, 2);
		p1.placeATileOnTheBoard(0, 5, 2);
		
		p1.moveComplete();
		int expected = 12;
		int actual = p1.getScore();
		
		assertTrue("The expected value was " + expected + " but the value I got was " + actual, actual==expected);
	}

}
