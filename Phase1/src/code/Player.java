package code;

import java.util.ArrayList;

public class Player {
    private String _name;
    private Board _board;
    private Inventory _inventory;
    private int _score;
    private TileRack _myTileRack;
    private ArrayList<Tile> _TilesMovedByPlayer;
    public Player(String name, Board b, Inventory inv){
    	//Unique name for every player
    	_name = name;
    	//Board common for all
    	_board = b;
    	//Inventory common for all
    	_inventory = inv;
    	//Creates a new TileRack for a player
    	_myTileRack = new TileRack(_inventory);
    	_TilesMovedByPlayer = new ArrayList<Tile>();
    }
    public int getScore(){
    	//returns the score. not yet implemented on how to calculate the score
    	return _score;
    }
    public void placeATileOnTheBoard(int indexTileRack, int xcoordinate, int ycoordinate){
    	//index of the rack from 0 to 11 (Selects a particular letter)
    	// xcoordinate and ycoordinate are the positions on the board
    	_board.place(_myTileRack.getTile(indexTileRack), xcoordinate , ycoordinate);
    	_TilesMovedByPlayer.add(_myTileRack.getTile(indexTileRack));
    	_myTileRack.remove(indexTileRack);
    	
   	 
    }
    public void moveComplete(){
        for(int i = 0; i<_TilesMovedByPlayer.size(); i++){
        Tile t =	_TilesMovedByPlayer.get(i);
        _score = _score + t.getValue();
        }
    	_myTileRack.refillIfNotFull();
    }
   
}
