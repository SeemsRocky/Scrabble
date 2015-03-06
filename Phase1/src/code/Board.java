package code;

public class Board 
{
	private Tile[][] _Board;
	public Board()
	{
		_Board = new Tile[20][20];
	}
	//place tile from x,y
	public void place(Tile t,int x, int y) 
	{
		_Board[x][y] = t;
	}
	//remove tile from x,y
	public void remove(Tile t,int x, int y)
	{
		_Board[x][y] = null;
	}
	// checks if position is empty
	public boolean isEmpty(int x, int y)
	{
		
		return _Board[x][y]==null;
	}
	// returns the tile @ x,y
	public Tile getTileAt(int x, int y)
	{
		
		return _Board[x][y];
	}
	
}