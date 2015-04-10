package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import code.model.Board;
import code.model.Dictionary;
import code.model.Inventory;
import code.model.Player;
import code.model.Tile;
import code.model.TileRack;

public class ScoringTest {

	@Test
	public void test() {
		Inventory inventory = new Inventory();
		TileRack tilerack = new TileRack(inventory);
		Dictionary d = new Dictionary("src/code/model/Dictionary.txt");
		Player p= new Player(inventory, "Dhruv", Color.RED, d);
		Board board = new Board(20,20);
		Tile tile1 = tilerack.getTile(1);
		p.PlacingATile(5, 5, 1);
		p.moveComplete();
		Tile expected = tile1; 
		Tile actual = board.getTile(5, 5);
		assertTrue(" I expected "+expected+" But got "+actual, expected==actual);
	}

}
