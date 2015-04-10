package code.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Player_024_055 extends Observable {
	/**
	 * ArrayList of all the tiles in the line which consists of the word whose score is being calculated
	 */
	private ArrayList<Integer> _arrayOfTilesInLine;
	/**
	 * ArrayList of the tiles that a player has placed on the board from his/her TileRack
	 */
	private ArrayList<Tile_024_055> _array;
	/**
	 *  Instance Variable of the Board
	 */
	private  Board_024_055 _board;
	/**
	 * Instance Variable of the Tile
	 */
	private Tile_024_055 _tile;
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
	private TileRack_024_055 _rack;
	//private Inventory _inv;
	/**
	 * The name of the player
	 */
	private String _name;
	/**
	 * Checks if it is a real word
	 */
	private Dictionary_055 _wordChecker;

	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player_024_055(Inventory_024_055 inv, String name, Color c, Dictionary_055 wordChecker, Board_024_055 b){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack_024_055(inv);
		_c=c;
		_board = b;
		ArrayList<Tile_024_055> rack = _rack.getTiles();
		for(int i =0; i<rack.size(); i++){
			rack.get(i).setColor(_c);
			rack.get(i).setPlayer(this);
		}
		_name = name;
		_array= new ArrayList<Tile_024_055>();
		_wordChecker = wordChecker;
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
	/**
	 * This method is made so that it can be called when the user needs the TileRack associated with the player
	 * @return TileRack of the player
	 */
	public TileRack_024_055 getTileRack(){
		return _rack;
	}
	/**
	 * 
	 * @return The name of the Player
	 */
	public String getName(){
		return _name;
	}
	/**
	 * 
	 * @return The color associated with the Player
	 */
	public Color getColor(){
		return _c;
	}
	/**
	 * This method first checks if the Board is empty or not at a specified location.
	 *  If it is empty, it places the tile at that location on the Board. After placing the Tile,
	 *  it adds that Tile to an ArrayList that tells us the Tiles played by the player in a turn.
	 *  At the end, it removes that Tile from the Players TileRack.
	 * 
	 * @param xcoordinate An int representing the x-coordinate of the Board
	 * @param ycoordinate An int representing the y-coordinate of the Board
	 * @param indexTileRack An int representing the index of a Tile in the TileRack
	 * @author    driver: dkumar2 (Dhruv Kumar)
     * @author navigator: 
	 */

	 public void placeATileOnTheBoard(int xcoordinate, int ycoordinate, int indexTileRack){
		 System.out.println("A");
	    	if(_board.isEmpty(xcoordinate,ycoordinate)){
	    	_board.addTile(_rack.getTile(indexTileRack), xcoordinate,ycoordinate);
	    	_array.add(_rack.getTile(indexTileRack));
	    	_rack.removeTile(_rack.getTile(indexTileRack));
	    	}
	   	 
			 System.out.println("B");
	    	setChanged();
			 System.out.println("C");
	    	notifyObservers();
		}
		
/**
 * 
 * @author    driver: dkumar2 (Dhruv Kumar)
 * @author navigator: 
 */
	public void getarray(){
		ArrayList<Tile_024_055> array = new ArrayList<Tile_024_055>();
		_rack.getTiles();
	}
	/**
	 * This method loops through the Board and finds one of the character from the ArrayList of the tiles
	 * that the player used in his/her turn. When that letter is found, positions surrounding are checked.
	 * All the tiles of the row or column, in which the words were found, are then stored into an ArrayList.
	 * All the empty Tiles are removed from the ArrayList giving us the ArrayList of the word played by 
	 * the player. That word is then checked if it is in the Dictionary and if it is, and int representing 
	 * score is returned consisting of all the added values of the tiles in that ArrayList.
	 *
	 * @param p player on which this method is called
	 * @return An int representing the score a player after his/her turn
	 * @author    driver: dkumar2 (Dhruv Kumar)
     * @author navigator: 
	 */

	public int score(Player_024_055 p){
		ArrayList<Tile_024_055> finalarray= new ArrayList<Tile_024_055>();
		int finalscore=0;
		ArrayList<Tile_024_055> arrayOfFinalWord = new ArrayList<Tile_024_055>();
		for(int i=0; i<_board.getWidth();i++){
			if(i-1==0){
				i=_board.getWidth();
			} 
			for(int j=0;j<_board.getLength();j++){
				if(j-1==0){
					j=_board.getLength();
				}
				if(_board.getTile(i, j)!=null){
					if(_board.getTile(i, j+1).getColor() == _board.getTile(i, j-1).getColor()){
						if(_board.getTile(i, j).getColor() != _board.getTile(i, j+1).getColor()){
							_board.getTile(i, j).setColor(_board.getTile(i, j+1).getColor());
						} else {

						}
					}
					
				}
			}
		}
		int y=1;
		ArrayList<Tile_024_055> arrayOfTilesInLine = new ArrayList<Tile_024_055>();
		for(int i=0;i<_board.getWidth();i++){
			for(int j=0;j<_board.getLength();j++){
				Tile_024_055 left=_board.getTile(i-1, j);
				Tile_024_055 right= _board.getTile(i+1, j);
				Tile_024_055 down= _board.getTile(i, j+1);
				Tile_024_055 up= _board.getTile(i, j-1);
				if(_board.getTile(i, j)== _array.get(0)){
					if(left.getColor().equals(_board.getTile(i, j).getColor()) || right.getColor().equals(_board.getTile(i, j).getColor())){
						for(int x=1;x==_board.getWidth();x++){
							if(x-1==0){
								x=_board.getWidth();
							}
							if(_board.getTile(x, j)!=null && _board.getTile(x-1, j)==null){
								while(y<=20){
									if(_board.getTile(y, j).getColor()==p.getColor()){
										arrayOfTilesInLine.add(_board.getTile(y, j));
										y=y+1;
									}else {
										y=y+1;
									}
								}
							}	
						}
						for(int checkingfornull=0;checkingfornull<arrayOfTilesInLine.size();checkingfornull++){
							if(arrayOfTilesInLine.get(checkingfornull)!=null){
								arrayOfFinalWord.add(arrayOfTilesInLine.get(checkingfornull));
							} else {

							}
						}
						if(_board.getTile(i, j).getColor().equals(_board.getTile(i, j-1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i-1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j-1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i+1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j+1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i-1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j+1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i+1, j).getColor())){
							if(arrayOfFinalWord.size()==_array.size()){
								finalarray=arrayOfFinalWord;
							}else {

							}
						} else {

						}

					}
					if(up.getPlayer().getColor().equals(_board.getTile(j, j).getPlayer().getColor()) || down.getPlayer().getColor().equals(_board.getTile(i, j).getColor())){
						for(int x=1;x==_board.getLength();x++){
							if(x==0){
								x=_board.getLength();
							}
							if(_board.getTile(i, x)!=null && _board.getTile(i, x-1)==null){
								while(y<=_board.getLength()){
									if(_board.getTile(i, y).getColor()==p.getColor()){
										arrayOfTilesInLine.add(_board.getTile(i, y));
										y=y+1;
									}else {
										y=y+1;
									}
								}
							}

						}

						for(int checkingfornull=0;checkingfornull<arrayOfTilesInLine.size();checkingfornull++){
							if(arrayOfTilesInLine.get(checkingfornull)!=null){
								arrayOfFinalWord.add(arrayOfTilesInLine.get(checkingfornull));
							} else {

							}
						}
						if(_board.getTile(i, j).getColor().equals(_board.getTile(i, j-1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i-1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j-1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i+1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j+1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i-1, j).getColor()) || _board.getTile(i, j).getColor().equals(_board.getTile(i, j+1).getColor()) && _board.getTile(i, j).getColor().equals(_board.getTile(i+1, j).getColor())){
							if(arrayOfFinalWord.size()==_array.size()){
								finalarray=arrayOfFinalWord;
							}else {

							}
						} else {

						}

					}

				}

			}
		}
		for(int i=0;i<arrayOfFinalWord.size();i++){
			finalscore = finalscore + arrayOfFinalWord.get(i).getValue();
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
		}else {
			return 0;
		}
 
		
		_score = finalscore;
		return finalscore;
	}
/**
 * This method marks the end of a turn for the player. This method returns the score 
 * calculated in the method score. At last, if fills the empty spots of the TileRack
 * @return an int representing the score of the player after the end of his/her turn
 * @author    driver: dkumar2 (Dhruv Kumar)
 * @author navigator: 
 */
	public int moveComplete(){
		
		_rack.fillRack();
		return _score;
	}
	/**
	 * associates the TileRack given in the argument with the player
	 * @param t TileRack to be associated
	 */
	 public void setTileRack(TileRack_024_055 t){
	    	_rack = t;
	    }
	 
	 /**
		 * Gets the int value of the Player's score.
		 * 
		 * @return Player's score.
		 */
		public int getScore(){
			return _score;
		}
}
