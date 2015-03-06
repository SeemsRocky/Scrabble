package code;

import java.util.ArrayList;

public class Player {
    private String _name;
    private Board _board;
    private Inventory _inventory;
    private int _score;
    private TileRack _myTileRack;
    private ArrayList<Tile> _TilesMovedByPlayer;
    
    
    /**
     * The constructor sets up the player with a name, the existing board and the inventory. It also
     * creates a TileRack for the player and an ArrayList of tiles which keeps track of the tiles moved by 
     * a player in a single turn.
     * @param name A string representing a player's name.
     * @param b Board of the game.
     * @param inv Inventory of the game. 
     */
    public Player(String name, Board b, Inventory inv){
    	_name = name;
    	_board = b;
    	_inventory = inv;
    	_myTileRack = new TileRack(_inventory);
    	_TilesMovedByPlayer = new ArrayList<Tile>();
    }

    /**
     * This method returns the current score of the player.
     * 
     * @return An int representing the player's score.
     */
    public int getScore(){
	
    
    	return _score;
    }
    /**
     * This method places a tile from the TileRack of the player to the board. It checks whether the board
     * is empty at that coordinate before putting the tile there. After placing the tile on the board, it adds
     * the tile to an ArrayList that keeps track of the tiles moved by a player in a single turn. Finally, the
     * tile is removed from the player's TileRack. 
     * @param indexTileRack An int representing the index of the TileRack.
     * @param xcoordinate An int representing the x-coordinate of the board.
     * @param ycoordinate 
     */
    public void placeATileOnTheBoard(int indexTileRack, int xcoordinate, int ycoordinate){
    	if(_board.isEmpty(xcoordinate, ycoordinate)){
    	_board.place(_myTileRack.getTile(indexTileRack), xcoordinate , ycoordinate);
    	_TilesMovedByPlayer.add(_myTileRack.getTile(indexTileRack));
    	_myTileRack.remove(indexTileRack);
    	}
   	 
    }
    public void moveComplete(){
        for(int i = 0; i<_TilesMovedByPlayer.size(); i++){
        Tile t =	_TilesMovedByPlayer.get(i);
        _score = _score + t.getValue();
        }
    	_myTileRack.refillIfNotFull();
    }
   
}
