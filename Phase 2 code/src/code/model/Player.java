package code.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	Tile _tile;
	
	Color _c;

	/**
	 * Records the score.
	 */
	private int _score;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack _rack;
	//private Inventory _inv;
	private String _name;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv, String name, Color c){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack(inv);
		for(int i=0;i<_rack.getSize();i++){
			_rack.gettiles();
			_tile.setcolor(_c);
		}
		_name = name;
		_c=c;
	}
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}

	/**
	 * Adds the new points to the original score
	 * 
	 * @param score Score to be added to
	 * @param i additional points added to the score
	 * @return Player's score.
	 */
	public int addScore(int score, int i){
		_score = score;
		_score = _score + i;
		return _score;
	}
	
	public TileRack getTileRack(){
		return _rack;
	}
	public String getName(){
		return _name;
	}
	
}