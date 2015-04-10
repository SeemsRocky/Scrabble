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
	/**
	 * Stores the color to be associated to a Tile
	 */
	private Color _color;
	/**
	 * Instance of Player for the methods getPlayer and setPlayer
	 */
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
	 * @param c color that we are going to set of the tile
	 * @return The color that has been associated to the tile
	 */
	
	public void setColor(Color c){
		_color = c;
	}
	/**
	 *  This methods returns the values of the color of the tile on which it is called
	 * @return The color of the tile
	 */
	
	public Color getColor(){
		return _color;
		
	}
	/**
	 * sets the player
	 * @param p player to set
	 */
	
	public void setPlayer(Player p){
		_player = p;
	}
	/**
	 * 
	 * @return player associated to a tile
	 */
	public Player getPlayer(){
		return _player;
	}
	
	@Override
	public String toString() {
		String s = "";
		 s = s + this.getChar();
		return s;
	}
	
	
}
