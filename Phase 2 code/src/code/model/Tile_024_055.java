package code.model;

import java.awt.Color;

public class Tile_024_055 {

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
	 * letter multiplier for tile
	 */
	private int _letterMultiplier;
	/**
	 * word multiplier for tile
	 */
	private int _wordMultiplier;
	/**
	 * Instance of Player for the methods getPlayer and setPlayer
	 */
	private Player_024_055 _player;
	
	/**
	 * Class constructor.
	 * 
	 * @param c character of the tile
	 * @param i point value of the tile
	 */
	public Tile_024_055(char c, int i){
		_letter = c;
		_pointValue = i;
		_wordMultiplier = 1;
		_letterMultiplier = 1;
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
	 * @author adhishch (Adhish Chugh)
	 */
	
	public void setPlayer(Player_024_055 p){
		_player = p;
	}
	/**
	 * @author adhishch (Adhish Chugh)
	 * @return player associated to a tile
	 */
	public Player_024_055 getPlayer(){
		return _player;
	}
	/**
	 * returns the String of the variable on which its called
	 * @author    driver:adhishch (Adhish Chugh)
     * @author navigator: 
	 */
	@Override
	public String toString() {
		String s = "";
		 s = s + this.getChar();
		return s;
	}
	/**
	 * Gets the  word multiplier associated with the tile
	 * @return the wordmultiplier
	 */
	public int getWordMultiplier()
	{
		return _wordMultiplier;
	}
	/**
	 * Gets the letter multiplier associated with the tile
	 * @return the letter multiplier
	 */
	public int getLetterMultiplier()
	{
		return _letterMultiplier;
	}
	/**
	 * Sets the word multiplier associated with the tile to i
	 * 
	 */
	public void setWordMultiplier(int i)
	{
		_wordMultiplier = i;
	}
	/**
	 * Sets the letter multiplier associated with the tile to i
	 * 
	 */
	public void setLetterMultiplier(int i)
	{
		_letterMultiplier = i;
	}
}
