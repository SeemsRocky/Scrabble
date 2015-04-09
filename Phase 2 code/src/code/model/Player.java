package code.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private ArrayList<Tile> _array;
	
	private  Board _board;
	
	private Tile _tile;
	
	private Color _c;

	/**
	 * Records the score.
	 */
	private int _score;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack _rack;
	//private Inventory _inv;
	private String _name;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv, String name, Color c){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack(inv);
		_c=c;
		ArrayList<Tile> rack = _rack.getTiles();
		for(int i =0; i<rack.size(); i++){
			rack.get(i).setColor(_c);
			rack.get(i).setPlayer(this);
		}
		_name = name;
		_array= new ArrayList<Tile>();
		
	}
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}

	/**
	 * Adds the new points to the original score
	 * 
	 * @param score Score to be added to
	 * @param i additional points added to the score
	 * @return Player's score.
	 */
	public int addScore(int score, int i){
		_score = score;
		_score = _score + i;
		return _score;
	}
	
	public TileRack getTileRack(){
		return _rack;
	}
	public String getName(){
		return _name;
	}
	
	public Color getColor(){
		return _c;
	}
	
	public void PlacingATile(int xcoordinate, int ycoordinate, int indexTileRack){
		if(_board.isEmpty(xcoordinate, ycoordinate)){
			_board.addTile(_rack.getTile(indexTileRack), xcoordinate, ycoordinate);
	    	_array.add(_rack.getTile(indexTileRack));
	    	_rack.removeTile(_rack.getTile(indexTileRack));
		}
	}
	
	public String wordToScore(Player p){
		String yo="";
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				Tile left=_board.getTile(i-1, j);
				Tile right= _board.getTile(i+1, j);
				Tile bottom= _board.getTile(i, j+1);
				Tile up= _board.getTile(i, j-1);
				
				if(_board.getTile(i, j)== _array.get(0)){
					int currentstate=0;
			     switch(currentstate){
			     case 0:
			    	 if(left!=null || right!=null){
			    		 currentstate=1;
			    	 }else
			    	 if(up!=null || bottom!=null){
			    		 currentstate=1;
			    	 }
			     }
				}
				
			}
			
		}
		return null;
		
	}
}