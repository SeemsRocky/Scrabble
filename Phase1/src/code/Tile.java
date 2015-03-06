package code;

public class Tile {
	/**
	 * A char instance variable for the letter of the tile.
	 */
	private char _letter;
	
	/**
	 * An int instance variable for the value of the letter of the tile.
	 */
	private int _value;
	
	/**
	 * The constructor takes a character and assigns its value to the instance variable. 
	 * @param l A character representing the letter of the tile.
	 */
	public Tile(char l){
		_letter = l;
	}
	
	/**
	 * This methods returns the letter associated with a tile. 
	 * @return A char representing the letter of the tile.
	 */
	public char getLetter(){ 
		return _letter;
	}
	
	/**
	 * This method returns the value associated with the letter of the tile. 
	 * @return An int representing the value of the letter of the tile. 
	 */
	public int getValue(){     
		if(_letter=='Y'){
			return 2;
		}
		if(_letter=='A' || _letter=='E' || _letter=='I' || _letter=='O' || _letter=='U'){
			_value = 1;
		}
		else{
			_value = 5;
		}
		return _value;
	}
	
	/**
	 * This method helps print the letter of the tile. 
	 */
	@Override
	public String toString(){  
		String s = "" + _letter;
		return s;
		
	}
	
}
