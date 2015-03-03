package code;

public class Board 
{
	private Tile[][] _Board;
	public Board()
	{
		_Board = Tile[20][20];
	}
	//place tile from x,y
	public void place(Tile t,int x, int y) 
	{
		Tile[x][y] = t;
	}
	//remove tile from x,y
	public void remove(Tile t,int x, int y)
	{
		Tile[x][y] = null;
	}
}
