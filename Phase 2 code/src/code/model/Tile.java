package code.model;

import java.awt.Color;

public class Tile {

	/**
	 * Stores the character of the tile.
	 */
	private char _letter;
	/**
	 * Stores the point value of the tile.
	 */
	private int _pointValue;
	
	private Color _color;
	
	private Player _player;
	
	/**
	 * Class constructor.
	 * 
	 * @param c character of the tile
	 * @param i point value of the tile
	 */
	public Tile(char c, int i){
		_letter = c;
		_pointValue = i;
	}
	
	/**
	 * Gets the character value of the tile.
	 * 
	 * @return character value of the tile.
	 */
	public char getChar(){
		return _letter;
	}
	
	/**
	 * Gets the point value of the tile.
	 * 
	 * @return the point value of the tile.
	 */
	public int getValue(){
		return _pointValue;
	}
	/**
	 * This method sets the color of the Tile to the color passed in the argument of the method
	 * @param c
	 * @return The color that has been associated to the tile
	 */
	
	public void setColor(Color c){
		_color = c;
	}
	
	public Color getColor(){
		return _color;
		
	}
	
	public void setPlayer(Player p){
		_player = p;
	}
	
	public Player getPlayer(){
		return _player;
	}
}
