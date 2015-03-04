package code;

public class Player {
    private String _name;
    private Board _board;
    private Inventory _inventory;
    private int _score;
    private TileRack _myTileRack;
    public Player(String name, Board b, Inventory inv){
    	//Unique name for every player
    	_name = name;
    	//Board common for all
    	_board = b;
    	//Inventory common for all
    	_inventory = inv;
    	//Creates a new TileRack for a player
    	_myTileRack = new TileRack(_inventory);
    }
    public int score(){
    	//returns the score. not yet implemented on how to calculate the score
    	return _score;
    }
    public void placeATileOnTheBoard(int i, int x, int y){
    	//index of the rack from 0 to 6 (Selects a particular letter)
    	// x and y are the positions on the board
    	_board.place(_myTileRack.getTile(i), x, y);
    	//should only be executed after the COMPLETE move is complete
    	_myTileRack.refillIfNotFull();
   	 
    }
   /* dont think this is right for player class lol
    * public void win()
    {
    	if(_myTileRack.getSize()==0 && _inventory.getSize()==0)
    	{
    		System.out.println("You won scrabble :D");
    	}
    	all the players skipped their turn?
    	 * 
    	
    	 
    }*/
}
