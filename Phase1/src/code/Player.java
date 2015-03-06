package code;

import java.util.ArrayList;

public class Player {
	/**
	 * A string instance variable for the name of the player.
	 */
    private String _name;
    
    /**
     * An instance variable for the board of the game.
     */
    private Board _board;
    
    /**
     * An instance variable for the inventory of the game.
     */
    private Inventory _inventory;
    
    /**
     * An instance variable for the score of the player.
     */
    private int _score;
    
    /**
     * An int instance variable for the TileRack of the player.
     */
    private TileRack _myTileRack;
    
    /**
     * An instance variable for the tiles moved by the player in one move.
     */
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
     * This method returns the name of the player.
     * @return A string representing the player's name.
     */
    public String getName(){
    	return _name;
    }
    
    /**
     * This method places a tile from the TileRack of the player to the board. It checks whether the board
     * is empty at that coordinate before putting the tile there. After placing the tile on the board, it adds
     * the tile to an ArrayList that keeps track of the tiles moved by a player in a single turn. Finally, the
     * tile is removed from the player's TileRack. 
     * @param indexTileRack An int representing the index of the TileRack.
     * @param xcoordinate An int representing the x-coordinate of the board.
     * @param ycoordinate An int representing the y-coordinate of the board.
     */
    public void placeATileOnTheBoard(int indexTileRack, int xcoordinate, int ycoordinate){
    	if(_board.isEmpty(xcoordinate, ycoordinate)){
    	_board.place(_myTileRack.getTile(indexTileRack), xcoordinate , ycoordinate);
    	_TilesMovedByPlayer.add(_myTileRack.getTile(indexTileRack));
    	_myTileRack.removeTile(_myTileRack.getTile(indexTileRack));
    	}
   	 
    }
    
    /**
     * This method marks the end of the turn for a player. Then, it calculates the score of the player
     * using the ArrayList that keeps track of all the tiles placed on the board in one move. Finally,
     * it checks whether the TileRack is full or not. If it's not full, it ensures that tiles from the
     * inventory are used to fill the TileRack again.
     */
    public void moveComplete(){
        for(int i = 0; i<_TilesMovedByPlayer.size(); i++){
        Tile t =	_TilesMovedByPlayer.get(i);
        _score = _score + t.getValue();
        }
    	_myTileRack.refillIfNotFull();
    }
    
    /**
     * This method is solely for the purpose of testing the score mechanism. 
     * @param t TileRack that has to be set as the TileRack of the player.
     */
    public void setTileRack(TileRack t){
    	_myTileRack = t;
    }
   
}
