package code.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
	/**
	 * ArrayList of all the tiles in the line which consists of the word whose score is being calculated
	 */
	private ArrayList<Integer> _arrayOfTilesInLine;
	/**
	 * ArrayList of the tiles that a player has placed on the board from his/her TileRack
	 */
	private ArrayList<Tile> _array;
	/**
	 *  Instance Variable of the Board
	 */
	private  Board _board;
	/**
	 * Instance Variable of the Tile
	 */
	private Tile _tile;
	/**
	 * Instance Variable for the color of a player
	 */
	
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
	private Dictionary _wordChecker;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv, String name, Color c, Dictionary wordChecker){
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
		_wordChecker = wordChecker;
		
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
	
	public int wordToScore(Player p){
		int finalscore=0;
		ArrayList<Tile> arrayOfFinalWord = new ArrayList<Tile>();
		for(int i=0; i<20;i++){
			for(int j=0;j<20;j++){
				if(i==0){
					i=20;
				} else if(j==0){
					j=20;
				}
				if(_board.getTile(i, j)!=null){
					if(_board.getTile(i, j+1).getColor() == _board.getTile(i, j-1).getColor());
					if(_board.getTile(i, j).getColor() != _board.getTile(i, j+1).getColor()){
						_board.getTile(i, j).setColor(_board.getTile(i, j+1).getColor());
					} else {
						
					}
				}
			}
		}
		int y=1;
		ArrayList<Tile> arrayOfTilesInLine = new ArrayList<Tile>();
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				Tile left=_board.getTile(i-1, j);
				Tile right= _board.getTile(i+1, j);
				Tile down= _board.getTile(i, j+1);
				Tile up= _board.getTile(i, j-1);
				if(_board.getTile(i, j)== _array.get(0)){
					if(left.getPlayer().equals(_board.getTile(i, j).getPlayer()) || right.getPlayer().equals(_board.getTile(i, j).getPlayer())){
						for(int x=1;x==20;x++){
							if(x==0){
								x=20;
							}
							if(_board.getTile(x, j)!=null && _board.getTile(x-1, j)==null){
								while(y<=20){
									arrayOfTilesInLine.add(_board.getTile(y, j));
								}
								for(int checkingfornull=0;checkingfornull<arrayOfTilesInLine.size();checkingfornull++){
									if(arrayOfTilesInLine.get(checkingfornull)!=null){
										arrayOfFinalWord.add(arrayOfTilesInLine.get(checkingfornull));
									} else {
										
									}
								}
								
						}
					}
					if(up.getPlayer().equals(_board.getTile(j, j)) || down.getPlayer().equals(_board.getTile(i, j))){
						for(int x=1;x==20;x++){
							if(x==0){
								x=20;
							}
							if(_board.getTile(i, x)!=null && _board.getTile(i, x-1)==null){
								while(y<=20){
									arrayOfTilesInLine.add(_board.getTile(i, y));
								}
								for(int checkingfornull=0;checkingfornull<arrayOfTilesInLine.size();checkingfornull++){
									if(arrayOfTilesInLine.get(checkingfornull)!=null){
										arrayOfFinalWord.add(arrayOfTilesInLine.get(checkingfornull));
									} else {
										
									}
								
							}
						}
					}
				}
				
			}
			
		}
		
	}
}
		String s = "";
		for(int i=0;i<arrayOfFinalWord.size();i++){
			s=s+arrayOfFinalWord.get(i);
			s=(String)s;
		}
		if(_wordChecker.isAWord(s)==true){
			for(int i=0;i<arrayOfFinalWord.size();i++){
				finalscore = finalscore + arrayOfFinalWord.get(i).getValue();
			}
		}
		
		return finalscore;
}
	}