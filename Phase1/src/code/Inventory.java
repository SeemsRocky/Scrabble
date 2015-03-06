package code;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
	/**
	 * An array list of Tiles to store all the tiles 
	 */
    private ArrayList<Tile> _myInventory;
    /**
     * A constructor that first adds the vowels 29 times, then adds the letter y 15 times.
     * Then it adds all the other Letters 12 times to create the inventory of 400 tiles
     * Then shuffles all the tiles so it would be selected randomly.
     */
	public Inventory(){
		
		_myInventory = new ArrayList<Tile>();
		
		for(int i = 0; i < 29; i++){   
			String vowels = "AEIOU";
			for(int l = 0; l<vowels.length(); l++){
				char c = vowels.charAt(l);
				_myInventory.add(new Tile(c));
			}
		}
	
		for(int i = 0; i<15; i++){   
			_myInventory.add(new Tile('Y'));
		}
		for(int i = 0; i<12; i++){   
			String rest = "BCDFGHJKLMNPQRSTVWXZ";
			for(int l = 0; l<rest.length(); l++){
				char c = rest.charAt(l);
				_myInventory.add(new Tile(c));
			}
			
		}
		Collections.shuffle(_myInventory);  
	}
	/**
	 * It gets a tile at position i
	 * @param i an int at position i of inventory
	 * @return The tile at position i in the inventory
	 */
	public Tile getTile(int i){
		return _myInventory.get(i);  
	}
	/**
	 * It gets the size of the inventory
	 * @return the size of the inventory
	 */
	public int getSize(){
		return _myInventory.size();  
	}
	/**
	 * It removes a tile at position i
	 * @param i the position of the tile in the inventory
	 */
	public void remove(int i){
		_myInventory.remove(i);      
	}
}
