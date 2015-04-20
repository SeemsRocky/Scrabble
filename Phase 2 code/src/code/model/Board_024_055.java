package code.model;

import java.util.ArrayList;
import java.util.Observable;

public class Board_024_055 extends Observable {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile_024_055[][] _board;
	/**
	 * width of the board
	 */
	private int _width; 
	/** 
	 * length of the board
	 */
	private int _length;

	/**
	 * Class constructor.
	 */
	public Board_024_055(int width, int length){
		_width = width;
		_length = length;
		_board = new Tile_024_055[_length][_width];
	    addLetterMultipliers();
	    addWordMultipliers();
	}
	
	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void addTile(Tile_024_055 t, int x, int y){
		if(this.isEmpty(x, y)){
			_board[x][y] = t;
		}
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return the tile that has been removed
	 */
	public Tile_024_055 removeTile(int x, int y){
		Tile_024_055 temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return Tile from the coordinates x and y of the Board
	 */
	public Tile_024_055 getTile(int x, int y){
		return _board[x][y];
	}
	/**
	 * 
	 * @return length of the Board in the game
	 */
	
	public int getLength(){
		return _length;
	}
	/**
	 * 
	 * @return width of the Board in the game
	 */
	public int getWidth(){
		return _width;
	}
/**
 * This method checks whether a place in the board whose x and y coordinates are specified is empty.
 * @param xcoordinate An int representing the x-coordinate of the Board
 * @param ycoordinate An int representing the y-coordinate of the Board
 * @return True is the place is empty, false otherwise
 * @author    driver: dkumar2 (Dhruv Kumar)
 * @author navigator: 
 */
	public boolean isEmpty(int xcoordinate, int ycoordinate) {
	
		return _board[xcoordinate][ycoordinate]==null;
	}
	/**
	 * Adds Word multipliers on board
	 *  @author    driver: rockylia (Rocky Liao)
	 *  @author navigator: fzhao2 (Feng Zhao)
	 */
	private void addWordMultipliers()
	{
		int numberOfTwoMulti = 40;
		int numberOfThreeMulti = 20;
		for(int y=0;y<_width;y++) // two word multiplier
		{
			for(int x=0;x<_length;x++)
			{
				int num = (int)(Math.random()*10);
				if(num>3 && numberOfTwoMulti>0 && _board[y][x].getLetterMultiplier()==1)
				{
					_board[y][x].setWordMultiplier(2);
					--numberOfTwoMulti;
				}
			}
		}
		for(int y=_width-1;y>=0;y--) // three word multiplier
		{
			for(int x=_length-1;x>=0;x--)
			{
				int num = (int)(Math.random()*10);
				if(num>3 && numberOfThreeMulti>0 && _board[y][x].getWordMultiplier()==1
					&& _board[y][x].getLetterMultiplier()==1)
				{
					_board[y][x].setWordMultiplier(3);
					--numberOfThreeMulti;
				}
			}
		}
	}
	/**
	 * Adds Letter multipliers on board
	 *  @author    driver: rockylia (Rocky Liao)
	 *  @author navigator: fzhao2 (Feng Zhao)
	 */
	private void addLetterMultipliers()
	{
		int numberOfTwoMulti = 60;
		int numberOfThreeMulti = 40;
		for(int y=0;y<_width;y++) // two letter multiplier
		{
			for(int x=0;x<_length;x++)
			{
				int num = (int)(Math.random()*10);
				if(num>3 && numberOfTwoMulti>0 && _board[y][x].getWordMultiplier()==1)
				{
					_board[y][x].setLetterMultiplier(3);
					--numberOfThreeMulti;
				}
			}
		}
		for(int y=_width-1;y>=0;y--) // three letter multiplier
		{
			for(int x=_length-1;x>=0;x--)
			{
				int num = (int)(Math.random()*10);
				if(num>3 && numberOfThreeMulti>0 && _board[y][x].getLetterMultiplier()==1
					&& _board[y][x].getWordMultiplier()==1)
				{
					_board[y][x].setLetterMultiplier(2);
					--numberOfTwoMulti;
				}
			}
		}
	}

}
