package code;

public class Board 
{
	private Tile[][] _Board;
	public Board()
	{
		//added 'new'
		_Board = new Tile[20][20];
	}
	//place tile from x,y
	public void place(Tile t,int x, int y) 
	{
		//Changed from Tile[x][y] to _Board[x][y]
		_Board[x][y] = t;
	}
	//remove tile from x,y
	public void remove(Tile t,int x, int y)
	{
	//Changed from Tile[x][y] to _Board[x][y]
		_Board[x][y] = null;
	}
	public boolean isEmpty(int x, int y)
	{
		// checks if position is empty
		return _Board[x][y]==null;
	}
	
}