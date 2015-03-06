package code;

public class Board {
	/**
	 * An instance variable for the board of the game. 
	 */
	private Tile[][] _Board;
	
	/**
	 * The constructor initializes the instance variable to create a 20 by 20 board of tiles. 
	 */
	public Board()
	{
		_Board = new Tile[20][20];
	}
	
	/**
	 * This method takes a tile and two ints. It places that tile to the coordinates on the board
	 * specified by the two ints. 
	 * @param t A tile that has to be added to the board.
	 * @param x An int representing the x-coordinate of the board. 
	 * @param y An int representing the y-coordinate of the board.
	 */
	public void place(Tile t,int x, int y) 
	{
		_Board[x][y] = t;
	}
	
	/**
	 * This method takes a tile and two ints. It removes that tile from the coordinates on the board
	 * specified by the two ints. 
	 * @param t A tile that has to be removed from the board.
	 * @param x An int representing the x-coordinate of the board. 
	 * @param y An int representing the y-coordinate of the board.
	 */
	public void remove(Tile t,int x, int y)
	{
		_Board[x][y] = null;
	}
	
    /**
     * This method checks whether a position on the board is empty or not. 
     * @param x An int representing the x-coordinate of the board.
     * @param y An int representing the y-coordinate of the board.
     * @return A boolean which gives true if the board is empty at that coordinate and false otherwise.
     * 
     */
	public boolean isEmpty(int x, int y)
	{

		return _Board[x][y]==null;
	}
	
	/**
	 * This methods returns the tile that is placed at x and y. 
	 * @param x An int representing the x-coordinate of the board. 
	 * @param y An int representing the y-coordinate of the board.
	 * @return
	 */
	public Tile getTileAt(int x, int y)
	{

		return _Board[x][y];
	}

}