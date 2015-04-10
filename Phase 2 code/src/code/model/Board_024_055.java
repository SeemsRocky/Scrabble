package code.model;

import java.util.Observable;

public class Board_024_055 extends Observable {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile_024_055[][] _board;
	
	private int _width; 
	private int _length;

	/**
	 * Class constructor.
	 */
	public Board_024_055(int width, int length){
		_width = width;
		_length = length;
		_board = new Tile_024_055[_length][_width];
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
	 * @return
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
 */
	public boolean isEmpty(int xcoordinate, int ycoordinate) {
	
		return _board[xcoordinate][ycoordinate]==null;
	}

	

}
