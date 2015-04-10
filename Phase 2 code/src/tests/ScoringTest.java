package tests;

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
		tilerack.removeTile(tilerack.getTile(0));
		tilerack.removeTile(tilerack.getTile(1));
		tilerack.removeTile(tilerack.getTile(2));
		tilerack.removeTile(tilerack.getTile(3));
		tilerack.removeTile(tilerack.getTile(4));
		tilerack.removeTile(tilerack.getTile(5));
		System.out.println(tilerack.getTiles().toString());
	}

}
